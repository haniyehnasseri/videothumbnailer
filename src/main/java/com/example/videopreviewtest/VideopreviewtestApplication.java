package com.example.videopreviewtest;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

@SpringBootApplication
public class VideopreviewtestApplication {

    public static void main(String[] args) throws FFmpegFrameGrabber.Exception {
        SpringApplication.run(VideopreviewtestApplication.class, args);
        FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber("https://storage.phoenix.mahsan.net/appstore-develop-public/sample_960x540.mpeg");
        frameGrabber.start();
        Frame f;
        try {
            Java2DFrameConverter c = new Java2DFrameConverter();
            f = frameGrabber.grabImage();
            BufferedImage bi = c.convert(f);
            ImageIO.write(bi, "png", new File("d.png"));
            frameGrabber.stop();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
