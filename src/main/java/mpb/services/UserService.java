package mpb.services;

import java.security.InvalidParameterException;

import mpb.dao.UserDao;
import mpb.entities.User;
import mpb.util.Hash;

public class UserService {

	private User userLogged;

	private UserDao userDao;

	public UserService() {
		this.userDao = new UserDao();
		try {
			this.userLogged = userDao.loadUserDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("");
	}

	public void persist(User entity) throws Exception {
		userDao.persist(entity);
	}

	public void login(String email, String password) throws Exception {
		User user = userDao.findAll().stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);

		if (user == null) {
			throw new InvalidParameterException("Usuário não encontrado");
		}

		String passwordHash = Hash.hashPassword(password);

		if (!user.getPassword().equals(passwordHash)) {
			throw new InvalidParameterException("Senha incorreta");
		}

		userLogged = user;
		userDao.writeLoggedUser(userLogged);
	}

	public User getUserLogged() {
		return userLogged;
	}
}
