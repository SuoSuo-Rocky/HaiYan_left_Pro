package MVC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
private static String url="jdbc:mysql://localhost:3306/mydb";
private static String user="root";
private static String password="666666";
private static Connection  conn=null;
static{
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("qudongchenggong");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
		System.out.println("qudongshibai");
	}
	try {
		
		
		conn=DriverManager.getConnection(url, user, password);
		System.out.println("lianjiechenggong");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("lianjieshibai");
	}
}
public  static  Connection getconn(){
	return conn;
}


}
