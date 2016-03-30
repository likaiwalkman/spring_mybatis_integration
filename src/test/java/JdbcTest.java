import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcTest {
    public static void main(String[] args) {
        try {

            InputStream ins = JdbcTest.class.getResourceAsStream("databaseConfig/mysql.properties");
            Properties properties = new Properties();
            properties.load(ins);
            String url      = properties.getProperty("jdbc.url");   //database specific url.
            String user     = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");
            Class.forName(properties.getProperty("jdbc.driverClassName"));

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from member");
            while (rs.next()){
                String str = rs.toString();
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    System.out.println(rs.getObject(i+1));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
