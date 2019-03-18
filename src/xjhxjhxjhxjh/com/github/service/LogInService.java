package xjhxjhxjhxjh.com.github.service;

import java.sql.SQLException;

import xjhxjhxjhxjh.com.github.dao.LogInDao;
import xjhxjhxjhxjh.com.github.domain.User;

public class LogInService {
    //创建LoginDao
    public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
        LogInDao dao = new LogInDao();
        return dao.getUserByUsenameAndPwd(username, password);
    }
}
