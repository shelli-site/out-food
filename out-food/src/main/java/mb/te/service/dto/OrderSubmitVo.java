package mb.te.service.dto;

import lombok.Data;

import java.util.List;

/**
 * Created By shenxi On 2020/2/26 21:22
 */
@Data
public class OrderSubmitVo {
    private Float packingCost;
    private Float priceTotal;
    private String tableNum;
    private String extra;
    private List<OrderFoodSubmitVo> orderFoodSubmitVos;
}
