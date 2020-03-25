package dao.impl;

import dao.Dao;
import domain.Admin;
import domain.User;
import utlls.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DaoImpl implements Dao {


    Connection connection;
    Statement statement;
    ResultSet rs;


    @Override
    @Deprecated
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<User>();
        try {

            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM user";
            rs = statement.executeQuery(sql);

            //封装成User对象
            while (rs.next()) {
                User user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("qq"),rs.getString("gender"),rs.getInt("age"),rs.getString("address"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtil.close(statement,connection,rs);

        return users;
    }

    @Override
    public List<Admin> findAllAdmins() {
        List<Admin> admins = new ArrayList<Admin>();
        try {

            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM admin";
            rs = statement.executeQuery(sql);

            //获取所有管理员用户
            while (rs.next()) {
                Admin admin = new Admin(rs.getString("name"), rs.getString("password"));
                admins.add(admin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtil.close(statement,connection,rs);

        return admins;
    }

    @Override
    public void addUser(User user) {
        try {

            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String sql = String.format("INSERT INTO `test`.`user` (`name`, `gender`, `age`, `address`, `qq`, `email`) VALUES ('%s', '%s', '%d', '%s', '%s', '%s')",user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtil.close(statement,connection);

    }


    @Override
    public void delUser(int id) {
        try {

            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String sql = String.format("DELETE FROM `test`.`user` WHERE (`id` = '%d')",id);
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtil.close(statement,connection);

    }

    @Override
    public User findUserById(int id) {

        User user = null;
        try {

            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();

            //sql语句格式化
            String sql = String.format("select * FROM `test`.`user` WHERE (`id` = %d)",id);
            rs = statement.executeQuery(sql);

            rs.next();
            user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("qq"),rs.getString("gender"),rs.getInt("age"),rs.getString("address"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.close(statement, connection,rs);
        return user;
    }

    @Override
    public void updateUser(User user) {
        try {

            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();

            //sql语句格式化
            String sql = String.format("UPDATE `test`.`user` SET `name` = '%s', `gender` = '%s', `age` = '%d', `address` = '%s', `qq` = '%s', `email` = '%s' WHERE (`id` = '%d');",user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtil.close(statement,connection);

    }

    @Override
    public List<User> findByPage(int start, int rows,Map<String, String[]> condition) {

        List<User> users = new ArrayList<User>();
        try {

            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();

            String sql = "select * from user where true ";
            StringBuilder sb = new StringBuilder(sql);
            Set<String> keySet = condition.keySet();
            System.out.println(keySet);

            //获取name，gender，address追加到sql后
            //形如：select * from user where true and xxx = "xxx" and yyy = "yyy" limit start , rows
            //或 select * from user where true  limit start , rows
           for (String key : keySet) {


               //将currentPage，rows两个非user属性过滤
               //查找用户只用了name，gender，address属性
                if("currentPage".equals(key) || "rows".equals(key)){
                    continue;

                }

                String value = condition.get(key)[0];

                if(value != null && !"".equals(value)){
                    //有值
                    String append = " and " + key + " like '%" + value +"%'";
                    sb.append(append);

                }
            }

            String append = String.format(" limit %d,%d",start,rows);
            sb.append(append);
            sql = sb.toString();

            rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("qq"),rs.getString("gender"),rs.getInt("age"),rs.getString("address"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtil.close(statement,connection,rs);

        return users;

    }


    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        int row = 0;
        try {

            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            //数据数量
            String sql = "select count(*) from user where true ";
            StringBuilder sb = new StringBuilder(sql);
            Set<String> keySet = condition.keySet();

            System.out.println(keySet);
            for (String key : keySet) {

                if("currentPage".equals(key) || "rows".equals(key)){
                    continue;
                }

                String value = condition.get(key)[0];

                if(value != null && !"".equals(value)){

                    String append = " and " + key + " like '%" + value +"%'";
                    sb.append(append);
                }
            }
            sql = sb.toString();

            rs=statement.executeQuery(sql);
            rs.next();
            row=rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtil.close(statement,connection,rs);

        return row;

    }
}
