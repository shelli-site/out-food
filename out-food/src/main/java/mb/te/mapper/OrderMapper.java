package mb.te.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mb.te.domain.Order;
import mb.te.service.dto.OrderGetVo;
import mb.te.service.dto.OrderListVo;
import mb.te.service.dto.OrderQueryCriteria;

/**
 * Created By shenxi On 2020/2/26 21:05
 */
public interface OrderMapper extends BaseMapper<Order> {
    Integer paidOrder(Long id);

    IPage<OrderListVo> query(OrderQueryCriteria query, Page page);

    OrderGetVo queryOrder(Long id);
}
