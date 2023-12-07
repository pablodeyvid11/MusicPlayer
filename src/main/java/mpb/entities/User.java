package mpb.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import mpb.entities.enums.UserType;
import mpb.util.Hash;

public class User implements MPBEntity<User> {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String password;
	private UserType userType;
	private List<Music> musics;
	private List<String> directories;

	public User() {
		musics = new ArrayList<>();
		directories = new ArrayList<>();
	}

	public User(Long id, String name, String email, UserType userType, String password) {
		this();
		this.id = id;
		this.name = name;
		this.email = email;
		this.userType = userType;
		this.setPassword(password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Hash.hashPassword(password);
	}

	public List<Music> getMusics() {
		return musics;
	}

	public List<String> getDirectories() {
		return directories;
	}

	@Override
	public int compareTo(User o) {
		return getEmail().compareTo(o.getEmail());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", userType="
				+ userType + ", musics=" + musics + ", directories=" + directories + "]";
	}
}