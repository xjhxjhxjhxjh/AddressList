package xjhxjhxjhxjh.com.github.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import xjhxjhxjhxjh.com.github.domain.User;
import xjhxjhxjhxjh.com.github.utils.C3P0Utils;

public class LogInDao {
    public User getUserByUsenameAndPwd(String username, String password) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        return qr.query("SELECT * FROM User WHERE username = ? and password = ?", new BeanHandler<User>(User.class),
                username, password);
    }
}
