package ma.ac.esi.referentielCompetences.model;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class ConnectBd {
	private String url ="jdbc:mysql://localhost:3306/comp" ;
	private String username = "root";
	private String password = "";
	private Connection con ;
	public ConnectBd() {
	}
	public ConnectBd(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}
	public void initCon() {
		if (this.con == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.con = DriverManager.getConnection(url,username,password);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Connection getConnection() {
		return this.con;
	}
	public User FindUser(String Login, String Password) throws Exception,NoSuchUserException {
		initCon();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users where login = ? and password = ?");
		pstmt.setString(1, Login);
		pstmt.setString(2, Password);
		ResultSet res  = pstmt.executeQuery();
		boolean nxt = res.next();
		System.out.println("ConnectBd.FindUser: Resultset.next() : "+nxt);
		if (!nxt) throw new NoSuchUserException();
		User user = new User();
		String login = res.getString(2);
		String password = res.getString(3);
		user.setLogin(login);
		user.setPassword(password);
		con.close();
		return user;
		
	}
}
