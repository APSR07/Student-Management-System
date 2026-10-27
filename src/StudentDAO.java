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

    // UPDATE STUDENT.
    public static void updateStudent(int sId, int updateChoice, String newValue){
        String sql = "";
        switch (updateChoice) {
            case 1:
                sql = "UPDATE student SET Sname = ? WHERE Sid = ?";
                break;
            case 2:
                sql = "UPDATE student SET Sdob = ? WHERE Sid = sId";
                break;
            case 3:
                sql = "UPDATE student SET Smobilenumber = ? WHERE Sid = sId";
                break;
            case 4:
                sql = "UPDATE student SET Saddress = ? WHERE Sid = sId";
                break;
            case 5:
                sql = "UPDATE student SET Scourse = ? WHERE Sid = sId";
                break;
            default:
                System.out.println("Invalid choice !!!!!!!!!!!!!!!!!!!!");
                break;
        }

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            
            // set the new value
            switch (updateChoice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    ps.setString(1, newValue);
                    break;
            
                default:
                    break;
            }
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("Unable to update student.");
            e.printStackTrace();
        }
        
    }

    // ID EXIST
    public static boolean idExist(int sId){
        String sql = "SELECT Sid FROM student WHERE Sid = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            
                ps.setInt(1, sId);

                try(ResultSet rs = ps.executeQuery()){
                    return rs.next();
                }

        } catch (SQLException e) {
            System.out.println("Error checking student ID.");
            e.printStackTrace();
            return false;
        }
    }
}
