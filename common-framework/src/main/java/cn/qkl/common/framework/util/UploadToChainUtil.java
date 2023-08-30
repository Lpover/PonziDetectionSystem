package cn.qkl.common.framework.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import cn.qkl.common.framework.config.ChainProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @param
 * @return
 */
@Component

public class UploadToChainUtil {
    private static final Logger log = LoggerFactory.getLogger(UploadToChainUtil.class);
//    @Autowired
    ChainProperties chainProperties;

    private String sk;
    private String url;
    private String skId;
    private String txHash;
    private String txTime;
    private List<String> res;

    public UploadToChainUtil(ChainProperties chainProperties) {
        this.chainProperties = chainProperties;
        this.sk = chainProperties.getSk();
        this.url = chainProperties.getUrl();
        this.skId = chainProperties.getSkId();
    }

    public String getTxHash() {
        return res.get(0);
    }

    public Date getTxTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(res.get(1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void uploadToChain(String str) throws JsonProcessingException {
        long timeStamp = System.currentTimeMillis();
        String sn = postMd5(str, timeStamp);
        String body = HttpRequest.post(url + "/api/v1/upChain/text")
                .header("nft-sk-id", skId)
                .header("nft-sk", sn)
                .header("nft-timestamp", String.valueOf(timeStamp))
                .body(JSONUtil.toJsonStr(str))
                .contentType("application/json")
                .execute().body();

        String txTime = "";
        String txHash = "";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(body);
            JsonNode dataNode = root.path("data");
            txTime = dataNode.path("txTime").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(body);
            JsonNode dataNode = root.path("data");
            txHash = dataNode.path("txHash").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        res = new ArrayList<>();
        res.add(txHash);
        res.add(txTime);

    }

    /**
     * 文件流计算哈希
     * @param inputStream
     * @param algorithm
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public String calculateHash(InputStream inputStream, String algorithm) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            messageDigest.update(buffer, 0, bytesRead);
        }

        byte[] hashBytes = messageDigest.digest();
        StringBuilder hexString = new StringBuilder();

        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xFF & hashByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    private String getMd5(Map<String, String[]> parametersRaw, Long timestamp) {
        // 1.所有的参数按照key排序
        TreeMap<String, String[]> parameters = new TreeMap<>(parametersRaw);
        StringBuilder paramSB = new StringBuilder();
        boolean first = true;
        // 2. 拼接所有参数，形式为key1=param1&key2=param2
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            if (!first) {
                paramSB.append("&");
            } else {
                first = false;
            }
            paramSB.append(entry.getKey()).append("=");
            // 3. 数组型参数的拼接：中括号括住，中间用逗号分隔
            paramSB.append(arrayToString(entry.getValue()));
        }
        // 4. 末尾拼接上私钥，使用MD5计算hash
        paramSB.append(sk);
        // 5. 拼接上当前时间戳
        paramSB.append(timestamp);
        String sn = DigestUtils.md5DigestAsHex(paramSB.toString().getBytes(StandardCharsets.UTF_8));
//        System.out.println("最终签名为:" + sn);
        return sn;
    }

    /**
     * 将数组参数组合成一个字符串
     * @param strings
     * @return
     */
    private String arrayToString(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        if (strings.length == 1) {
            return strings[0];
        }
        Arrays.sort(strings);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (String s : strings) {
            if (first) {
                first = false;
            } else {
                sb.append(",");
            }
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * post签名
     * @param o
     * @param timestamp
     * @return
     * @throws JsonProcessingException
     */
    private String postMd5(Object o, Long timestamp) throws JsonProcessingException {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        SimpleModule simpleModule = new SimpleModule();
        objectMapper.registerModule(simpleModule);
        objectMapper.setTimeZone(TimeZone.getDefault());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String paramJson = (o == null) ? "" : objectMapper.writeValueAsString(o);
        // Md5签名
        String sn = DigestUtils.md5DigestAsHex((paramJson + sk + timestamp).getBytes(StandardCharsets.UTF_8));
        System.out.println("最终签名为: " + sn);
        return sn;
    }

}
