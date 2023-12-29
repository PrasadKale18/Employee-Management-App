package com.student.manage;
import java.util.Scanner;

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Employee Management App!");
		
		while(true) {
			System.out.println("Press 1 to ADD Employee!");
			System.out.println("Press 2 to DELETE Employee!");
			System.out.println("Press 3 to DISPLAY Employee!");
			System.out.println("Press 4 to UPDATE Employee!");
			System.out.println("Press 5 to EXIST Employee!");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Your Choice : ");
			int choice = sc.nextInt();
			
			switch(choice){
			case 1:
				
				sc.nextLine();
				
				System.out.print("Enter Employee Name : ");
				String name = sc.nextLine();
				
				System.out.print("Enter Employee Mobile Number : ");
				int phoneno = sc.nextInt();
				
				System.out.print("Enter Employee Salary : ");
		        double salary = sc.nextDouble();
		        
		        Employee obj = new Employee(name, phoneno, salary);
		       boolean answer = EmployeeDao.insertEmployeeToDB(obj);
		       if(answer) {
		    	   System.out.print("Employee Added Successfully....!");
		       }else {
		    	   System.out.print("Something went wrong, try again....!");
		       }
		        System.out.println(obj);
		       
				break;
				
			case 2:
				System.out.print("Enter Employee Id to delete : ");
				int userId = sc.nextInt();
				boolean f = EmployeeDao.deleteEmployee(userId);
				 if(f) {
			    	   System.out.println("Employee Delete Successfully....!");
			       }else {
			    	   System.out.println("Something went wrong, try again....!");
			       }
				break;
				
			case 3:
				EmployeeDao.showAllEmployees();
				break;
				
			case 4:
				System.out.print("Enter Employee Id to update : ");
			    int updateUserId = sc.nextInt();
			    sc.nextLine(); 

			    System.out.print("Enter new Employee Name : ");
			    String newName = sc.nextLine();

			    System.out.print("Enter new Employee Mobile Number : ");
			    int newPhoneNumber = sc.nextInt();

			    System.out.print("Enter new Employee Salary : ");
			    double newSalary = sc.nextDouble();

			    boolean updateResult = EmployeeDao.updateEmployee(updateUserId, newName, newPhoneNumber, newSalary);

			    if (updateResult) {
			        System.out.println("Employee Updated Successfully!");
			    } else {
			        System.out.println("Something went wrong, try again!");
			    }
				break;
				
			case 5:
				System.out.println("Exiting Employee Management App. Goodbye!");
                System.exit(0);
				break;
				
			default:
				System.out.println("Please, Enter a Valid Choice : ");
			}
			
		}

	}

}
