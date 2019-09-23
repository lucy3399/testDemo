package module;

import org.apache.commons.lang3.StringUtils;
import org.newsclub.net.mysql.AFUNIXDatabaseSocketFactory;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by zhuting on 2019/9/19.
 */
public class TestJdbc {



    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        //jdbc:mysql://主机名或IP抵制：端口号/数据库名?useUnicode=true&characterEncoding=UTF-8&useSSL=true
        String URL="jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT&useUnicode=true&characerEncoding=utf-8&useSSL=true";
        String USER="root";
        String PASSWORD="root";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);


        Statement st=conn.createStatement();
        int i = st.executeUpdate(" insert into person_info(name) values ('lisi')");
        System.out.println("影响行数: "+i);

        Connection conn2=DriverManager.getConnection(URL, USER, PASSWORD);

        Statement st1=conn2.createStatement();
        ResultSet rs=st1.executeQuery("select last_insert_id()");
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()) {
            System.out.println(rs.getInt(1));
        }
        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }



}
