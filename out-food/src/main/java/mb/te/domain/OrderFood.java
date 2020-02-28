package mb.te.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * Created By shenxi On 2020/2/26 21:01
 */
@Data
public class OrderFood extends Model<OrderFood> implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long orderId;
    private Long foodId;
    private String foodName;
    private String pictureUrl;
    private Integer foodCounts;
    private Float priceCost;
}
