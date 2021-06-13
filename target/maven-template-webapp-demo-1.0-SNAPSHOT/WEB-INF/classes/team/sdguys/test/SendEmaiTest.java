package team.sdguys.test;

import team.sdguys.util.EmailUtil;
import team.sdguys.util.RandomUtil;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public class SendEmaiTest {
    public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
        EmailUtil.sendEmail("1286640687@qq.com", RandomUtil.generateVerificationCode(6));
    }
}
