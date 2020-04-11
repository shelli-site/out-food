package mb.te.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lmj.outfood.domain.Picture;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created By shenxi On 2020/3/1 19:30
 */
@Getter
@Setter
public class RemarkVo {
    private Long id;
    private Long orderId;
    private String serviceState;
    private String content;
    private List<Picture> pictureList;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
}
