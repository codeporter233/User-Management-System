package dao;

import domain.Admin;
import domain.User;

import java.util.List;
import java.util.Map;

public interface Dao {

    /**
     * @return user表中所有user的List集合
     */
    public List<User> findAllUsers();

    /**
     * @return admin表中所有管理员的集合
     * */
    public List<Admin> findAllAdmins();

    /**
     * @return void
     * @param user 用户信息对象
     * */
    public void addUser(User user);

    /**
     * @return void
     * @param id user对象唯一对应的id值
     * */
    public void delUser(int id);

    /**
     * @return user对象
     * @param id user对象唯一对应的id值
     */
    public User findUserById(int id);

    /**
     * @return void
     * @param user 用户信息对象
     * */
    public void updateUser(User user);

    /**
     * @param start 数据库表中起始行
     * @param rows 每页包含的信息
     * @param condition request.getParameterMap() POST/GET传递的参数值Map集合
     * @return 每页user的List集合*/
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

    /**
     * @param condition request.getParameterMap() POST/GET传递的参数值Map集合
     * @return int 符合condition的user数量*/
    int findTotalCount(Map<String, String[]> condition);
}
