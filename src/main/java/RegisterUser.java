

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterUser() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()) {
			String name=request.getParameter("name");
			String pnumber=request.getParameter("number");
			String email = request.getParameter("email");
			String vc_number=request.getParameter("voternumber");
			String adress=request.getParameter("adress");
			String dob=request.getParameter("dob");
			
			DatabaseManager db = new DatabaseManager();
			java.sql.Connection conn = db.getConnection();
			
			
			PreparedStatement prepareStatement = conn.prepareStatement("insert into voters(name,pnumber,email,vc_number,adress,dob)values('"+name+"','"+pnumber+"','"+email+"','"+vc_number+"','"+adress+"','"+dob+"')");
			prepareStatement.executeUpdate();
			response.sendRedirect("registersucces.jsp");
			//response.sendRedirect("index.jsp");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
