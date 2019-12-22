import java.io.Serializable;
import java.util.Scanner;

// comparsion functions.   //Mina
public class Date implements Serializable { // The date is in format (dd/mm/yyyy:hh).
	private int day;
	private int month;
	private int year;
	private int hours;

	public Date(int day, int month, int year, int hours) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hours = hours;
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

	public void input() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the day :");
		day = scanner.nextInt();

		System.out.print("Enter the month :");
		month = scanner.nextInt();

		System.out.print("Enter the year :");
		year = scanner.nextInt();

		System.out.print("Enter the hours :");
		hours = scanner.nextInt();
		scanner.nextLine();
	}
	
	public Date increment(Date date, int days) { //Doesn't use or modify any data of the calling object.
		Date newDate = new Date();
		
		return newDate;
	}
	
	public Date decrement(Date date, int days) { //Doesn't use or modify any data of the calling object.
		Date newDate = new Date();
		
		return newDate;
	}

	public int difference(Date Date1, Date Date2) { //Doesn't use or modify any data of the calling object.
		int daysDifference = 0;
		
		return daysDifference;	
	}
	
	public String toString() {
		return day + "/" + month + "/" + year + ":" + hours;
	}

	// date.compare(d) 
	//return 1 if date>d
	//return 0 if date==d
	//return -1 id date<d
	public int compare(Date d) {
		if (this.year > d.year) {
			return 1;
		} else if (this.year == d.year) {
			if (this.month > d.month) {
				return 1;
			} else if (this.month == d.month) {
				if (this.day > d.day) {
					return 1;
				} else if (this.day == d.day) {
					if (this.hours > d.hours) {
						return 1;
					} else if (this.hours == d.hours) {
						return 0;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}
