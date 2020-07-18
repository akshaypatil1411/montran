package com.montran.main;
import com.montran.pojo.Time;
public class timeMainV1 {

	public static void main(String[] args) {
		
		Time time1 = new Time();
		Time time2 = new Time();
		Time time3 = new Time();
		
		time1.setTime(10, 30);
		time2.setTime(5, 20);
		time3 = time2.sumTime(time1);
		System.out.println(time1.showTime());
		System.out.println(time2.showTime());
		System.out.println(time3.showTime());
	}

}
