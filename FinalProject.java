// Christopher Deluigi
// Final project 
//11-10-2023





import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;



public class FinalProject {

	public static void main(String[] args) {
		
		Database database = new Database();
		
		
		
		
		boolean active = true;
		
		// If anything goes wrong the code will display "Something went wrong"
		try{
			
			while (active == true) {
				
				String choice;
				
				
				System.out.println("Choose one of the options:\n");
				System.out.println("1- Enter the information of a faculty");
				System.out.println("2- Enter the information of a student");
				System.out.println("3- Print tuition invoice for a student");
				System.out.println("4- Print faculty information");
				System.out.println("5- Enter the information of a staff member");
				System.out.println("6- Print the information of a staff member");
				System.out.println("7- Delete a person");
				System.out.println("8- Exit Program\n\n");
				
				System.out.print("Enter your selection: ");
				Scanner myScan = new Scanner(System.in);
				choice = myScan.nextLine();
				
				switch(choice) {
					
					case "1":
						
						System.out.println("Enter the faculty info:\n");
						
						System.out.print("\tName of the faculty: ");
						String input_name = myScan.nextLine();
						input_name = formatWords(input_name);
						
						System.out.print("\tID: ");
						String input_id = myScan.nextLine();
					
						formatCheck(input_id);
						
						
						//if the Id is wrong, it will keep asking the user to try again until they do it right. 
						while(formatCheck(input_id) != true) {
							System.out.println("Invalid ID format!LetterLetterDigitDigitDigitDigit. Try again");
							System.out.println("\tID: ");
							 input_id = myScan.nextLine();
							
							formatCheck(input_id);
						}
						
						
						System.out.print("\tRank: ");
						String input_rank = myScan.nextLine();
						input_rank = formatLetter(input_rank);
						
						boolean valid = false;
						
						//Will ensure that rank is correct if not the while loop will make the user get it right 
						if(input_rank.compareToIgnoreCase("Professor") == 0 || input_rank.compareToIgnoreCase("Adjunct") == 0) {
							valid = true;
						}
						
						while(valid != true) {
							System.out.println("\"" + input_rank +"\"" + " is invalid ");
							
							System.out.print("\tRank: ");
							input_rank = myScan.nextLine();
							input_rank = formatLetter(input_rank);
							
							if(input_rank.compareToIgnoreCase("Professor") == 0 || input_rank.compareToIgnoreCase("Adjunct") == 0) {
								valid = true;
							}
							
						}
						
						valid = false;
						
						System.out.print("\tDepartment: ");
						String input_dept = myScan.nextLine();
						input_dept =formatLetter(input_dept);
						
						//Will ensure that department is correct if not the while loop will make the user get it right 
						if(input_dept.compareToIgnoreCase("Mathematics")== 0 || input_dept.compareToIgnoreCase("English")== 0 || input_dept.compareToIgnoreCase("Engineering")== 0 ) {
							valid = true;
						}
						
						while( valid != true) {
							System.out.println("\"" + input_dept+"\"" + " is invalid ");
							
							System.out.print("\tDepartment: ");
							input_dept = myScan.nextLine();
							input_dept =formatLetter(input_dept);
							
							if(input_dept.compareToIgnoreCase("Mathematics")== 0 || input_dept.compareToIgnoreCase("English")== 0 || input_dept.compareToIgnoreCase("Engineering")== 0 ) {
								valid = true;
							}
						}
						
						database.addNewData((new faculty(input_name,input_id,input_dept,input_rank)), "Faculty");
						
						
						
						
						break;
					case "2":
						
						double input_gpa;
						int input_credit;
						
						System.out.println("Enter the student info:\n");
						
						System.out.print("\tName of Student: ");
						input_name = myScan.nextLine();
						input_name = formatWords(input_name);
						
						System.out.print("\tID: ");
						input_id = myScan.nextLine();
					
						formatCheck(input_id);
						
						
						//if the Id is wrong, it will keep asking the user to try again until they do it right. 
						while(formatCheck(input_id) != true) {
							System.out.println("Invalid ID format!LetterLetterDigitDigitDigitDigit. Try again");
							System.out.print("\tID: ");
							 input_id = myScan.nextLine();
							
							formatCheck(input_id);
						}
						
						
						try {
							
							
							System.out.print("\tGpa: ");
							input_gpa = myScan.nextDouble();
							
						}catch(Exception e) {
							System.out.println("Invalid for gpa,Try again next time.");
							break;
						}
						
						try {
							
							System.out.print("\tCredit hours: ");
							input_credit = myScan.nextInt();
							 
						 }catch(Exception e){
							 System.out.println("Invalid for Credit hours, Try again next time.");
							 break;
						}
						
						database.addNewData((new Student(input_name,input_id,input_gpa,input_credit)),"Student");
						
						
						break;
					case "3":
						
						System.out.print("Enter the Student's id:  ");
						input_id = myScan.nextLine();
						
						database.searchData(input_id, "Student");
						
						
						break;
					case "4":
						
						System.out.print("Enter the Faculty’s id:  ");
						input_id = myScan.nextLine();
						
						database.searchData(input_id, "faculty");
						
						break;
					case "5":
						
						System.out.print("\tName of the staff member:  ");
						input_name = myScan.nextLine();
						input_name = formatWords(input_name);
						
						System.out.print("\tEnter the id: ");
						input_id = myScan.nextLine();
						formatCheck(input_id);
						
						
						//if the Id is wrong, it will keep asking the user to try again until they do it right. 
						while(formatCheck(input_id) != true) {
							System.out.println("Invalid ID format!LetterLetterDigitDigitDigitDigit. Try again");
							System.out.print("\tID: ");
							 input_id = myScan.nextLine();
							
							formatCheck(input_id);
						}
						
						
						System.out.print("\tDepartment: ");
						input_dept = myScan.nextLine();
						input_dept =formatLetter(input_dept);
						
						valid = false;
						//Will ensure that department is correct if not the while loop will make the user get it right 
						if(input_dept.compareToIgnoreCase("Mathematics")== 0 || input_dept.compareToIgnoreCase("English")== 0 || input_dept.compareToIgnoreCase("Engineering")== 0 ) {
							valid = true;
						}
						
						while( valid != true) {
							System.out.println("\"" + input_dept+"\"" + " is invalid ");
							
							System.out.print("\tDepartment: ");
							input_dept = myScan.nextLine();
							input_dept =formatLetter(input_dept);
							
							if(input_dept.compareToIgnoreCase("Mathematics")== 0 || input_dept.compareToIgnoreCase("English")== 0 || input_dept.compareToIgnoreCase("Engineering")== 0 ) {
								valid = true;
							}
						}
						
						
						System.out.print("Status, Enter P for Part Time, or Enter F for Full Time:");
						String input_status = myScan.nextLine();
						
						valid = false;
						if(input_status.compareToIgnoreCase("P")==0) {
							input_status = "Part Time";
							valid = true;
							
						}
						else if(input_status.compareToIgnoreCase("F")==0) {
							input_status = "Full Time";
							valid = true;
						}
						
						while( valid != true){
							System.out.println("Sorry that is not a valid Option");
							System.out.print("\tStatus, Enter P for Part Time, or Enter F for Full Time:");
							input_status = myScan.nextLine();
							
							
							if(input_status.compareToIgnoreCase("P")==0) {
								input_status = "Part Time";
								valid = true;
								
							}
							else if(input_status.compareToIgnoreCase("F")==0) {
								input_status = "Full Time";
								valid = true;
							}
							
							
							
						}
						database.addNewData((new staff(input_name,input_id,input_dept,input_status)), "Staff");

						
						break;
					case "6":
						System.out.println("case6\n");
						
			
						System.out.print("Enter the Staff's id:  ");
						input_id = myScan.nextLine();
						
						database.searchData(input_id, "Staff");
						
						
						
						break;
					case "7":
						System.out.println("case7\n");
						System.out.print("Enter the id of the person to delete: ");
						input_id = myScan.nextLine();
						
						database.removeData(input_id);
						
						break;
					case "8":
						System.out.println("case8\n");
						active = false;
						
						valid = false;
						
						
						
						while(valid != true) {
							
							System.out.print("Would you like to create the report? (Y/N):");
							String input = myScan.nextLine();
							
							if(input.compareToIgnoreCase("Y")== 0){
								
								while(valid!= true) {
									System.out.print("Would like to sort your students by descending gpa or name (1 for gpa, 2 for name): ");
									input = myScan.nextLine();
									
									
									if(input.compareTo("1") == 0) {
										 valid = true;
										 database.sortData(input);
									}
									else if (input.compareTo("2")== 0) {
										valid = true;
										database.sortData(input);
									}
									else {
										System.out.println("Not a valid choice,try again");
									}
									
									
									
								}
								
								database.printReport();
								
								
								
								
								
							}
							else if(input.compareToIgnoreCase("N")== 0) {
								System.out.println("No report created.");
							}
							
						}
						
						
						
						
						
						
						break;
					default:
						System.out.println("Invalid entry- please try again");
						break;
				
				
				
				}
				
				
			}
			
		}catch (Exception e) {
			System.out.println("Something went wrong");
		}
		
		
		
		
		
		System.out.println("Goodbye");
	}
	
	private static  boolean formatCheck(String id) {
		
		boolean match = false;
		
		// to ensure the id format is followed.
		String pattern ="[a-zA]{2}\\d{4}";
		if(id.matches(pattern)) {
			match = true;
		}
		
		return match;
	}
	
	
	
	private static String formatLetter(String word) {
		
		String formattedString = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
		return formattedString;
	}
	
	private static String formatWords(String word) {
		
		String Parts[] = word.split("\\s+");
		
		
		StringBuilder formattedName = new StringBuilder();
		for(String part: Parts) {
			if(!part.isEmpty()) {
				String formattedPart = part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase();
				formattedName.append(formattedPart).append(" ");
			}
		}
		
		//To test 
        //System.out.println("Formatted name: " + formattedName.toString().trim());

		
		return formattedName.toString().trim();
	}
}


abstract class person{
	
	// Common to Student and employee.
	private String name;
	private String id;
	
	public person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	
	public person(String name) {
		this.name = name;
		this.id = "no id";
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public abstract void print ();
}

abstract class Employee extends person {
	
	private String department;
	
	public Employee(String name, String id, String department){
		super(name,id);
		this.department = department;
		
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}


class Student extends person {
	
	double gpa;
	int credit_hour;
	
	public Student (String name, String id,double gpa, int credit_hour){
		super(name,id);
		this.gpa = gpa;
		this.credit_hour = credit_hour;
		
	}
	public Student (String name, String id){
		super(name,id);
		this.gpa = 0;
		this.credit_hour = 0;
		
	}
	
	
	
	
	
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public int getCredit_hour() {
		return credit_hour;
	}
	public void setCredit_hour(int credit_hour) {
		this.credit_hour = credit_hour;
	}
	
	public void print() {
		System.out.println("Here is the tuition invoice for " +getName());
		System.out.println("\n");
		System.out.println("---------------------------------------\n");
		
		System.out.println(getName() + "\t\t\t" + getId());
		System.out.println("Credit Hours:" + credit_hour + "\t ($236.65/credit hour)\n");
		
		
		System.out.println("Fees: $52\n");
		
		total(gpa,credit_hour);
	
		System.out.println("---------------------------------------");
		
		
	}
	
	
	DecimalFormat decimal = new DecimalFormat(".00") ; // Will be used for the print statements to get .00, this will not affect the real value in the array list
	
	private void total (double gpa, int credit_hour) {
		
		if (gpa < 3.85) {
			System.out.println("Total payment(after discount): " + "$" +  decimal.format((((double)credit_hour * 236.45) +  52.00)) + "\t\t ($0 discount applied)");
		}
		else if (gpa >= 3.85) {
			double total = ((credit_hour * 236.45) + 52.00 );
			double discount = 0.25 * total;
			
			total =  total - discount;
			System.out.println("Total payment(after discount): " +  "$" + decimal.format(total) + "\t\t (" + decimal.format(discount) + " discount applied)");
			//25%
		}
		
		
		
	}
	@Override
	public String toString(){
		return getName() +"\n\tID: " + getId() + "\n\tGpa: " + gpa  + "\n\tCredit hours: " + credit_hour + "\n\n" ;
	}
	
}

class faculty extends Employee{
	
	String rank;
	
	
	public faculty(String name, String id,String department, String rank){
		super(name,id,department);
		this.rank = rank;
		
	}
	
	
	public faculty(String name, String id,String department){
		super(name,id,department);
		this.rank = "No rank";
		
	}
	
	
	
	
	
	
	public void print() {
		System.out.println("---------------------------------------\n");
		
		
		System.out.println(getName()+ "\t\t" + getId());
		System.out.println("\n");
		System.out.println(getDepartment() +" Department, " + rank);
		
		System.out.println("---------------------------------------\n");


		
	}
	
	
	@Override
	public String toString(){
		return  getName() +"\n\tID: " + getId() + "\n\t"+ rank+ "," + getDepartment()  + "\n\n" ;
	}
	
}

class staff extends Employee{
	
	String status;
	
	
	public staff(String name,String id,String department,String status) {
		super(name,id,department);
		this.status = status;
		
		
	}
	
	public staff(String name,String id,String department) {
		super(name,id,department);
		this.status = "No status";
		
		
	}
	
	
	public void print() {
		System.out.println("---------------------------------------\n");
		
		System.out.println(getName()+ "\t\t" + getId());
		
		System.out.println(getDepartment() +" Department, " + status);
		
		System.out.println("---------------------------------------\n");

	}
	
	
	@Override
	public String toString(){
		return  getName() +"\n\tID: " + getId() + "\n\t"+ getDepartment()  + "," + status + "\n\n" ;
	}
}


class Database  {
	
	private ArrayList <person> dataList;
	
	public Database(){
	
		dataList= new ArrayList <> ();
	}
	
	boolean no_match = false;
	
	public void addNewData(person data, String type) {
		for(int index = 0 ; index < dataList.size(); index++) {
			
			
			
			if(data.getId().compareToIgnoreCase(dataList.get(index).getId())== 0 ) {
				no_match = true;
				System.out.println("Sorry, this Id is already in the system try again with a different ID.");
				break;
			}
			
			
			
		}
		
		// If the Id is not a copy of an existing id, then it will be added to the list.
		if(no_match == false) {
			
			dataList.add(data); 	}
			System.out.println(type + " Added!");
		
		
		
	}
	
	public void searchData(String dataId, String type) {
		
		boolean found = false;
		
		// Will search if the faculty exist 
		if(type.compareToIgnoreCase("faculty")== 0) {
			for(person data: dataList) {
				if(data instanceof faculty && dataId.compareToIgnoreCase(data.getId())== 0 ) {
					found = true;
					data.print();
					break;
				}
			}
		}
		
		if(type.compareTo("Student")== 0) {
			for(person data: dataList) {
				if(data instanceof Student && dataId.compareToIgnoreCase(data.getId())== 0 ) {
					found = true;
					data.print();
					break;
				}
			}
		}
		if(type.compareTo("Staff")== 0) {
			for(person data: dataList) {
				if(data instanceof staff && dataId.compareToIgnoreCase(data.getId())== 0 ) {
					found = true;
					data.print();
					break;
				}
			}
		}
		
		
		
		
		
		//If not found for any of the types
		if(found == false && type.compareToIgnoreCase("faculty")== 0) {
			System.out.println("No faculty member found!\n");
		}
		else if(found == false && type.compareToIgnoreCase("Student")== 0) {
			System.out.println("No Student found!\n");
		}
		else if(found == false && type.compareToIgnoreCase("Staff")== 0) {
			System.out.println("No Staff member found!\n");
		}
		
		
	}
	
	public void removeData(String dataId) {
		
		boolean successful = false;
		
		
		for(person data: dataList) {
			if(dataId.compareToIgnoreCase(data.getId()) == 0) {
				dataList.remove(data);
				System.out.println("Person was  removed \n");
				successful = true;
				break;
				
			}
		}
		
		if(successful != true) {
			System.out.println("Sorry no such person exist.");
		}
	}
	
	public void sortData(String choice ) {
		
		if(choice.compareToIgnoreCase("1") == 0) {
			Collections.sort(dataList,new SortByGpa());
		}
		else if(choice.compareToIgnoreCase("2")== 0) {
			Collections.sort(dataList, new SortByName());
		}
	}
	
	
	
	public void printReport() {
		//report.txt
		
		LocalDate today = LocalDate.now();
		
		try {
			//File file = new File("report.txt");
			
			
			// To get the format of today's date
			
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = today.format(formatter);
			
	

	        // Create a FileWriter object with the file name
	        FileWriter fileWriter = new FileWriter("report.txt");

	        // Create a BufferedWriter object to write to the file
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	        // Write content to the file
	        bufferedWriter.write("\t\t\t Report Created on " + formattedDate +"\n" );
	        bufferedWriter.write("\t\t\t ****************************\n\n\n");
	        
	        bufferedWriter.write("Faculty Members\n");
	        bufferedWriter.write("----------------\n");
	        
	        
	        int count = 1;
			
			for(person FData:dataList) {
				if(FData instanceof faculty) {
					bufferedWriter.write("\t" + count + "." + FData);
					count++;
				}
			}
			
			bufferedWriter.write("Staff Members\n");
		    bufferedWriter.write("----------------\n");
		        
	        
		    count = 1;
			for(person SSData:dataList) {
				if(SSData instanceof staff) {
					bufferedWriter.write("\t" + count + "." + SSData);
					count++;
				}
			}
	        
		    
			bufferedWriter.write("Students\n");
		    bufferedWriter.write("----------------\n");
		        
		    
	        count = 1;
			
			for(person SData:dataList) {
				if(SData instanceof Student) {
					bufferedWriter.write("\t" + count + "." + SData);
					count++;
				}
			}
		  
	        
			bufferedWriter.close();
	        System.out.println("Report created and saved on your hard drive!");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}

class SortByName implements Comparator <person>{
	
	
	
	public int compare(person s1, person s2) {
		
		return(s2.getName()).compareTo(s1.getName());
	}
}

class SortByGpa implements Comparator <person>{
	
	@Override
	public int compare(person p1, person p2) {
        if (p1 instanceof Student && p2 instanceof Student) {
            return Double.compare(((Student) p2).getGpa(), ((Student) p1).getGpa());
        } else if (p1 instanceof Student) {
            return -1; // Students before other Person types
        } else if (p2 instanceof Student) {
            return 1; // Other Person types after Students
        } else {
            return 0; // Non-Student Person types maintain their original order
        } //test
    }	
	
	
	
	
}










