package xjhxjhxjhxjh.com.github.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 获取数据库连接
 * @author xjhxjhxjh
 *
 */
public class C3P0Utils {

    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    
    public static DataSource getDataSource(){
        return ds;
    }
    
    public static Connection getConnection() throws SQLException{
        //从C3P0连接池获取
        return ds.getConnection();
    }
    //关闭所有资源
    public static void closeAll(Connection conn,Statement st,ResultSet rs){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}