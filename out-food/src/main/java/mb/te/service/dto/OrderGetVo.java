package mb.te.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import mb.te.domain.OrderFood;

import java.util.Date;
import java.util.List;

/**
 * Created By shenxi On 2020/2/29 11:56
 */
@Getter
@Setter
public class OrderGetVo {
    private Long id;
    private Long userId;
    private String status;
    private Float packingCost;
    private Float priceTotal;
    private String tableNum;
    private String extra;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderCancelTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderPayTime;
    private List<OrderFood> orderFoods;
}
