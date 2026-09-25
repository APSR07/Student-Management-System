import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class StudentDAO{
    // insert student
    public static void insertStudent(Student student) {
        
        // SQL DATA INSERT QUERY 
        String sql = "INSERT INTO students " +
                     "(name, mobilenumber, address, course) " +
                     "VALUES (?, ?, ?, ?)";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getDob());
            ps.setString(3, student.getMobileNumber());
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getCourse());

            ps.executeUpdate();
            System.out.println("Student inserted successfully");
            connection.close();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    // DISPLAY ALL STUDENT QUERY METHOD

    public static void displayStudent(){
        String sql = "SELECT * FROM student";

        try (Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();)
            { 
                boolean found = false;
                while (found) {
                    found = true;

                    Student student = new Student();

                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setDob(rs.getString("dob"));
                    student.setMobileNumber(rs.getString("mobileNumber"));
                    student.setAddress(rs.getString("address"));
                    student.setCourse(rs.getString("course"));

                    System.out.println("----------------------------------------------------------");
                    System.out.println(student);
                }

                if(!found){
                    System.out.println("No student found!!!!!!!!!!!!!");
                }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }  

    // SEARCH STUDENT BY THEIR NAME.
    public static void searchStudentName(String name){
        String sql = "SELECT * FROM student WHERE name = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();

                boolean found = false;
                while (rs.next()) {
                    found = true;
                    Student student = new Student();

                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setDob(rs.getString("dob"));
                    student.setMobileNumber(rs.getString("mobileNumber"));
                    student.setAddress(rs.getString("address"));

                    System.out.println("-----------------------------------------------------");
                    System.out.println(student);
                }

                if(!found){
                    System.out.println("student not found");
                }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // SEARCH STUDENT BY THEIR ID.
    public static void searchStudentId(int id){
        String sql = "SELECT * FROM student WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    Student student = new Student();

                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setDob(rs.getString("dob"));
                    student.setMobileNumber(rs.getString("mobileNumber"));
                    student.setAddress(rs.getString("address"));

                    System.out.println("-----------------------------------------------------");
                    System.out.println(student);
                    
                }

                if(!found){
                    System.out.println("student not found");
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
