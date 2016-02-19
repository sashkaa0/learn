package Servlets;

import Controlle.SearchController;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="PdfContent", urlPatterns=("/PdfContent"))
public class ShowImage extends HttpServlet {
	protected void procesRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
		response.setContentType("image/jpg");
		OutputStream out = response.getOutputStream();
		try {
			int id = Integer.valueOf(request.getParameter("id_book"));
			SearchController sc=(SearchController) request.getSession(false).getAttribute("searchController");
                        byte[]image=sc.getImage(id);
                        response.setContentLength(image.length);
                        out.write(image);
		} finally {
			out.close();
		}
	}
}
