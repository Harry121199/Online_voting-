

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class adminregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public adminregister() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			String name=request.getParameter("name");
			String employeeid=request.getParameter("employeeid");
			String voternumber=request.getParameter("voternumber");
			String password=request.getParameter("password");
			
			DatabaseManager db = new DatabaseManager();
			java.sql.Connection conn = db.getConnection();
			
			PreparedStatement prepareStatement = conn.prepareStatement("insert into admin(employeeid,adminName,adminPass)values('"+employeeid+"','"+name+"','"+password+"')");
			prepareStatement.executeUpdate();
			response.sendRedirect("adminregsuccess.jsp");
			//response.sendRedirect("index.jsp");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
