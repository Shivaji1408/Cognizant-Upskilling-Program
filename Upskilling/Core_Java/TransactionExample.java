import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "root";

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            con.setAutoCommit(false);

            String debit = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            String credit = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            PreparedStatement ps1 = con.prepareStatement(debit);
            ps1.setInt(1, 1000);
            ps1.setInt(2, 1);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(credit);
            ps2.setInt(1, 1000);
            ps2.setInt(2, 2);
            ps2.executeUpdate();

            con.commit();

            System.out.println("Transaction Successful.");

            ps1.close();
            ps2.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Transaction Failed.");
            System.out.println(e);
        }
    }
}