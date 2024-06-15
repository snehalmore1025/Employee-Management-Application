import java.sql.*;
public class EmployeeDatabase {
    static final String URL = "jdbc:mysql://localhost3306/mydb";
   static final String USER = "root";
   static final String PASS = "root@123";
    public EmployeeDatabase() {
        createDatabase();
        createTable();
    }
    private void createDatabase() {
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "CREATE DATABASE Task4";
         stmt.executeUpdate(sql);
         System.out.println("Database created successfully...");   	  
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      } 
   }
    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS employees111("
                + "id INTEGER PRIMARY KEY,"
                + "name TEXT NOT NULL,"
                + "position TEXT NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addEmp(Employee emp) {
        String sql = "INSERT INTO employees111(id, name, position) VALUES("
                + emp.getid() + ", '"
                + emp.getnm() + "', '"
                + emp.getpos() + "');";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Employee viewEmployee(int id) {
        String sql = "SELECT id, name, position FROM employees111 WHERE id = " + id;
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("position"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public boolean updateEmp(int id, String nm, String pos) {
        String sql = "UPDATE employees111 SET name = '" + nm + "', position = '" + pos + "' WHERE id = " + id;
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            int affectedRows = stmt.executeUpdate(sql);
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean delEmp(int id) {
        String sql = "DELETE FROM employees111 WHERE id = " + id;
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            int affectedRows = stmt.executeUpdate(sql);
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public ResultSet viewAllEmp() {
        String sql = "SELECT id, name, position FROM employees111";
        try {
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
