
public class Date { //The date is in format (dd/mm/yyyy:hh).
	private int day;
	private int month;
	private int year;
	private int hours;
	
	public Date(int day, int month, int year, int hours) {
		this.day = 0;
		this.month = 0;
		this.year = 0;
		this.hours = 0;
	}
	
	public Date() {
		this(0, 0, 0, 0);
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getHours() {
		return hours;
	}
	
	public String toString() {
		return day + "/" + month + "/" + year + ":" + hours;
	}
}