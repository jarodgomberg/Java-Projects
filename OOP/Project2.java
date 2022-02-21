import java.util.Scanner;

public class Project2 {
	public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

		//declare array of persons and index variable
		Person[] persons = new Person[100];
		int index = 0;

		//declare menu variable to print menu
		Menu m = new Menu();
		System.out.println("");
		System.out.println("\t\t\t\tWelcome to my Personnel Management Program");
		System.out.println("");
		System.out.println("");
		System.out.println("Choose one of the options:");
		//loop menu and selection option
		while(true) {
			m.printMenu();
			String option = scnr.next();
			switch(option) {
			case "1": //enter faculty
				 System.out.println("\n\nEnter the faculty info:");
				 System.out.println("");
	             System.out.print("\t\tName of faculty: ");
	             scnr.nextLine();
	             String nameFaculty = scnr.nextLine();
	             System.out.println("");
	             System.out.print("\t\tID: ");
	             String idFaculty = scnr.next();
	             System.out.println("");
	             System.out.print("\t\tRank: ");
	             scnr.nextLine();
	             String rank = scnr.nextLine();
	             System.out.println("");
	             while (!(rank.toLowerCase().equals("professor") || rank.toLowerCase().equals("adjunct"))) {
	            	 System.out.println("\t\t\t\"" + rank + "\" is invalid");
	            	 System.out.print("\t\tRank: ");
	                 rank = scnr.nextLine();
	                 System.out.println("");
	             }
	             System.out.print("\t\tDepartment: ");
	             String department = scnr.nextLine();
	             System.out.println("");

	             while(!(department.toLowerCase().equals("mathematics")|| department.toLowerCase().equals("engineering")|| department.toLowerCase().equals("english"))) {
	            	 System.out.println("\"" + department + "\" is invalid");
	            	 System.out.print("\t\tDepartment: ");
	            	 department = scnr.nextLine();
	            	 System.out.println("");
	             }

	             persons[index] = new Faculty(nameFaculty, idFaculty, department, rank);
	             index++;
	             System.out.println("Faculty added!");
	             break;

			case "2": //enter students
				System.out.println("\n\nEnter the student info:");
				System.out.println("");
	            System.out.print("\t\tName of Student: ");
	            scnr.nextLine();
	            String nameStudent = scnr.nextLine();
	            System.out.println("");
	            System.out.print("\t\tID: ");
	            String idStudent = scnr.next();
	            System.out.println("");
	            System.out.print("\t\tGpa: ");
	            double gpaStudent = scnr.nextDouble();
	            System.out.println("");
	            System.out.print("\t\tCredit hours: ");
	            int numCreditHours = scnr.nextInt();
	            System.out.println("");
	            persons[index] = new Student(nameStudent, idStudent, gpaStudent, numCreditHours);
	            index++;
	            System.out.println("Student added!");
	            break;

			case "3": //print students
				 System.out.print("\nEnter the student's id: ");
	             scnr.nextLine();
	             boolean isStudent = false;
	             String studentID = scnr.nextLine();

	             for (int i = 0; i < index; i++) {
	            	if(persons[i].getID().equals(studentID)) {
	            		persons[i].print();
	            		isStudent = true;
	            	}
	             }
	             if (!isStudent) {
	            	 System.out.println("");
	            	 System.out.println("No Student matched!");
	             }
	             break;

			case "4": //print faculty
				System.out.print("\nEnter the Faculty's ID: ");
				scnr.nextLine();
				String idFac = scnr.nextLine();
				boolean isFaculty = false;

				for(int i = 0; i < index; i++) {
					if(persons[i].getID().equals(idFac)) {
						persons[i].print();
						isFaculty = true;
					}
				}
	            if(!isFaculty) {
	            	System.out.println("");
	            	System.out.println("No faculty matched!");
	            }
	            break;

			case "5": //enter staff member
				System.out.println("");
				System.out.print("\t\tName of staff member: ");
				scnr.nextLine();
				String nameStaff = scnr.nextLine();
				System.out.println("");
				System.out.print("\t\tEnter the ID: ");
				String idStaff = scnr.nextLine();
				System.out.println("");
				System.out.print("\t\tDepartment: ");
				String deptStaff = scnr.nextLine();
				System.out.println("");

				while(!(deptStaff.toLowerCase().equals("mathematics") || deptStaff.toLowerCase().equals("engineering") || deptStaff.toLowerCase().equals("english")) ) {
					System.out.println("\"" + deptStaff + "\" is invalid");
					System.out.println("");
					System.out.print("\t\tDepartment: ");
					deptStaff = scnr.nextLine();
					System.out.println("");
				}
				System.out.print("\t\tSatus, Enter P for part time, or Enter F for full time: ");
				String statusStaff = scnr.nextLine();
				System.out.println("");

				while(!(statusStaff.toUpperCase().equals("P") || statusStaff.toUpperCase().equals("F"))) {
					System.out.println("");
					System.out.println("\"" + statusStaff + "\" is invalid");
					System.out.println("");
					System.out.print("\t\tStatus, Enter P for part time, or Enter F for full time: ");
					statusStaff = scnr.nextLine();
					System.out.println("");
				}
				String status = "";
				if(statusStaff.equals("P")) {
					status = "Part Time";
				}
				else {
					status = "Full Time";
				}

				persons[index] = new Staff(nameStaff, idStaff, deptStaff, status);
				index++;
				System.out.println("Staff member added!");
				break;

			case "6": //print staff member
				System.out.println("");
				System.out.print("Enter the Staff's ID: ");
				scnr.nextLine();
				String staffID = scnr.nextLine();
				boolean isStaff = false;

				for(int i = 0; i < index; i++) {
					if(persons[i].getID().equals(staffID)) {
						persons[i].print();
						isStaff = true;
					}
				}
				if(!isStaff) {
					System.out.println("");
					System.out.println("No Staff member matched!");
				}
				break;

			case "7": //close menu or end program
				System.out.println("");
				System.out.println("Goodbye!");
				System.exit(0);
				break;

			default: //user does not enter correct option from menu
				System.out.println("\nInvalid entry- please try again");
				break;
			}
		}
	}
}

abstract class Person {
	private String name;
	private String idNum;

	public Person() {

	}

	public Person(String name, String idNum) {
		this.name = name;
		this.idNum = idNum;
	}

	public String getName() {
		return name;
	}

	public void setName() {
		this.name = name;
	}

	public String getID() {
		return idNum;
	}

	public void setID() {
		this.idNum = idNum;
	}

	public abstract void print();
}

class Student extends Person {
	private double gpa;
	private int numCredits;
	private double discount;
	private double tuition;

	public Student(String name, String idNum, double gpa, int numCredits) {
		super(name, idNum);
		this.gpa = gpa;
		this.numCredits = numCredits;
	}

	public Student() {
		super();
	}

	public double getGpa() {
		return gpa;
	}

	public int getNumCredits() {
		return numCredits;
	}

	public void setGpa() {
		this.gpa = gpa;
	}

	public void setNumCredits() {
		this.numCredits = numCredits;
	}

	public double invoice() {
		discount = 0.00;
		tuition = (numCredits * 236.45) + 52.00;

		if(this.gpa > 3.85) {
			discount = tuition * 0.25;
			tuition -= discount;
		}
		return tuition;
	}

	@Override
	public void print() {
		System.out.println("");
		System.out.println("Here is the tuition invoice for " + getName() + ":");
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("");
		System.out.println(getName() + "\t\t" + getID());
		System.out.println("");
		System.out.println("Credit hours: " + getNumCredits() + " ($236.45/credit hour)");
		System.out.println("");
		System.out.println("Fees: $52");
		System.out.println("");
		System.out.println("");
		System.out.printf("Total payment (after discount): $");
		System.out.printf("%.2f", invoice());
		System.out.printf("\t\t($");
		System.out.printf("%.2f", discount);
		System.out.printf(" discount applied)");
		System.out.println("");
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("");
	}
}

class Employee extends Person {
	private String department;

	public Employee(String name, String idNum, String department) {
		super(name, idNum);
		this.department = department;
	}

	public Employee() {
		super();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment() {
		this.department = department;
	}

	@Override
	 public void print() {
	       System.out.println(getName() + "\t" + getID());
	   }
}

class Faculty extends Employee{
	private String rank;

	public Faculty(String name, String idNum, String department, String rank) {
		super(name, idNum, department);
		this.rank = rank;
	}

	public Faculty() {
		super();
	}

	public String getRank() {
		return rank;
	}

	public void setRank() {
		this.rank = rank;
	}

	@Override
	public void print() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("");
		super.print();
		System.out.println(getDepartment()+" Department, "+getRank());
		System.out.println("");
		System.out.println("----------------------------------------------------------------");
	}
}

class Staff extends Employee {

	private String status;

	public Staff(String name, String idNum, String department, String rank) {
		super(name, idNum, department);
		this.status = status;
	}

	public Staff() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String rank) {
		this.status = status;
	}


	@Override
	public void print() {
		System.out.println("---------------------------------------------------------------------------\n");
		super.print();
		System.out.println("\n"+getDepartment()+" Department, "+getStatus());
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------\n");
	}
}

class Menu {
	public void printMenu() { //method of print statements for menu
		System.out.println("");
		System.out.println("1- Enter the information of the faculty");
		System.out.println("2- Enter the information of the two students");
		System.out.println("3- Print tuition invoice");
		System.out.println("4- Print faculty information");
		System.out.println("5- Enter the information of the staff member");
		System.out.println("6- Print the information of the staff member");
		System.out.println("7- Exit program");
		System.out.println("");
		System.out.print("\tEnter your selection: ");
	}
}
