import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.hsqldb.jdbcDriver;

/*
* Database connection class.
* it return single instance of connection
* author: rajib_info@yahoo.com
*/

public class DBConnector {

public static Connection getConnection() {
Connection connection = null;

if (connection != null) {
return connection;
}

try {

jdbcDriver driver = new jdbcDriver();

Properties p = new Properties();
p.setProperty("username", "SA");
p.setProperty("password", "");
connection = driver.getConnection("jdbc:hsqldb:hsql://localhost:9001/GestionActivos", p);

} catch (Exception e) {
e.printStackTrace();
}
return connection;

}
}

