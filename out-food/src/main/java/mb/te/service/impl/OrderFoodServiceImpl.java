package mb.te.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mb.te.domain.OrderFood;
import mb.te.mapper.OrderFoodMapper;
import mb.te.service.OrderFoodService;
import org.springframework.stereotype.Service;

/**
 * Created By shenxi On 2020/2/26 21:08
 */
@Service
public class OrderFoodServiceImpl extends ServiceImpl<OrderFoodMapper, OrderFood> implements OrderFoodService {
}
