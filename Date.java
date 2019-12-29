import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
	

	public String convarte_to_date_format(Date d)//yyyy-mm-dd
	{
		return d.getYear()+"-"+int_to_String(d.getMonth())+"-"+int_to_String(d.getDay());
	}
	
	public Date convarte_from_date_format(String d)
	{
	
		String year=""+d.charAt(0)+d.charAt(1)+d.charAt(2)+d.charAt(3);
		String month=""+d.charAt(5)+d.charAt(6);
		String day=""+d.charAt(8)+d.charAt(9);
		Date date=new Date(Integer.parseInt(day),Integer.parseInt(month),Integer.parseInt(year),0);
		return date;
	}
	
	public String int_to_String(int value)//convert int day and month to string
	{
		if((""+value).length()<2)
		{
			return "0"+value;
		}
		else
			return ""+value;
	}
	
	public int difference(Date Date1, Date Date2) { //Doesn't use or modify any data of the calling object.
		int daysDifference = 0;
		
		String date1=Date1.getYear()+"-"+int_to_String(Date1.getMonth())+"-"+int_to_String(Date1.getDay());
		String date2=Date2.getYear()+"-"+int_to_String(Date2.getMonth())+"-"+int_to_String(Date2.getDay());
		LocalDate d1 = LocalDate.parse(date1, DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate d2 = LocalDate.parse(date2, DateTimeFormatter.ISO_LOCAL_DATE);
		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
		daysDifference = (int) diff.toDays();
		
		return daysDifference;	
	}
	
	public Date updatedate(Date date, int days) { //+days Means increment the date by dates -date Means decrement the date by dates 
		Date newDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try{
		   //Setting the date to the given date
		   c.setTime(sdf.parse(convarte_to_date_format(date)));
		}catch(Exception e){
			System.err.println(e);
		 }
		   
		//Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, days);  
		//Date after adding the days to the given date
		String dateformate = sdf.format(c.getTime());
		newDate=convarte_from_date_format(dateformate);
		return newDate;
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
	
	public String toString() {
		return day + "/" + month + "/" + year + ":" + hours;
	}


}
