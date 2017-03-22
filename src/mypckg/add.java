package mypckg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.util.Version;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("/SoftLab/students");
        request.getRequestDispatcher("add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con = null;
	    Statement st = null;
	    int rs;

	    String url = "jdbc:mysql://localhost/student";
	    String user = "root";
	    String password = "qwer1234";
	    String roll_no = request.getParameter("roll_no");
	    String fname = request.getParameter("fname");
	    String lname = request.getParameter("lname");
	    String msg;

		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        con = DriverManager.getConnection(url, user, password);
	        st = con.createStatement();
	        rs = st.executeUpdate("insert into student values(" + roll_no + ", '" + fname + "', '" + lname + "' );");
	        
	        if(rs > 0)
	        	msg = "Success";
	        else
	        	msg = "Failure";
	        
	        con.close();

	    } catch (SQLException | ClassNotFoundException ex) {
	    	msg = "Something went wrong";
	        Logger lgr = Logger.getLogger(Version.class.getName());
	        lgr.log(Level.SEVERE, ex.getMessage(), ex);

	    }
		
	    request.setAttribute("msg", msg);
        request.getRequestDispatcher("add.jsp").forward(request, response);
		
//		response.getWriter().append("Post Request recived.");
//		doGet(request, response);
	}

}
