

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Receive_delete
 */
@WebServlet("/Receive_delete")
public class Receive_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Receive_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字化けのやつ入れる
		String userId=request.getParameter("user_id");
		String pass=request.getParameter("password");
		String mv_id=request.getParameter("mv_id");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String time=request.getParameter("time");
		String seat=request.getParameter("seat");
		
		
		Connection conn = null;
        PreparedStatement ps = null;
       
        //DB接続情報を設定する
        String path = "jdbc:postgresql://localhost:5432/sampledb";  //接続パス
        String id = "postgres";    //ログインID
        String pw = "postgres";  //ログインパスワード

        //SQL文を定義する
        String sql = "DELETE FROM movie_receive WHERE user_id=? AND password=? AND year=? AND month=? AND day=? AND seat=? AND time=? AND mv_id=? ";

        try {
            //JDBCドライバをロードする
            Class.forName("org.postgresql.Driver");

            //DBへのコネクションを作成する
            conn = DriverManager.getConnection(path, id, pw); conn.setAutoCommit(false);  //オートコミットはオフ

            //実行するSQL文とパラメータを指定する
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2,pass);
            ps.setString(3, year);
            ps.setString(4,month);
            ps.setString(5, day);
            ps.setString(6,seat);
            ps.setString(7, time);
            ps.setString(8,mv_id);

            ps.executeUpdate();
        } catch (Exception ex) {
            //例外発生時の処理
            ex.printStackTrace();  //エラー内容をコンソールに出力する

        } finally {
            //クローズ処理
        	
		    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Delete_success.jsp");
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
