package team.sdguys.test;

import team.sdguys.service.UserService;
import team.sdguys.service.impl.UserServiceImpl;

public class UserServiceTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        boolean result = userService.validateLoginPassword("1285929172@qq.com","172929shy");
        System.out.println(result);
    }
}
