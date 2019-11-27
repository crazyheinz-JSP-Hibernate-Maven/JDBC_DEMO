import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatement {

    public static void main(String[] args) {

        try (Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/beers_db",
                "root","mysql")){
            try (Statement statement =
                         con.createStatement()) {
                con.setAutoCommit(false);

                statement.executeUpdate("UPDATE Beers SET Stock = 50 WHERE Name LIKE '%Kriek%'");
                statement.executeUpdate("UPDATE Beers SET Alcohol = 200 WHERE Name = 'Zulte'");
                con.commit();
            }

            catch (SQLException e ) {
                con.rollback();
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
