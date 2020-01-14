package mb.te.util;

import java.util.Date;

/**
 * Created By shenxi On 2020/1/2 22:18
 */
public class DateUtil {
    public static String format(Date date) {
        return cn.hutool.core.date.DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
    }
}
