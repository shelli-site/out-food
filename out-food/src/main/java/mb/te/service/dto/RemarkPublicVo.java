package mb.te.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lmj.outfood.domain.Picture;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created By shenxi On 2020/3/2 15:27
 */
@Getter
@Setter
public class RemarkPublicVo {
    private Long id;
    private Long orderId;
    private String username;
    private String avatar;
    private String serviceState;
    private String content;
    private List<Picture> pictureList;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
}
