package team.sdguys.test;

import team.sdguys.entity.UserInfo;
import team.sdguys.service.UserInfoService;
import team.sdguys.service.impl.UserInfoServiceImpl;

public class UserInfoServiceTest {
    public static void main(String[] args) {
        UserInfoService userInfoService = new UserInfoServiceImpl();
        userInfoService.createUserInfoByUid(6);
    }
}
