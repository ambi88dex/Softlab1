package mypckg;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
	    Statement st = null;
	    ResultSet rs = null;

	    String url = "jdbc:mysql://localhost/student";
	    String user = "root";
	    String password = "qwer1234";
	    String roll_no = request.getParameter("roll_no");
//	    String msg;

		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        con = (Connection) DriverManager.getConnection(url, user, password);
	        st = (Statement) con.createStatement();
	        rs = st.executeQuery("SELECT * FROM student WHERE roll_no = " + roll_no + ";");

			rs.next();
		    request.setAttribute("roll", String.valueOf(rs.getInt("roll_no")));
		    request.setAttribute("fname", rs.getString("fname"));
		    request.setAttribute("lname", rs.getString("lname"));
		    
		    con.close();

	    } catch (SQLException | ClassNotFoundException ex) {
//	    	msg = "Something went wrong";
	        Logger lgr = Logger.getLogger(Version.class.getName());
	        lgr.log(Level.SEVERE, ((Throwable) ex).getMessage(), ex);

	    }
        request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
	    Statement st = null;
	    int rs=0;

	    String url = "jdbc:mysql://localhost/student";
	    String user = "root";
	    String password = "qwer1234";
	    String roll_no = request.getParameter("roll_no");
	    String fname = request.getParameter("fname");
	    String lname = request.getParameter("lname");
	    String msg;

		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        con = (Connection) DriverManager.getConnection(url, user, password);
	        st = (Statement) con.createStatement();
	        rs = st.executeUpdate("UPDATE student SET fname='" + fname + "', lname='" + lname + "' WHERE roll_no=" + roll_no + ";");
	        
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
	}

}
