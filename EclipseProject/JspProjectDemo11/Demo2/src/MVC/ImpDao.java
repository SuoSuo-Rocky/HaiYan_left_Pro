package MVC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;



public class ImpDao implements  UserDAO {
     Connection conn=DBUtil.getconn();
     
     
	@Override
	public void delete(int id) {
	Statement  stmt=null;
	try {
		stmt=conn.createStatement();
		stmt.executeUpdate("delete from user_1 where userid="+id);
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return;
	}

	@Override
	public List<User_1> findall() {
		Statement  stmt=null;
		List<User_1> list=new Vector<User_1>();
		ResultSet  rs=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from User_1");
			while (rs.next()) {
				User_1 u=new User_1();
				u.setUserid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User_1  findid(int id) {
		ResultSet rs;
		User_1 u=null;
		Statement stmt =null;
	
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from user_1  where userid="+id);
			while (rs.next()) {
				u=new User_1();
				u.setUserid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int  insert(User_1 u) {
		PreparedStatement  stmt =null;
		int rs=0;
		try {
			stmt=conn.prepareStatement("insert into user_1(userid,username,password) values(?,?,?)");
				stmt.setInt(1,u.getUserid() );
				stmt.setString(2,u.getUsername());
				stmt.setString(3,u.getPassword());
				
				System.out.println("yuchulichenggong");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("yuchulishibai");
		}
		
		
		try {
		
			rs=stmt.executeUpdate();
			System.out.println(rs+"row");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public int  update(User_1 u) {
		PreparedStatement  stmt=null;
		int rs=0;
		try {
			stmt=conn.prepareStatement("update user_1 set username=?,password=? where userid=?");
			stmt.setString(1,u.getUsername() );
			stmt.setString(2,u.getPassword());
			stmt.setInt(3,u.getUserid());
			rs=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return rs;
	}
       
}
