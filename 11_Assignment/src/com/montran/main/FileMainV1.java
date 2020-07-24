package com.montran.main;

import java.io.File;
import java.util.Scanner;

import com.montran.util.FileInputStreamUtil;
import com.montran.util.FileOutputStreamUtil;

public class FileMainV1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileInputStreamUtil utilip = new FileInputStreamUtil();
		String filePath;
		File file;
		byte[] fileData;
		FileOutputStreamUtil utilop = new FileOutputStreamUtil();
		String data;

		int employeeId;
		String name;
		double salary;		

		System.out.println("Enter Path");
		filePath = scanner.nextLine();
		file = new File(filePath);

		System.out.println("Enter employee ID");
		employeeId = scanner.nextInt();
		

		System.out.println("Enter name");
		name = scanner.next();

		System.out.println("Enter salary");
		salary = scanner.nextDouble();
		
		data = employeeId+" "+name+" "+salary; 

		utilop.writeDataIntoFile(file, data.getBytes());
		System.out.println("Check your file");
		
		fileData = utilip.getFileData(file);
		
		for (byte b : fileData) {
			System.out.print((char) b);
		}
		
		scanner.close();
		
	}

}
