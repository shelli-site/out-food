package mb.te.util;

import lmj.outfood.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created By shenxi On 2020/1/5 17:23
 */
public class Normal {
    public static List<Long> String2Ids(String ids) {
        if (Objects.isNull(ids) || StringUtils.isBlank(ids)) {
            return null;
        }
        return Arrays.asList(ids.split(",")).stream().map(t -> Long.parseLong(t)).collect(Collectors.toList());
    }
}
