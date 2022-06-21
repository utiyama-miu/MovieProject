

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Movie_receive2
 */
@WebServlet("/Movie_receive2")
public class Movie_receive2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Movie_receive2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("user_id");
		String password = request.getParameter("pass");
		String mv_id =request.getParameter("mv_id");
		String s_year=request.getParameter("year");
		String s_month=request.getParameter("month");
		String day=request.getParameter("day");
		String time=request.getParameter("time");
		String seat=request.getParameter("seat");
		
		

		String path = "";

		try {
			// PostgreSQLに接続するためのURL
			String url = "jdbc:postgresql://localhost:5432/sampledb";
			String user = "postgres";
			String pass = "postgres";

			
			String sql = "insert into movie_receive(user_id,password,mv_id,year,month,day,seat,time) VALUES(?,?,?,?,?,?,?,?)";

			// PostgreSQLに接続する
			Class.forName("org.postgresql.Driver");
			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				

				pstmt.setString(1, userId);
				pstmt.setString(2, password);
				pstmt.setString(3, mv_id);
				pstmt.setString(4, s_year);
				pstmt.setString(5,s_month);
				pstmt.setString(6, day);
				pstmt.setString(7, seat);
				pstmt.setString(8, time);

				 pstmt.executeUpdate();
				

				// ResultSet res = pstmt.executeQuery();
				
					

					path = "/WEB-INF/receive_success.jsp";
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		

		
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
