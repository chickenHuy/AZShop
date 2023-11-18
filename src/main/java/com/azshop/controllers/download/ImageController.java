package com.azshop.controllers.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.azshop.utils.Constant;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/image"})
public class ImageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("fname");
		File file = new File(Constant.DIR + "/" + fileName);
		resp.setContentType("image/jpeg");
		if (file.exists())
		{
			IOUtils.copy(new FileInputStream(file),resp.getOutputStream());
		}
		else {
			 System.out.println("File not found: " + file.getAbsolutePath());
	         resp.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
		}
	}
}