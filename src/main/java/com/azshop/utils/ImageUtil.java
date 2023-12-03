package com.azshop.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageUtil {

    public static void deleteImage(String imageName) {
        try {
        	String imagePath = Constant.DIR + "\\" + imageName;
            Path path = Paths.get(imagePath);

            // Check if the file exists before attempting to delete
            if (Files.exists(path)) {
                Files.delete(path);
                System.out.println("Image deleted successfully.");
            } else {
                System.out.println("Image not found at the specified path.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}