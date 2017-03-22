package mypckg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.util.Version;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class MyClass
 */
@WebServlet("/students")
public class students extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public students() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("<h1>Hi!! I am a Servlet</h1>");
		Connection con = null;
	    Statement st = null;
	    ResultSet rs = null;

	    String url = "jdbc:mysql://localhost/student";
	    String user = "root";
	    String password = "qwer1234";

		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        con = DriverManager.getConnection(url, user, password);
	        st = con.createStatement();
	        rs = st.executeQuery("SELECT * FROM student;");
	        request.setAttribute("data", rs);
//	        con.close();

	    } catch (SQLException | ClassNotFoundException ex) {
	        Logger lgr = Logger.getLogger(Version.class.getName());
	        lgr.log(Level.SEVERE, ex.getMessage(), ex);

	    }
//			try {
//				rs.next();
//				s = rs.getString("fname");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				s = "no";
//			}
//	    response.getWriter().append(s);
	    request.setAttribute("data", rs);
//	    
        request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
