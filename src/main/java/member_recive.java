

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class member_recive
 */
@WebServlet("/member_recive")
public class member_recive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public member_recive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("id");
		String password=request.getParameter("password");
		    Connection conn = null;
	        PreparedStatement ps = null;
	        List<movie_receive> movie1 = new ArrayList<>();
	        //DB接続情報を設定する
	        String path = "jdbc:postgresql://localhost:5432/sampledb";  //接続パス
	        String id = "postgres";    //ログインID
	        String pw = "postgres";  //ログインパスワード

	        //SQL文を定義する
	        String sql = "SELECT * FROM movie_receive WHERE user_id=? AND password=?";

	        try {
	            //JDBCドライバをロードする
	            Class.forName("org.postgresql.Driver");

	            //DBへのコネクションを作成する
	            conn = DriverManager.getConnection(path, id, pw); conn.setAutoCommit(false);  //オートコミットはオフ

	            //実行するSQL文とパラメータを指定する
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, userId);
	            ps.setString(2,password);
	            

	            //INSERT文を実行する
	            ResultSet res = ps.executeQuery();


	            //処理件数を表示する
	            while(res.next()) {
	            	request.setAttribute("user_id", res.getString("id"));
					request.setAttribute("password", res.getString("password"));
					String ps_ = res.getString("password");
					String userid = res.getString("user_id");
					String mv_id = res.getString("mv_id");
					String year = res.getString("year");
					String month = res.getString("month");
					String day = res.getString("day");
					String time = res.getString("time");
					String seat = res.getString("seat");
					
					movie1.add(new movie_receive(userid,ps_,mv_id,year,month,day,time,seat));

				}
				

	        } catch (Exception ex) {
	            //例外発生時の処理
	            ex.printStackTrace();  //エラー内容をコンソールに出力する

	        } finally {
	            //クローズ処理
	            request.setAttribute("movie_receive", movie1);
			    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/member_receive.jsp");
	            rd.forward(request, response);
	        }

	    
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	}
}
