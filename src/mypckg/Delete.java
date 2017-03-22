package mypckg;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.corba.se.impl.util.Version;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
	    Statement st = null;
	    int rs;

	    String url = "jdbc:mysql://localhost/student";
	    String user = "root";
	    String password = "qwer1234";
	    String roll_no = request.getParameter("roll_no");
//	    String msg;

		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        con = (Connection) DriverManager.getConnection(url, user, password);
	        st = (Statement) con.createStatement();
	        rs = st.executeUpdate("DELETE FROM student WHERE roll_no = " + roll_no + ";");
	        
//	        if(rs > 0)
//	        	msg = "Success";
//	        else
//	        	msg = "Failure";
//	        
	        con.close();

	    } catch (SQLException | ClassNotFoundException ex) {
//	    	msg = "Somethig went wrong";
	        Logger lgr = Logger.getLogger(Version.class.getName());
	        lgr.log(Level.SEVERE, ((Throwable) ex).getMessage(), ex);

	    }
		
		response.sendRedirect("/SoftLab/students");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
