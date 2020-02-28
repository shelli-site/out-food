package mb.te.service.dto;

import lombok.Data;

/**
 * Created By shenxi On 2020/2/26 21:35
 */
@Data
public class OrderFoodSubmitVo {
    private Long foodId;
    private String foodName;
    private String pictureUrl;
    private Integer foodCounts;
    private Float priceCost;
}
