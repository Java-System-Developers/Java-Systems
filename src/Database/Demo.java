package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        connect();
    }

    // Connect to Sample Database
    public static void connect() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            // DB Parameters
            String url = "jdbc:sqlite:products.sqlite";
            // Create a Connection to the Database
            connection = DriverManager.getConnection(url);
            System.out.println("Connection Has been established");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
