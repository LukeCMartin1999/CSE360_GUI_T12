package DataStructures;
java.util.*

public class Date implements Comparable<Date> {
	
	private int year;
	private int month;
	private int day;
	
	public Date() {
		// TODO default should be current date
		Date date = new Date();
	}
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	@Override
	public int compareTo(Date o) {
		// TODO Auto-generated method stub
		int result = date.compareTo(o)
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
