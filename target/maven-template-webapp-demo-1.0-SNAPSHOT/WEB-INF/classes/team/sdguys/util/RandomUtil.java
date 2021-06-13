package team.sdguys.util;

import java.util.Random;

/**
 * 生成随机数的工具类
 */
public class RandomUtil {

    private static Random random = new Random();

    /**
     * 生成len位数的邮箱验证码
     * @param len 验证码的位数
     * @return 生成的验证码
     */
    public static String generateVerificationCode(int len){
        String code = "";
        for(int i=0; i<len; i++){
            code +=  random.nextInt(10);
        }
        return code;
    }

}
