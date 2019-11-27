import com.sun.jdi.ClassNotPreparedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {

    public static void main(String[] args) {

        //String sql = "SELECT * FROM Beers WHERE Alcohol > 5";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beers_db","root","mysql")) {
        //("jdbc:mysql://noelvaes.eu/StudentDB","student","student123"))
            System.out.println("connection ok");



            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "UPDATE Beers SET Price";

            PreparedStatement prep = con.prepareStatement(sql);
            prep.executeQuery();

            ResultSet rs =stmt.executeQuery(sql);
            List<Object> lijst= new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                lijst.add(id);
                String name = rs.getString("name");
                lijst.add(name);
                int brewerId = rs.getInt("BrewerId");
                lijst.add(brewerId);
                int categoryID = rs.getInt("CategoryID");
                float price = rs.getFloat("Price");
                int stock = rs.getInt("Stock");
                float alchohol = rs.getFloat("Alcohol");
                System.out.println(id + " " + name + " " + stock + " " + price + "alchohol :" + alchohol);
            }

        }
        catch (Exception ex) {

            System.out.println("oops, something wrong");
            ex.printStackTrace(System.err);
        }
    }


}
