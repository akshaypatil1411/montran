package com.montran.main;

import java.util.List;
import java.util.Scanner;

import com.montran.pojo.Book;
import com.montran.pojo.Employee;
import com.montran.util.EmployeeCollectionUtil;

public class EmployeeCollectionMainV2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeCollectionUtil util = new EmployeeCollectionUtil();
		List<Employee> employeeList;
		int empChoice,number;
		String continueChoice;
		int employeeId;
		String name;
		String newName;
		double newSalary;
		double salary;
		Employee employee;
		Employee[] employees = null;
		boolean result;

		System.out.println("Printing all employee");
		employeeList = util.getAllEmployees();
		for (Employee emp : employeeList) {
			System.out.println(emp);
		}

		do {
			employeeList = util.getAllEmployees();
			for (Employee emp : employeeList) {
				if (emp != null) {
					System.out.println(emp.getEmployeeId() + "\t" + emp.getName() + "\t" + emp.getSalary());
				}
			}
			System.out.println("Menu");
			System.out.println("1. Add Single Employee");
			System.out.println("2. Add Multiple Employees");
			System.out.println("3. Update Existing Employee");
			System.out.println("4. Delete Existing Employee");
			System.out.println("5. Print Single Employee Details");
			System.out.println("6. Exit");
			System.out.println("Enter your choice");
			empChoice = scanner.nextInt();

			switch (empChoice) {
			case 1:
				System.out.println("Enter Employee ID");
				employeeId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter name");
				
				name = scanner.nextLine();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				employee = new Employee(employeeId, name, salary);

				System.out.println("Add New Employee");
				result = util.addNewEmployee(employee);
				
				if (result)
					System.out.println(" Employee is added successfully");
				else
					System.out.println("Failed to add Employee");
				break;

			case 2:

				System.out.println("Enter number of employees you want to add");
				number = scanner.nextInt(); // Book book2 = new Book(10);

				 employees = new Employee[number];
					for (int i = 0; i < number; i++) {
						System.out.println("Enter Employee ID");
						employeeId = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter name");
						
						name = scanner.nextLine();
						System.out.println("Enter Salary");
						salary = scanner.nextDouble();
						employee = new Employee(employeeId, name, salary);
						System.out.println("Add New Employee");
						employees[i] = employee;

					}
					util.addAllEmployees(employees);
					System.out.println("Employees added");
				
				break;

			case 3:
				System.out.println("Enter Empoyee ID");
				employeeId = scanner.nextInt();

				employee = util.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {

					System.out.println("Enter new salary");
					newSalary = scanner.nextDouble();

					result = util.updateEmployeeSalary(employeeId, newSalary);
					System.out.println("Result of update - " + result);
					if (result)
						System.out.println(" Updated Successfully");
					else
						System.out.println(" Failed");
				} else
					System.out.println(" Employee not found ");
				break;

			case 4:
				System.out.println("Enter Employee ID");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					result = util.deleteEmployee(employeeId);
					if (result)
						System.out.println("Deleted successfully");
					else
						System.out.println(" Failed to delete");
				} else
					System.out.println("Employee not found");

				break;

			case 5:
				System.out.println("Enter employee ID");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					System.out.println(employee);
				} else
					System.out.println(" No Employee found");
				break;

			case 6:
				System.out.println(" Thank you");
				System.exit(0);

				break;

			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Do you want to continue ?");
			continueChoice = scanner.next();
		}while(continueChoice.equals("yes"));

}

}
