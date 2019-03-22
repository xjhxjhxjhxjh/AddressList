package xjhxjhxjhxjh.com.github.service;

import java.sql.SQLException;
import java.util.List;

import xjhxjhxjhxjh.com.github.dao.HomePageDao;
import xjhxjhxjhxjh.com.github.domain.Contact;
import xjhxjhxjhxjh.com.github.domain.Page;
import xjhxjhxjhxjh.com.github.utils.ConnectionManager;

public class HomePageService {

    /**
     * s* 查询所有联系人
     * 
     * @param username
     * @return
     * @throws SQLException
     */
    public List<Contact> findAll(String username) throws SQLException {
        // 创建dao
        HomePageDao homePageDao = new HomePageDao();
        // 调用方法
        return homePageDao.findAll(username);
    }

    /**
     * 添加联系人
     * 
     * @param contact
     * @param username
     * @throws SQLException
     */
    public void add(Contact contact, String username) throws SQLException {
        HomePageDao homePageDao = new HomePageDao();
        homePageDao.add(contact, username);
    }

    /**
     * 删除联系人
     * 
     * @param id
     * @param username
     * @throws SQLException
     */
    public void delete(String id, String username) throws SQLException {
        HomePageDao homePageDao = new HomePageDao();
        homePageDao.delete(id, username);
    }

    /**
     * 批量删除联系人
     * 
     * @param ids
     * @param username
     * @throws SQLException
     */
    public void batchDelete(String[] ids, String username) throws SQLException {
        try {
            // 开启事务
            ConnectionManager.start();
            HomePageDao homePageDao = new HomePageDao();
            if (null != ids) {
                for (String id : ids) {
                    homePageDao.batchDelete(id, username);
                }
            }
            // 提交事务
            ConnectionManager.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // 回滚事务
            ConnectionManager.rollback();
            throw e;
        }
    }

    /**
     * 根据ID获取联系人
     * 
     * @param id
     * @param username
     * @return
     * @throws SQLException
     */
    public Contact findContactByID(String id, String username) throws SQLException {
        HomePageDao homePageDao = new HomePageDao();
        return homePageDao.findContactByID(id, username);
    }

    /**
     * 更新联系人信息
     * 
     * @param contact
     * @param username
     * @throws SQLException
     */
    public void update(Contact contact, String username) throws SQLException {
        HomePageDao homePageDao = new HomePageDao();
        homePageDao.update(contact, username);
    }

    /**
     * 关键词搜索
     * 
     * @param name
     * @param ugroup
     * @param username
     * @return
     * @throws SQLException
     */
    public List<Contact> search(String name, String ugroup, String username) throws SQLException {
        HomePageDao homePageDao = new HomePageDao();
        return homePageDao.search(name, ugroup, username);
    }

    /**
     * 分页查询
     * 
     * @param pageNumber
     * @param pageSize
     * @param username
     * @return
     * @throws SQLException
     */
    public Page<Contact> getPage(int pageNumber, int pageSize, String username) throws SQLException {
        HomePageDao homePageDao = new HomePageDao();
        Page<Contact> page = new Page<Contact>(pageSize, pageNumber);
        // 获取总条数
        int count = homePageDao.getCount(username);
        page.setPageSumNumber(count);
        // 获取每页显示的内容
        List<Contact> list = homePageDao.getList(page, username);
        page.setList(list);
        return page;
    }

}
