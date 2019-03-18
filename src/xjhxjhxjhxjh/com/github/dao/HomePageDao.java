package xjhxjhxjhxjh.com.github.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import xjhxjhxjhxjh.com.github.domain.Contact;
import xjhxjhxjhxjh.com.github.utils.C3P0Utils;
import xjhxjhxjhxjh.com.github.utils.ConnectionManager;

public class HomePageDao {

    /**
     *  查询所有联系人
     * @param username
     * @return 
     * @throws SQLException 
     */
    public List<Contact> findAll(String username) throws SQLException {
        //获取连接
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM " + username;
        return queryRunner.query(sql, new BeanListHandler<Contact>(Contact.class));
    }
    /**
     * 添加联系人
     * @param contact
     * @param username
     * @throws SQLException
     */
    public void add(Contact contact, String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "INSERT INTO " + username + " VALUES (?,?,?,?,?,?,?)";
        queryRunner.update(sql, contact.getId(), contact.getName(), contact.getSex(), contact.getTelephoneNumber(),
                contact.getAddress(),contact.getqqNumber(),contact.getUgroup());
    }
    /**
     * 删除联系人
     * @param id
     * @param username
     * @throws SQLException 
     */
    public void delete(String id, String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "DELETE FROM " + username +" WHERE id = ?";
        queryRunner.update(sql,id);
    }
    /**
     * 批量删除联系人
     * @param id
     * @param username 
     * @throws SQLException 
     */
    public void batchDelete(String id, String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql =  "DELETE FROM " + username + " WHERE id = ?";
        queryRunner.update(ConnectionManager.getConnection(), sql, id);
    }
    /**
     * 根据ID获取联系人
     * @param id
     * @param username
     * @return
     * @throws SQLException 
     */
    public Contact findContactByID(String id, String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM " + username + " WHERE id = ?";
        return queryRunner.query(sql, new BeanHandler<Contact>(Contact.class), id);
    }
    /**
     * 更新联系人信息
     * @param contact
     * @param username
     * @throws SQLException 
     */
    public void update(Contact contact, String username) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update " + username + " set name=?,sex=?,telephoneNumber=?,address=?,qqNumber=?,ugroup=? where id=?";
        queryRunner.update(sql, contact.getName(), contact.getSex(), contact.getTelephoneNumber(),
                contact.getAddress(),contact.getqqNumber(),contact.getUgroup(), contact.getId());
    }
    /**
     * 关键词搜索
     * @param name
     * @param ugroup
     * @param username
     * @return
     * @throws SQLException 
     */
    public List<Contact> search(String name, String ugroup, String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        //拼写SQL语句
        StringBuilder sb = new StringBuilder("SELECT * FROM "+username+" product WHERE 1=1 ");
        List<String> list = new ArrayList<String>();
        if (name != "") {
            sb.append("AND name LIKE ? ");
            list.add("%"+name+"%");
        }
        if (ugroup != "") {
            sb.append("AND ugroup LIKE ?");
            list.add("%"+ugroup+"%");
        }
        return queryRunner.query(sb.toString(), new BeanListHandler<Contact>(Contact.class), list.toArray());
    }

}
