package mpb.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import mpb.entities.MPBEntity;

public abstract class AbstractDao<T extends MPBEntity<T>> {

	private String pathToFile;
	private ArrayList<T> content;
	private Class<T> clazz;

	protected AbstractDao(Class<T> clazz) {
		this.clazz = clazz;

		String pathBase = System.getProperty("user.dir");
		String separator = System.getProperty("file.separator");
		String pathRelative = "/src/main/resources/db/" + clazz.getName() + ".ser";

		this.pathToFile = pathBase + pathRelative.replace("/", separator);

		try {
			load();
		} catch (Exception e) {
			content = new ArrayList<>();
		}
	}

	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		FileInputStream file = new FileInputStream(pathToFile);
		ObjectInputStream in = new ObjectInputStream(file);
		content = (ArrayList<T>) in.readObject();
		if(content == null) content = new ArrayList<>();
		in.close();
		file.close();
		for (long i = 0; i < content.size(); i++) {
			content.get((int) i).setId(i);
		}
	}

	private void write() throws Exception {
		FileOutputStream file = new FileOutputStream(pathToFile);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(content);
		out.close();
		file.close();
		load();
	}

	public String getPathToFile() {
		return pathToFile;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void persist(T entity) throws Exception {
		content.add(entity);
		write();
	}

	public ArrayList<T> findAll() {
		return content;
	}
}
