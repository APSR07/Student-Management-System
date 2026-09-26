import java.sql.*;

public class StudentDAO{
    // insert student
    public static void insertStudent(Student student) {
        
        // SQL DATA INSERT QUERY 
        String sql = "INSERT INTO student " +
                     "(Sname, Sdob, Smobilenumber, Saddress, Scourse) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            

            ps.setString(1, student.getName());
            ps.setString(2, student.getDob());
            ps.setString(3, student.getMobileNumber());
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getCourse());

            ps.executeUpdate();
            System.out.println("Student inserted successfully");
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
                while (rs.next()) {
                    found = true;

                    Student student = new Student();

                    student.setId(rs.getInt("Sid"));
                    student.setName(rs.getString("Sname"));
                    student.setDob(rs.getString("Sdob"));
                    student.setMobileNumber(rs.getString("Smobilenumber"));
                    student.setAddress(rs.getString("Saddress"));
                    student.setCourse(rs.getString("Scourse"));

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
    public static void searchStudentName(String Sname){
        String sql = "SELECT * FROM student WHERE Sname = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
                ps.setString(1, Sname);
                ResultSet rs = ps.executeQuery();

                boolean found = false;
                while (rs.next()) {
                    found = true;
                    Student student = new Student();

                    student.setId(rs.getInt("Sid"));
                    student.setName(rs.getString("Sname"));
                    student.setDob(rs.getString("Sdob"));
                    student.setMobileNumber(rs.getString("Smobilenumber"));
                    student.setAddress(rs.getString("Saddress"));
                    student.setCourse(rs.getString("Scourse"));

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
        String sql = "SELECT * FROM student WHERE Sid = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    Student student = new Student();

                    student.setId(rs.getInt("Sid"));
                    student.setName(rs.getString("Sname"));
                    student.setDob(rs.getString("Sdob"));
                    student.setMobileNumber(rs.getString("Smobilenumber"));
                    student.setAddress(rs.getString("Saddress"));
                    student.setCourse(rs.getString("Scourse"));

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

    // DELETE STUDENT BY THEIR ID.
    public static void deleteStudentId(int id){
        String sql = "DELETE FROM student WHERE Sid = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){

                ps.setInt(1, id);
                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("Student deleted successfully");
                }else{
                    System.out.println("Student not found");
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
