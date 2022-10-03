//contains Main method
package com.employee.com;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;


public class MainApp {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		while(true) {			
			System.out.println("Select Your Choice: ");
			System.out.println("1. Display All Records");
			System.out.println("2. Insert Record");
			System.out.println("3. Delete Record");
			System.out.println("4. Search By ID");
			System.out.println("5. Update Records");
			System.out.println("6. CheckIn");
			System.out.println("7. CheckOut");
			System.out.println("0. Exit");
			
			System.out.print("Enter your Choice: ");
			int choice=s.nextInt();
			System.out.println(" ");
			
			if(choice==0)
				break;
			else {
				EmployeeDAO sd=new EmployeeDAO();
				int id=0;
				String name="";
				int age=0;
				String department="";
				double salary=0.0;
				switch (choice) {
				case 1: List<EmployeeDetails> studs=sd.getRecords();
						//studs.forEach(n->System.out.println(n));
						for(EmployeeDetails n: studs)
						{
							System.out.println(n);
						}
					break;
				case 2:
					System.out.print("Enter Name: ");
					name=s.next();
					System.out.print("Enter Age: ");
					age=s.nextInt();
					System.out.print("Enter Department: ");
					department=s.next();
					System.out.print("Enter Salary: ");
					salary=s.nextDouble();
					
					boolean b=sd.insertRecord(name,age,department,salary);
					if (b) {
						System.out.println("Record Inserted");
					}
				break;
				case 3: 
					studs = sd.getRecords();
					//studs.forEach(n->System.out.println(n));
					for(EmployeeDetails n: studs)
					{
						System.out.println(n);
					}
					System.out.print("Enter the ID of the Employee whose records needs to be deleted: ");
					id = s.nextInt();
					b = sd.deleteRecord(id);
					if(b)
						System.out.println("Records Deleted");
	        		break;
				case 4: 
					System.out.print("Enter the ID of the Employee whose record you want to search: ");
					id = s.nextInt();						
					EmployeeDetails st = sd.searchRecord(id);
					if(st==null)
						System.out.println("No Record Found");
					else
						System.out.println(st);
					break;
				case 5: 
					studs = sd.getRecords();
					//studs.forEach(n->System.out.println(n));
					for(EmployeeDetails n: studs)
					{
						System.out.println(n);
					}
					
					System.out.print("Enter ID of the Employee whose records you want to update: ");
					id = s.nextInt();
					
					st = sd.searchRecord(id);
					if(st==null)
						System.out.println("No Record Found");
					else {							
						System.out.println("What you want to update?");
						System.out.println("a. Name");
						System.out.println("b. Age");
						System.out.println("c. Department");
						System.out.println("d. Salary");
						System.out.print("Enter Your Choice: ");
						char updateChoice = s.next().charAt(0);
					
						switch(updateChoice) {
						case 'a': System.out.print("Enter New Name: ");
									name = s.next();
									st.setName(name);
									break;
						case 'b': System.out.print("Enter New Age: ");
									age = s.nextInt();
									st.setAge(age);
									break;
						case 'c': System.out.print("Enter New Department: ");
									department = s.next();
									st.setDepartment(department);
									break;
						case 'd': System.out.print("Enter New Salary: ");
									salary = s.nextDouble();
									st.setSalary(salary);
									break;
						default: System.out.println("Enter the correct choice next time...\n");
						}
						
						b = sd.updateRecord(st);
						if(b)
							System.out.println("Record Updated");
					}
	        	break;
				case 6:
					System.out.print("Enter the ID to mark Attendane: ");
					id = s.nextInt();						
					EmployeeDetails st1 = sd.searchRecord(id);
					
					boolean res =sd.checkIn(st1);
					if(res) {
						System.out.println("Attendance Mark");
					}
					break;
				case 7:
					System.out.print("Enter the ID to mark Attendance: ");
					id = s.nextInt();						
					EmployeeDetails st2 = sd.searchRecord(id);
					boolean res1 =sd.checkOut(st2);
					if(res1) {
						System.out.println("Attendance Completed");
					}
					break;
					
									
//					System.out.print("Enter ID of the Employee whose Attendance will mark: ");
//					id = s.nextInt();
//					st = sd.searchRecord(id);
//					if(st==null)
//						System.out.println("No Record Found");
//					else {
//						System.out.println("what do you want to enter: ");
//						System.out.println("a. CheckIn");
//						System.out.println("b. CheckOut");
//						System.out.println("Enter Your Choice: ");
//						char updateChoice = s.next().charAt(0);
//						switch(updateChoice) {
//						case 'a': 
//								LocalDate date = LocalDate.now();
//									System.out.println(date);
//								LocalTime checkIn = LocalTime.now();
//									System.out.println(checkIn);
//								break;
//						case 'b': 
//								LocalTime checkOut = LocalTime.now();
//									System.out.println(checkOut);
//								break;
//						default:System.out.println("Enter Valid choice: ");
//						boolean c=sd.empEntry(date,checkIn,checkOut);
//						if (c) {
//							System.out.println("Record Inserted");
//						}
//						}						
//					}
//				break;
	        default: System.out.println("Enter the correct number for choice next time....\n");
			}
		}
	}	
	}
}
