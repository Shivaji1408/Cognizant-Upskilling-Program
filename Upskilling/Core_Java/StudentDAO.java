import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {

    String url = "jdbc:mysql://localhost:3306/college";
    String username = "root";
    String password = "root";

    // Insert Student
    public void insertStudent(int id, String name, int age) {

        String sql = "INSERT INTO students VALUES (?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            ps.executeUpdate();

            System.out.println("Student inserted successfully.");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update Student
    public void updateStudent(int id, String newName) {

        String sql = "UPDATE students SET name = ? WHERE id = ?";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newName);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Student updated successfully.");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        dao.insertStudent(104, "Priya", 20);

        dao.updateStudent(104, "Priya Sharma");
    }
}