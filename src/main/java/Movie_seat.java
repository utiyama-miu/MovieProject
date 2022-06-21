

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
