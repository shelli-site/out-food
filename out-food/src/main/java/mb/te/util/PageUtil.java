package mb.te.util;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lmj.outfood.utils.StringUtils;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By shenxi On 2020/1/2 22:01
 */
public class PageUtil {
    public static Page Pageable2Page(Pageable pageable) {
        try {
            Page page = new Page(pageable.getPageNumber() + 1, pageable.getPageSize());
            List<OrderItem> orders = new ArrayList<>();
            pageable.getSort().stream().forEach(o -> {
                orders.add(o.getDirection().isAscending() ? OrderItem.asc(StringUtils.toUnderScoreCase(o.getProperty())) : OrderItem.desc(StringUtils.toUnderScoreCase(o.getProperty())));
            });
            page.setOrders(orders);
            return page;
        } catch (NullPointerException e) {
            return new Page();
        }
    }

}
