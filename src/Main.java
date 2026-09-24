import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        Connection connection = DBConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean running = true;
        while (running) {
            System.out.println("--------WELCOME TO STUDENT MANAGEMENT SYSTEM---------");
            System.out.println("--------MENU---------");
            System.out.println("1. ADD STUDENT");
            System.out.println("2. DISPLAY STUDENT");
            System.out.println("3. SEARCH");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            String choice = sc.nextLine();
            switch (choice) {
                case "1", "add", "ADD", "Add":
                    Student student = new Student();
                    System.out.println("Enter Student name :");
                    student.setName(sc.nextLine());
                    System.out.println("Enter Mobile Number :");
                    student.setMobileNumber(sc.nextLine());
                    System.out.println("Enter Address : ");
                    student.setAddress(sc.nextLine());
                    System.out.println("Enter course : ");
                    student.setCourse(sc.nextLine());
                    students.add(student);
                    StudentDAO.insertStudent(student);
                    break;
                
                case "2", "display", "Display", "DISPLAY":
                    for (Student s : students) {
                        System.out.println(s.getName());
                        System.out.println(s.getMobileNumber());
                        System.out.println(s.getAddress());
                        System.out.println(s.getCourse());
                        System.out.println();
                    }
                    break;

                case "3", "search", "SEARCH", "Search":
                    System.out.println("Enter student name : ");
                    String searchName = sc.nextLine();
                    for (Student b : students) {
                        if(b.getName().equals(searchName)){
                            System.out.println(b.getName());
                            System.out.println(b.getMobileNumber());
                            System.out.println(b.getAddress());
                            System.out.println(b.getCourse());
                            System.out.println();
                            break;
                        }  
                    }
                    break;

                case "4", "delete", "Delete", "DELETE":
                    System.out.println("Enter student name :");
                    String removeName = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getName().equals(removeName)) {
                            students.remove(i);
                            System.out.println("Student deleted sucessfully");
                            found = true;
                            break;
                        }    
                    }
                    if (!found) {
                        System.out.println("Student not found");
                    }
                    break;

                case "5", "exit", "Exit", "EXIT":
                    running = false;
                    System.out.println("Thank you ! your program endded");
                    break;
                default :
                    System.out.println("Wrong choice !!!!!!!!!!!!!!!!!!!!!!");
                    break;
            
            }
        }
        sc.close();
    }

}
