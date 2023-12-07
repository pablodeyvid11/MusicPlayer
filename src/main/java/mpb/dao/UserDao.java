package mpb.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import mpb.entities.User;

public class UserDao extends AbstractDao<User> {

	public UserDao() {
		super(User.class);
	}

	@Override
	public void persist(User entity) throws Exception {
		User newUser = findAll().stream().filter((u) -> u.getEmail().equals(entity.getEmail())).findFirst()
				.orElse(null);
		if (newUser == null) {
			super.persist(entity);
		} else {
			throw new Exception("Email já cadastrado");
		}
	}

	public void writeLoggedUser(User user) throws Exception {
		String pathBase = System.getProperty("user.dir");
		String separator = System.getProperty("file.separator");
		String pathRelative = pathBase + "/src/main/resources/db/loggedUser.ser".replace("/", separator);

		FileOutputStream file = new FileOutputStream(pathRelative);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(user);
		out.close();
		file.close();
	}
	
	public User loadUserDao() throws Exception {
		
		User userLogged = null;
		
		String pathBase = System.getProperty("user.dir");
		String separator = System.getProperty("file.separator");
		String pathRelative = pathBase + "/src/main/resources/db/loggedUser.ser".replace("/", separator);

		FileInputStream file = new FileInputStream(pathRelative);
		ObjectInputStream in = new ObjectInputStream(file);
		userLogged = (User) in.readObject();
		in.close();
		file.close();
		
		return userLogged;
	}
}
