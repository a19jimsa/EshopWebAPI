package com.eshop.Eshop.Service;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class ImageService {
    private BufferedImage createImageFromBytes(byte[] imageData) {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void resizeImage(Path imageUri, int targetWidth, int targetHeight) throws IOException{
        File outputfile = new File(imageUri.toUri());
        BufferedImage bufferedImage = ImageIO.read(outputfile);
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(bufferedImage, 0,0,targetWidth, targetHeight, null);
        graphics2D.dispose();
        ImageIO.write(resizedImage, "jpg", outputfile);
    }


}