package cn.qkl.webserver.service;

/**
 * @Author sunxiaen
 * @Date 2023/6/30 9:03
 **/
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class CertificateGenerator extends JPanel {

    private static final int WIDTH = 800;  // 证书宽度
    private static final int HEIGHT = 600; // 证书高度
    private static final String BACKGROUND_IMAGE_PATH = "background.jpg"; // 背景图片路径
    private static final String OUTPUT_IMAGE_PATH = "certificate.png"; // 输出图片路径

    private String title; // 标题
    private String[] lines; // 文本行

    public CertificateGenerator(String title, String[] lines) {
        this.title = title;
        this.lines = lines;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // 加载背景图片
        try {
            BufferedImage backgroundImage = ImageIO.read(new File(BACKGROUND_IMAGE_PATH));
            g2d.drawImage(backgroundImage, 0, 0, WIDTH, HEIGHT, this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 绘制标题
        g2d.setFont(new Font("Arial", Font.BOLD, 32));
        g2d.setColor(Color.BLACK);
        g2d.drawString(title, 50, 100);

        // 绘制文本行
        g2d.setFont(new Font("Arial", Font.PLAIN, 24));
        g2d.setColor(Color.BLACK);

        int startY = 200; // 文本行的起始Y坐标
        int lineHeight = 40; // 每行的高度

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            int stringWidth = g2d.getFontMetrics().stringWidth(line);
            int startX = (WIDTH - stringWidth) / 2; // 居中文本的起始X坐标
            int startYOffset = startY + i * lineHeight; // 每行文本的Y坐标偏移量
            g2d.drawString(line, startX, startYOffset);
        }

        // 导出为图片
        try {
            BufferedImage certificateImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            Graphics2D imageGraphics = certificateImage.createGraphics();
//            this.paint(imageGraphics);
            ImageIO.write(certificateImage, "png", new File(OUTPUT_IMAGE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String title = "证书标题";
        String[] lines = {
                "第一行文本",
                "第二行文本",
                "第三行文本"
        };

        CertificateGenerator certificate = new CertificateGenerator(title, lines);

        JFrame frame = new JFrame("证书生成器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.add(certificate);
        frame.setVisible(true);
    }
}

