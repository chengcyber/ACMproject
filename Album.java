

public class Album {

	public Album(String albumName, String bandName, int stock) {
		this.albumName = albumName;
		this.bandName = bandName;
		this.stock = stock;
	}
	
	
	
	private String albumName;
	private String bandName;
	private int stock;
	
	/* Getters and  Setters */
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
