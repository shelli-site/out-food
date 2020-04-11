package mb.te.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Created By shenxi On 2020/2/29 20:18
 */
@Data
public class Remark {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long orderId;
    private String serviceState;
    private String content;
    private String pictureIds;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
}
