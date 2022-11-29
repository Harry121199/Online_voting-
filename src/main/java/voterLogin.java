

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class voterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public voterLogin() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String voternum = request.getParameter("voterNumber");
		//we are checking is the current user has voted or not..
		DatabaseManager db = new DatabaseManager();
		java.sql.Connection conn = db.getConnection();
		try {
			PreparedStatement prepareStatement1 = conn.prepareStatement("select voter_card_number from temp_vc_num where voter_card_number = '"+voternum+"'");
			ResultSet rs1= prepareStatement1.executeQuery("select voter_card_number from temp_vc_num where voter_card_number = '"+voternum+"'");
			if(rs1.next()) {
				response.sendRedirect("votercheck.jsp");
			}else {
				PreparedStatement prepareStatement2 = conn.prepareStatement("select name,pnumber,email,vc_number,adress,dob from voters where vc_number = '"+voternum+"'");
				ResultSet rs2 = prepareStatement2.executeQuery("select name,pnumber,email,adress,dob from voters where vc_number = '"+voternum+"'");
				if(rs2.next()) {
					String name = rs2.getString("name");
					String number = rs2.getString("pnumber");
					String email = rs2.getString("email");
					String address = rs2.getString("adress");
					String dob = rs2.getString("dob");
					
					HttpSession session = request.getSession();
					session.setAttribute("voterid",voternum);
					session.setAttribute("name",name);
					session.setAttribute("email",email);
					session.setAttribute("address",address);
					session.setAttribute("number",number);
					session.setAttribute("dob",dob);
					
					response.sendRedirect("details.jsp");
				}else {
					response.sendRedirect("registrationpage.jsp");
				}
			}
		}catch(Exception ex) {
			out.println(ex.getMessage());
		}
	}

}
