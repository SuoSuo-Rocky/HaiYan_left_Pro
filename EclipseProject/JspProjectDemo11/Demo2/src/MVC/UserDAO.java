package MVC;
import java.util.List;


public interface UserDAO {
public int  insert(User_1 u);
public int  update(User_1 u);
public  void delete(int id);
public List<User_1> findall();
public User_1  findid(int id );

}
