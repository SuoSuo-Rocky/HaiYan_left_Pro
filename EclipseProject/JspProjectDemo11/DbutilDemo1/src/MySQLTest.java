
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLTest {

 
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("驱动加载失败！！！！");
        }
        Connection  conn=null;
        String url="jdbc:mysql://localhost:3306/test";
          String user="root";
            String password="666666";
            //添加
            //String sql="insert into user(id , password) values ('zhang','666666')";
            //修改
            //String sql = "update user set id='zhagnxueqiang',password='999999' where id='shiwei'";
            //删除
            //String sql = "delete from user where password ='666666'";
        try {
            conn=DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("连接失败，请查看账号和密码是否正确！");
        }
        Statement stmt=null;
        try {
            stmt=conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("命令对象创建失败！");
        }
        ResultSet rs;
        try {
        	//查询表的所有记录
           rs=stmt.executeQuery("select * from user");
            while (rs.next()) {            
             for (int i = 1; i < 3; i++) {
                 String str=rs.getString(i);
                 System.out.print(str+"\t\t");
               }
                System.out.println();
        }
     
        	//向表中添加记录
        	//rs=stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
