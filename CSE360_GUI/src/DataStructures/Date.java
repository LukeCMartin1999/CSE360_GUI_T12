package DataStructures;

public class Date implements Comparable<Date> {
	
	private int month;
	private int day;
	private int year;
	
	@Override
	public int compareTo(Date o) {
		// TODO Auto-generated method stub
		return 0;
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
