package com.azshop.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class UploadImage {
	public static String UploadImageToLocal(String attributeName, HttpServletRequest request, String storateLocation)
			throws IOException, ServletException {
		Part part = request.getPart(attributeName);
		if (part == null) {
			return "";
		}
		String saveTime = String.valueOf(System.currentTimeMillis());
		String storageFileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

		if (storageFileName != null) {
			int dotIndex = storageFileName.lastIndexOf(".");
			if (dotIndex >= 0) {
				String part1 = storageFileName.substring(0, dotIndex);
				String part2 = storageFileName.substring(dotIndex);
				storageFileName = part1 + "_" + saveTime + part2;
			}

			if (!Files.exists(Paths.get(storateLocation))) {
				Files.createDirectories(Paths.get(storateLocation));
			}
			if (part.getSize() > 0) {
				part.write(storateLocation + "/" + storageFileName);
				return storageFileName;
			}
		}
		return "";
	}
}
