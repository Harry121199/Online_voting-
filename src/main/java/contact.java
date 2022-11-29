

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class contact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		DatabaseManager db = new DatabaseManager();
		java.sql.Connection conn = db.getConnection();
		
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		
		try {
			PreparedStatement preparestatement = conn.prepareStatement("insert into contactus(name,number,email,comment)values('"+name+"','"+number+"','"+email+"','"+comment+"')");
			preparestatement.executeUpdate();
			response.sendRedirect("index.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
