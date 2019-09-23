import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.newsclub.net.mysql.AFUNIXDatabaseSocketFactory;


/**
 * Created by zhuting on 2019/6/27.
 */
public class TestJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
           String sql="select * from a lImIt  b";
        boolean limit = StringUtils.containsIgnoreCase(sql, "LIMIT");
        System.out.println(limit);

        //初始化驱动类com.mysql.jdbc.Driver
    /*    Class.forName("com.mysql.jdbc.Driver").newInstance();

        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "root");
        props.put("socketFactory", AFUNIXDatabaseSocketFactory.class.getName());
        props.put("junixsocket.file", "/tmp/mysql.sock");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///", props);
        System.out.println(conn.getMetaData().getURL());
        // 3.Connection->Statement
        Statement stmt = conn.createStatement();
        // 4.Statement->ResultSet
        String sql = "select @@version";
        ResultSet rs = stmt.executeQuery(sql);
        // 5.通过ResultSet获取数据
        while (rs.next()) {
            String id = rs.getString("@@version");
            System.out.println(id);

        }
*/

//        TestSSHUtil2.INSTANCE.init("172.16.100.150", "root", "419217");
//        System.out.println(TestSSHUtil2.INSTANCE.execute("pwd"));

    }



}
