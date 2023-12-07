package mpb;

import mpb.dao.UserDao;
import mpb.entities.User;
import mpb.entities.enums.UserType;

public class MainTest {
	public static void main(String[] args) throws Exception {
//		User u1 = new User(null, "Pablo", "pablo.paiva.123", UserType.NORMAL, "123");
		
		UserDao ud = new UserDao();
		
//		ud.persist(u1);
		
		ud.findAll().forEach(System.out::println);
		
	}
}
