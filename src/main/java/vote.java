

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		DatabaseManager db = new DatabaseManager();
		java.sql.Connection conn = db.getConnection();
		
		String voternumber = request.getParameter("voterNumber");
		String partie = request.getParameter("partie");
		HttpSession session = request.getSession();
		
		try {
			
			PreparedStatement ps1 = conn.prepareStatement("select voter_card_number from temp_vc_num where voter_card_number = '"+voternumber+"'");
			ResultSet rs1= ps1.executeQuery("select voter_card_number from temp_vc_num where voter_card_number = '"+voternumber+"'");
			if(rs1.next()) {
				response.sendRedirect("votercheck.jsp");
			}else {
				PreparedStatement prepareStatement1 = conn.prepareStatement("insert into temp_vc_num (voter_card_number)values('"+voternumber+"')");
				PreparedStatement prepareStatement2 = conn.prepareStatement("insert into vote (voter_card_number,partie)values('"+voternumber+"','"+partie+"')");
			    prepareStatement1.executeUpdate();
			    prepareStatement2.executeUpdate();
			    session.removeAttribute("name");
			    session.removeAttribute("number");
			    session.removeAttribute("email");
			    session.removeAttribute("address");
			    session.removeAttribute("dob");
			    session.removeAttribute("voterid");
			    response.sendRedirect("thankyou.jsp");
			}
		}catch(SQLException e) {
			out.println(e.getMessage());
		}
	}

}
