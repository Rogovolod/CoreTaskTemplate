package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl usDaoJDBC = new UserDaoJDBCImpl();

    public void createUsersTable() {
        usDaoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        usDaoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        usDaoJDBC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        usDaoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return usDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        usDaoJDBC.cleanUsersTable();
    }
}
