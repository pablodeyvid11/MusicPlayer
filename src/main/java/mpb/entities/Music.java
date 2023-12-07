package mpb.entities;

import java.util.Objects;

public class Music implements MPBEntity<Music> {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String albumName;
	private String singerName;
	private String musicPath;
	private String iconPath;
	private Long sizeMilliseconds;

	public Music() {
	}

	public Music(Long id, String name, String albumName, String singerName, String musicPath, String iconPath,
			Long sizeMilliseconds) {
		this.id = id;
		this.name = name;
		this.albumName = albumName;
		this.singerName = singerName;
		this.musicPath = musicPath;
		this.iconPath = iconPath;
		this.sizeMilliseconds = sizeMilliseconds;
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

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getMusicPath() {
		return musicPath;
	}

	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public Long getSizeMilliseconds() {
		return sizeMilliseconds;
	}

	public void setSizeMilliseconds(Long sizeMilliseconds) {
		this.sizeMilliseconds = sizeMilliseconds;
	}

	@Override
	public int compareTo(Music o) {
		return this.name.compareTo(o.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(albumName, name, singerName, sizeMilliseconds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		return Objects.equals(albumName, other.albumName) && Objects.equals(name, other.name)
				&& Objects.equals(singerName, other.singerName)
				&& Objects.equals(sizeMilliseconds, other.sizeMilliseconds);
	}

}
