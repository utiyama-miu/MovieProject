

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
 * Servlet implementation class member_Login
 */
@WebServlet("/member_Login")
public class member_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public member_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/member_login.jsp");
		rd.forward(request, response);
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String userId = request.getParameter("user_id");
				String password = request.getParameter("password");
				//リクエストパラメータを取得

				String path = "";

				try {
					// PostgreSQLに接続するためのURL
					String url = "jdbc:postgresql://localhost:5432/sampledb";
					String user = "postgres"; //ostgreSQLに接続するためのuser
					String pass = "postgres"; //ostgreSQLに接続するためのpass
					String sql = "SELECT * FROM login WHERE id=? AND password=?"; //実行するsql文

					// PostgreSQLに接続する
					Class.forName("org.postgresql.Driver");
					try (Connection con = DriverManager.getConnection(url, user, pass);
							PreparedStatement pstmt = con.prepareStatement(sql)) {

						pstmt.setString(1, userId);
						pstmt.setString(2, password);
						//sqlのパラメータを設定

						ResultSet res = pstmt.executeQuery();

						
						if (res.next()) {
							request.setAttribute("user_id", res.getString("id"));
							request.setAttribute("password", res.getString("password"));
							//スコープでデータを設定する為のやつ


							path = "/WEB-INF/member_page.jsp";
						} else {
							request.setAttribute("loginFailure", "ログインに失敗しました");

							// ログインに失敗したときのpath
							path = "/WEB-INF/member_login.jsp";
						}
					}
				}catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

				RequestDispatcher rd = request.getRequestDispatcher(path);
				//ServletからJSPを表示するためのインターフェイスでpathを指定
				rd.forward(request, response);
				//path指定のJSPへ飛ばす
	}

}
