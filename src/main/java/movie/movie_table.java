package movie;

public class movie_table {
	private int Movie_id;
	private String Movie_title;
	
	public int get_Movie_id() {
		return Movie_id;
	}
	public String get_Movie_titel() {
		return Movie_title;
	}
	public movie_table(int Movie_id,String Movie_title) {
		this.Movie_id = Movie_id;
		this.Movie_title = Movie_title;
	}

}
