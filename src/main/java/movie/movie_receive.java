package movie;

public class movie_receive {
	private String userid;
	private String password;
	private String mv_id;
	private String year;
	private String month;
	private String day;
	private String time;
	private String seat;
	private String id;
	
	public String get_userid() {
		return userid;
	}
	public String get_password() {
		return password;
	}
	public String get_mv_id() {
		return mv_id;
	}
	public String get_year() {
		return year;
	}
	public String get_month() {
		return month;
	}
	public String get_day() {
		return day;
	}
	public String get_time() {
		return time;
	}
	public String get_seat() {
		return seat;
	}
	public String get_id() {
		return id;
	}
	public movie_receive(String id,String userid,String password,String  mv_id,String year,String month,String day,String time,String seat){
		this.userid=userid;
		this.password=password;
		this.mv_id=mv_id;
		this.year=year;
		this.month=month;
		this.day=day;
		this.time=time;
		this.seat=seat;
		this.id=id;
	}
	public movie_receive(String seat){
		
		this.seat=seat;
	}


}

