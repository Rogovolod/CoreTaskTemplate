package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
//        userService.createUsersTable();
//        userService.saveUser("testName1", "testLastName99", (byte) 100);
//        userService.removeUserById(2);
//        userService.getAllUsers();
    }
}
