package mpb.entities.enums;

public enum UserType {
	NORMAL(1, "Normal"), VIP(2, "VIP");

	private final int id;
	private final String status;

	private UserType(int id, String status) {
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}
}