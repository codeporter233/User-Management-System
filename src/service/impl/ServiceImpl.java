package service.impl;

import dao.Dao;
import dao.impl.DaoImpl;
import domain.Admin;
import domain.PageBean;
import domain.User;
import org.junit.Test;
import service.Service;

import java.util.List;
import java.util.Map;

public class ServiceImpl implements Service {

    private Dao dao = new DaoImpl();

    @Override
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    @Override
    public int login(String name, String password) {
        List<Admin> admins = dao.findAllAdmins();
        for (Admin admin:admins
        ) {
            if (admin.getName().equals(name) && admin.getPassword().equals(password))
                return 1;
            else if (admin.getName().equals(name))
                return 0;
        }
        return -1;
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void delUser(int id) {
        dao.delUser(id);
    }


    @Override
    public User findUserById(int id) {
        User user = dao.findUserById(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delUsers(String[] ids) {
        for (String id:ids
             ) {
            dao.delUser(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean findUserByPage(String strCurrentPage, String strRows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(strCurrentPage);
        int rows = Integer.parseInt(strRows);

        if(currentPage <=0) {
            currentPage = 1;
        }

        PageBean pb = new PageBean();
        //设置当前页数和每页行数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //查询并设置总条数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);


        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start,rows,condition);
        pb.setList(list);


        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }
}
