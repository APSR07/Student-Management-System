import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;
public class DBConnection {
    private static final Dotenv dotenv = Dotenv.load();

    private static final String URL = "jdbc:mysql://localhost:3306/studentdata";

    private static final String USERNAME = "root";

    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    public static Connection getConnection() {

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Database connected successfully!");

            return connection;

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            e.printStackTrace();

            return null;
        }
    }
}
