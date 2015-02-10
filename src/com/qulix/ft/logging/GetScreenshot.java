package com.qulix.ft.logging;

import com.qulix.ft.teachingSite.tests.AbstractTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * ������ ����������
 */
public class GetScreenshot {

    /**
     * ������� �������� ��������� ��������
     *
     * @return ���� ���������
     * @see org.openqa.selenium.TakesScreenshot
     */
    public static File fromDriver() {
        return fromDriver(AbstractTest.driver);
    }

    /**
     * ������� �������� ��������
     *
     * @param driver �������
     * @return ���� ���������
     */
    public static File fromDriver(WebDriver driver) {
        try {
            Robot robot = new Robot();
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            BufferedImage bi = robot.createScreenCapture(new Rectangle(0, 0, dimension.width, dimension.height));
            File tempFile = File.createTempFile("screenShot", ".jpg");
            ImageIO.write(bi, "jpg", tempFile);
            return tempFile;
        } catch (Exception e) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        }
    }
}
