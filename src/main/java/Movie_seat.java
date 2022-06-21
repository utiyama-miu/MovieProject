

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.movie_receive;

/**
 * Servlet implementation class Movie_seat
 */
@WebServlet("/Movie_seat")
public class Movie_seat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Movie_seat() {
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
		request.setAttribute("year",s_year);
		request.setAttribute("month",s_month);
		request.setAttribute("day",day);
		request.setAttribute("mv_id",mv_id);
		request.setAttribute("time",time);
		
		String url = "jdbc:postgresql://localhost:5432/sampledb";
		String user = "postgres";
		String password = "postgres";

		// 本のタイトルを格納するList
		List<movie_receive> movie = new ArrayList<>();

		
		try {
			Class.forName("org.postgresql.Driver");

			try (Connection con = DriverManager.getConnection(url, user, password);
					Statement st = con.createStatement();){

				
				ResultSet res = st.executeQuery("SELECT * from movie_receive");

			
				while(res.next()) {
					String seat = res.getString("seat");
					
					movie.add(new movie_receive(seat));
				}
				res.close();
				st.close();

			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		// リクエストスコープへオブジェクト設定する
		request.setAttribute("movie_table", movie);

		// 次の画面に遷移
		
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/movie_seat.jsp");
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
