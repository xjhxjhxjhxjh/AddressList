package xjhxjhxjhxjh.com.github.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接管理类:主要负责获取连接,开启事务,提交事务,回滚事务
 * 
 * @author xjhxjhxjh
 *
 */
public class ConnectionManager {
    // 定义一个集合 ThreadLocal 对象来保存当前线程的连接
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    // 获取连接
    public static Connection getConnection() throws SQLException {
        // 先从tl中获取连接
        Connection conn = tl.get();
        // 判断conn是否为空
        if (null == conn) {
            // 说明 是service层第一次获取
            conn = C3P0Utils.getConnection();
            tl.set(conn);
        }
        // 如果不为空说明是dao层第二次以后获取
        return conn;
    }

    // 开启事务
    public static void start() throws SQLException {
        ConnectionManager.getConnection().setAutoCommit(false);
    }

    // 提交事务
    public static void commit() throws SQLException {
        ConnectionManager.getConnection().commit();
    }

    // 回滚事务
    public static void rollback() throws SQLException {
        ConnectionManager.getConnection().rollback();
    }

    // 关闭连接
    public static void close() throws SQLException {
        ConnectionManager.getConnection().close();
    }
}