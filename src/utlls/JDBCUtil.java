package utlls;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;


public class JDBCUtil {

    private static DataSource ds;

    //初始化数据库连接池
    static {

        try {

            Properties pro = new Properties();
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("Druid.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }


    //获取连接池对象
    public static DataSource getDataSource() {
        return ds;
    }

    //获取连接Connection对象
    public static Connection getConnection() throws SQLException {

        return ds.getConnection();
    }

    //释放资源
    public static void  close (Statement statement, Connection connection) {

        if (statement != null) {

            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (connection != null) {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


    //重载的释放资源
    public static void  close (Statement statement, Connection connection, ResultSet resultSet) {

        if (statement != null) {

            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (connection != null) {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (resultSet != null) {

            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}

