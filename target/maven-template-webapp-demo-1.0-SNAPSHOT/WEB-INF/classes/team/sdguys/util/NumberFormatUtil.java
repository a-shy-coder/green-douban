package team.sdguys.util;

import java.text.DecimalFormat;

public class NumberFormatUtil {

    /**
     * 保留一位小数
     * @param number 需要格式化的浮点数
     * @return 保留一位小数的浮点数
     */
    public static String reserveADecimalPlace(double number){
        DecimalFormat df = new DecimalFormat("#.0");
        return df.format(number);
    }

    public static void main(String[] args) {
        System.out.println(reserveADecimalPlace(1));
    }
}
