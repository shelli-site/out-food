package mb.te.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lmj.outfood.modules.system.service.UserService;
import lmj.outfood.utils.SecurityUtils;
import mb.te.domain.Order;
import mb.te.domain.OrderFood;
import mb.te.mapper.OrderMapper;
import mb.te.service.OrderFoodService;
import mb.te.service.OrderService;
import mb.te.service.dto.OrderGetVo;
import mb.te.service.dto.OrderListVo;
import mb.te.service.dto.OrderQueryCriteria;
import mb.te.service.dto.OrderSubmitVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created By shenxi On 2020/2/26 21:11
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    UserService userService;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderFoodService orderFoodService;

    /*
     * @Param: [orderSubmitVo]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * Created By shenxi On 2020/2/27 23:41
     **/
    @Override
    @Transactional
    public Map<String, Object> submitOrder(OrderSubmitVo orderSubmitVo) {
        Map<String, Object> result = new HashMap<>();
        Order order = new Order();
        BeanUtils.copyProperties(orderSubmitVo, order);
        order.setUserId(userService.findByName(SecurityUtils.getUsername()).getId());
        order.setStatus("unpaid");
        order.setOrderStartTime(new Date());
        this.save(order);
        List<OrderFood> orderFoods = orderSubmitVo.getOrderFoodSubmitVos().stream()
                .map(orderFoodSubmitVo -> {
                    OrderFood orderFood = new OrderFood();
                    BeanUtils.copyProperties(orderFoodSubmitVo, orderFood);
                    orderFood.setOrderId(order.getId());
                    return orderFood;
                }).collect(Collectors.toList());
        orderFoodService.saveBatch(orderFoods);
        result.put("orderId", order.getId());
        result.put("order", order);
        result.put("orderFoods", orderFoods);
        return result;
    }

    /*
     * @Param: [id]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * Created By shenxi On 2020/2/27 23:41
     **/
    @Override
    @Transactional
    public Map<String, Object> paidOrder(Long id) {
        Map<String, Object> result = new HashMap<>();
        // 检测是否为当前用户，以及支付验证。。。
        result.put("operation", this.retBool(orderMapper.paidOrder(id)));
        return result;
    }

    @Override
    public Map<String, Object> list(OrderQueryCriteria criteria, Page page) {
        Map<String, Object> result = new HashMap<>();
        criteria.setUserId(userService.findByName(SecurityUtils.getUsername()).getId());
        IPage<OrderListVo> orderListVoIPage = orderMapper.query(criteria, page);
        result.put("list", orderListVoIPage.getRecords());
        result.put("pageTotal", orderListVoIPage.getTotal());
        result.put("pageNo", orderListVoIPage.getCurrent());
        result.put("pageSize", orderListVoIPage.getSize());
        return result;
    }

    @Override
    public OrderGetVo getOrderById(Long id) {
        return orderMapper.queryOrder(id);
    }
    /*
     * Optional.ofNullable("not Null").orElse("is Null");
     * result : "not Null"
     **/
}
