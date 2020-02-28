package mb.te.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By shenxi On 2020/2/26 20:56
 */
@Data
@TableName("`order`")
public class Order extends Model<Order> implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
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
}
