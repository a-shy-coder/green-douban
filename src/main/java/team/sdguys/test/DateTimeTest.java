package team.sdguys.test;

import java.sql.Timestamp;
import java.util.Date;

public class DateTimeTest {
    public static void main(String[] args) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
    }
}
