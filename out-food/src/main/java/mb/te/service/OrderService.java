package mb.te.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import mb.te.domain.Order;
import mb.te.service.dto.OrderGetVo;
import mb.te.service.dto.OrderQueryCriteria;
import mb.te.service.dto.OrderSubmitVo;

import java.util.Map;

/**
 * Created By shenxi On 2020/2/26 21:10
 */
public interface OrderService extends IService<Order> {
    Map<String, Object> submitOrder(OrderSubmitVo orderSubmitVo);

    Map<String, Object> paidOrder(Long id);

    Map<String, Object> list(OrderQueryCriteria criteria, Page page);

    OrderGetVo getOrderById(Long id);
}
