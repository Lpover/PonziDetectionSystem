package cn.qkl.common.framework.util;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Component
public class WebCaptureUtil {
    public RenderedImage webCapture(String url) throws MalformedURLException,
            IOException, URISyntaxException, AWTException {
        // 此方法仅适用于JdK1.6及以上版本
        if (Desktop.isDesktopSupported()) {
            System.out.println("Desktop IS supported on this platform");

            if (Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                System.out.println("Action BROWSE  IS supported on this platform");
            }
            else {
                System.out.println("Action BROWSE  ISN'T supported on this platform");
            }
        }
        else {
            System.out.println("Desktop ISN'T supported on this platform");
        }
        Desktop.getDesktop().browse(new URL(url).toURI());
        Robot robot = new Robot();
        robot.delay(10000);
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        int width = (int) d.getWidth();
        int height = (int) d.getHeight();
        // 最大化浏览器
        robot.keyRelease(KeyEvent.VK_F11);
        robot.delay(2000);
        Image image = robot.createScreenCapture(new Rectangle(0, 0, width,height));
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        return (RenderedImage) image;
    }
}