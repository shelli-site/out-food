package mb.te.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created By shenxi On 2020/2/28 16:07
 */
@Data
public class OrderListVo {
    private Long orderId;
    private String status;
    private String statusLabel;
    private String detailUrl;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderStartTime;
    private String firstFoodName;
    private Integer foodCounts;
    private Float priceTotal;
}
