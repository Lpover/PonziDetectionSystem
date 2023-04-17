package cn.qkl.common.framework.auth;

import cn.qkl.common.framework.exception.ClientException;
import cn.qkl.common.framework.exception.ServerException;
import cn.qkl.common.framework.exception.UnauthorizedException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public final class TokenHandler {
    private static AuthProperties authProperties;

    private static final String TOKEN_KEY = "token_bean";
    private static final String USER_MODEL_KEY = "user_model";

    private TokenHandler(AuthProperties authProperties) {
        TokenHandler.authProperties = authProperties;
    }

    /**
     * 根据给出的AppUser信息生成虚构的token
     *
     * @param tokenBean token中保存的信息
     * @return 用户信息生成的token
     */
    public static String generateToken(TokenBean tokenBean) {
        Objects.requireNonNull(tokenBean);
        Map<String, Object> data = new HashMap<>();
        data.put(TokenHandler.TOKEN_KEY, JSONUtil.toJsonStr(tokenBean));
        return TokenHandler.generateToken(TokenHandler.authProperties.getSecret(), data, authProperties.getExpiration(), AuthProperties.TIME_UNIT);
    }

    public static String generateToken(String secret, Map<String, Object> data, long expiration, TimeUnit timeUnit) {
        if (secret == null || secret.isEmpty()) {
            throw new ServerException("Secret cannot be empty");
        }
        Objects.requireNonNull(data);
        Objects.requireNonNull(timeUnit);
        if (expiration <= 0) {
            log.debug("expiration:{}", expiration);
            throw new ServerException("Expiration must be greater than 0");
        }
        return Jwts.builder()
                .setClaims(data)
                .setExpiration(new Date(System.currentTimeMillis() + timeUnit.toMillis(expiration)))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 检查Token是否正确
     */
    public static TokenBean checkToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader(TokenHandler.authProperties.getHeader());
        if (StrUtil.isEmpty(token)) {
            throw new UnauthorizedException("Please log in first");
        }
        Claims data;
        try {
            data = Jwts.parser()
                    .setSigningKey(TokenHandler.authProperties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new UnauthorizedException("Authorization expires");
        } catch (Exception e) {
            throw new ClientException("JWT format validation failed, token:[" + token + "]");
        }
        if (data == null) {
            throw new ServerException("Token parsing exception, data is null, token:[" + token + "]");
        }
        return JSONUtil.toBean(data.get(TokenHandler.TOKEN_KEY, String.class), TokenBean.class);
    }

    public static void setTokenBean(TokenBean tokenBean) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        request.setAttribute(TokenHandler.TOKEN_KEY, tokenBean);
    }

    public static TokenBean getTokenBean() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return (TokenBean) request.getAttribute(TokenHandler.TOKEN_KEY);
    }

    public static long getUserId() {
        return getTokenBean().getRoleId();
    }

    public static String getUserType() {
        return getTokenBean().getRoleType();
    }

    public static String getUuid() {
        return getTokenBean().getUuid();
    }

    public static void setUserModel(Object roleModel) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        request.setAttribute(TokenHandler.USER_MODEL_KEY, roleModel);
    }

    public static Object getUserModel() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request.getAttribute(TokenHandler.USER_MODEL_KEY);
    }
}