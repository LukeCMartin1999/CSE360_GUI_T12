package DataStructures;

import java.io.Serializable;
import java.util.Calendar;

public class Date implements Comparable<Date>, Serializable {
	
	private int year;
	private int month;
	private int day;
	private static final long serialVersionUID = 3L;
	
	// has current date as default
	public Date() {
		Calendar now = Calendar.getInstance();
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH) + 1;
		day = now.get(Calendar.DAY_OF_MONTH);
	}
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	@Override
	public int compareTo(Date other) {
		if (year < other.year) return -1; 
		else if (year > other.year) return 1;
		else {
			if (month < other.month) return -1;
			else if (month > other.month) return 1;
			else {
				if (day < other.day) return -1;
				else if (day > other.day) return 1;
				return 0;
			}
		}
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
