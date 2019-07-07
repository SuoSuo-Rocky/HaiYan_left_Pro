package MVC;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		UserDAO shi = new ImpDao();
		List<User_1> list=new Vector<User_1>();
		list=new ImpDao().findall();
		for(int i=0;i<list.size();i++){
			User_1 user=list.get(i);
			System.out.println("id=" + user.getUserid() + "\t" + "username="
					+ user.getUsername() + "\t" + "password=" + user.getPassword());
		}
		
	/*	for(User_1 user : list){
			System.out.println("id=" + user.getUserid() + "\t" + "username="
		+ user.getUsername() + "\t" + "password=" + user.getPassword());
		}*/
		  //添加记录
/*		  User_1 u=new User_1(); // 
		  u.setUserid(10000);
		 u.setUsername("laoshi");
		 u.setPassword("1235460000074964");
		  Hinsert(new ImpDao(),u);
		*/
		
		/*
		 * User_1 u=new User_1();
		 *  u.setUsername("wangba");
		 * u.setPassword("111111111"); 
		 * u.setUserid(10000);
		 *  Hupdate(new ImpDao(),u);
		 */

		// Hdelete(new ImpDao(),10000);
		
		
		
       //根据 id  号 查找 记录
//		User_1 u = Hfindid(new ImpDao(), 16401);
//		System.out.println("id=" + u.getUserid() + "\n" + "username="
//				+ u.getUsername() + "\n" + "password=" + u.getPassword());

	}

	private static User_1 Hfindid(UserDAO dao, int id) {
		return dao.findid(id);

	}

	private static void Hdelete(UserDAO dao, int id) {
		dao.delete(id);

	}

	private static void Hupdate(UserDAO dao, User_1 u) {
		dao.update(u);

	}

	private static void Hinsert(UserDAO dao, User_1 u) {
		dao.insert(u);

	}

}
