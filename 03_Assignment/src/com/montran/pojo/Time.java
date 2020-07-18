package com.montran.pojo;

public class Time {
	private int hour;
	private int min;
	//Scanner scanner = new Scanner(System.in);
	public void setTime(int h, int m) {
		
		this.hour = h;		
		this.min = m;
	}
	
	public Time showTime() {
			return this;
	}
	
	public Time sumTime(Time time) {
		
		//System.out.println("ABCD"+time2);
	    Time time3 = new Time();
	    time3.hour = time.hour + this.hour;
	    time3.min = time.min + this.min;
		return time3;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", min=" + min + "]";
	}
	
}
