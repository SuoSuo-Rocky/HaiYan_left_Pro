import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	String url = "jdbc:mysql://localhost:3306/mydb";
	String user= "root";
	String password = "666666";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "select * from userlogin";
	public Demo() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		System.out.println("��������ʧ��");
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("��ȡ���Ӷ���ʧ��");
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				for(int i = 1; i<= 3; i++){
					System.out.println(rs.getString(i)+"\t");
				}
				System.out.println("\n");
			}
			
			
		} catch (SQLException e) {
		System.out.println("��ȡִ���������ʧ��");
		}
		
		
		
	}
public static void main(String[] args) {
	 new Demo();
}
}
