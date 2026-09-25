import java.util.Scanner;
import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        Connection connection = DBConnection.getConnection();
        Scanner sc = new Scanner(System.in);

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
                    System.out.println("Enter DOB :");
                    student.setDob(sc.nextLine());
                    System.out.println("Enter Mobile Number :");
                    student.setMobileNumber(sc.nextLine());
                    System.out.println("Enter Address : ");
                    student.setAddress(sc.nextLine());
                    System.out.println("Enter course : ");
                    student.setCourse(sc.nextLine());
                    
                    StudentDAO.insertStudent(student);
                    break;
                
                case "2", "display", "Display", "DISPLAY":
                    StudentDAO.displayStudent();
                    break;

                case "3", "search", "SEARCH", "Search":
                    System.out.println("Enter your preference search by ID or Name: ");
                    String pref = sc.nextLine();
                    switch (pref.toLowerCase()) {
                        case "name":
                            System.out.println("Enter student name : ");
                            String searchName = sc.nextLine();
                            StudentDAO.searchStudentName(searchName);
                            break;
                            
                        case "id":
                            System.out.println("Enter student id : ");
                            int sid = sc.nextInt();
                            StudentDAO.searchStudentId(sid);
                            break;
                        default :
                            System.out.println("SORRY!!!!!!!!!!!!!!!");
                            break;
                    }
                    break;

                case "4", "delete", "Delete", "DELETE":
                    System.out.println("Enter student id :");
                    int removeStudent = sc.nextInt();
                    StudentDAO.deleteStudentId(removeStudent);
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
