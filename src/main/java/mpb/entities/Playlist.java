package mpb.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Playlist implements MPBEntity<Playlist> {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String iconPath;
	private List<Music> musics;

	public Playlist() {
		musics = new ArrayList<>();
	}

	public Playlist(Long id, String name, String iconPath) {
		this();
		this.id = id;
		this.name = name;
		this.iconPath = iconPath;
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

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public List<Music> getMusics() {
		return musics;
	}

	@Override
	public int compareTo(Playlist o) {
		return getName().compareTo(o.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		return Objects.equals(name, other.name);
	}

}
