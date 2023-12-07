package mpb.gui.admin.enums;

public enum PageType {
	LOGIN(1);

	private PageType(int i) {
		this.id = i;
	}

	private int id;

	public int getID() {
		return id;
	}
}
