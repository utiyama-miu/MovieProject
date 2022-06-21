

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Movie_Login
 */
@WebServlet("/Movie_Login")
public class Movie_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Movie_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mv_id =request.getParameter("mv_id");
		String s_year=request.getParameter("year");
		String s_month=request.getParameter("month");
		String day=request.getParameter("day");
		String time=request.getParameter("time");
		String seat=request.getParameter("seat");
		
		request.setAttribute("year",s_year);
		request.setAttribute("month",s_month);
		request.setAttribute("day",day);
		request.setAttribute("mv_id",mv_id);
		request.setAttribute("time",time);
		request.setAttribute("seat",seat);
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/movie_login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("user_id");
		String password = request.getParameter("password");
		String mv_id =request.getParameter("mv_id");
		String s_year=request.getParameter("year");
		String s_month=request.getParameter("month");
		String day=request.getParameter("day");
		String time=request.getParameter("time");
		String seat=request.getParameter("seat");
		request.setAttribute("year",s_year);
		request.setAttribute("month",s_month);
		request.setAttribute("day",day);
		request.setAttribute("mv_id",mv_id);
		request.setAttribute("time",time);
		request.setAttribute("seat",seat);
		

		String path = "";

		try {
			// PostgreSQLに接続するためのURL
			String url = "jdbc:postgresql://localhost:5432/sampledb";
			String user = "postgres";
			String pass = "postgres";

			
			String sql = "SELECT * FROM login WHERE id=? AND password=?";

			// PostgreSQLに接続する
			Class.forName("org.postgresql.Driver");
			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setString(1, userId);
				pstmt.setString(2, password);

				ResultSet res = pstmt.executeQuery();

				
				if (res.next()) {
					request.setAttribute("user_id", res.getString("id"));
					request.setAttribute("password", res.getString("password"));
					
					path = "/WEB-INF/movie_receive.jsp";
				} else {
					request.setAttribute("loginFailure", "ログインに失敗しました");

					// ログインに失敗したときはもう一度ログイン画面を表示する
					path = "/WEB-INF/movie_login.jsp";
				}
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
