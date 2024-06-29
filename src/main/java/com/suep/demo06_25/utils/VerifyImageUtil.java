package com.suep.demo06_25.utils;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

//这个总感觉不太舒服


public class VerifyImageUtil {
    static String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    static final int WIDTH = 120;
    static final int HEIGHT = 40;
    static final int CODE_COUNT = 4;
    static final int LINE_COUNT = 20;
    static final int[] FONT_SIZES = {26, 28, 30, 32, 34};
    public static String verifyStr;
    public static Image generateCaptchaImageView() throws IOException {


        Random random = new Random();


        // 生成随机验证码
        String captcha = generateCaptcha();

        // 创建一个 BufferedImage 来绘制验证码
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        // 设置背景色
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        // 随机设置字体和颜色,但这里还不完善
        g2d.setFont(new Font(null, Font.BOLD, FONT_SIZES[random.nextInt(FONT_SIZES.length)]));
        g2d.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));

        // 绘制验证码到 BufferedImage
        String captchaString = String.valueOf(captcha);
        g2d.drawString(captchaString, (WIDTH - g2d.getFontMetrics().stringWidth(captchaString)) / 2, HEIGHT/ 2 + g2d.getFontMetrics().getAscent() / 2);
        // 搞点噪点
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            g2d.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            g2d.drawOval(x, y, 1, 1);
        }
        // 搞点干扰线
        for (int i = 0; i < LINE_COUNT; i++) {
            g2d.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            g2d.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT), random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }

        // 释放 Graphics2D 资源
        g2d.dispose();

        // 将 BufferedImage 转换为 JavaFX Image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return new Image(new ByteArrayInputStream(imageInByte));
    }

    private static String generateCaptcha() {
        Random random = new Random();
        StringBuilder captcha = new StringBuilder(CODE_COUNT);

        // 先随机添加一个字母和一个数字
        for (int i = 0; i < 2; i++) {
            captcha.append(CHARACTERS.charAt(random.nextInt(52))); // 字母
            captcha.append(CHARACTERS.charAt(51+random.nextInt(10))); // 数字

        }


        // 打乱验证码的顺序以增加安全性
        for (int i = captcha.length() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = captcha.charAt(index);
            captcha.setCharAt(index, captcha.charAt(i));
            captcha.setCharAt(i, temp);
        }
        verifyStr=captcha.toString();
        return captcha.toString();
    }
}
