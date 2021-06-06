package team.sdguys.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    /**
     * 格式化日期
     * @param date 需要格式化的日期
     * @return 格式化后的日期字符串
     */
    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化日期和时间
     * @param date 需要格式化的日期时间
     * @return 格式化后的日期时间字符串
     */
    public static String formatDateTime(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化年份
     * @param date 需要格式化的日期
     * @return 格式化后的年份字符串
     */
    public static String formatYear(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        return simpleDateFormat.format(date);
    }

}
