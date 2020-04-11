package mb.te.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Created By shenxi On 2020/3/1 21:02
 */
@Getter
@Setter
public class RemarkCreatVo {
    @NotNull(groups = {Update.class})
    @Null(groups = {Insert.class})
    private Long id;
    @NotNull(groups = {Insert.class})
    private Long orderId;
    private String serviceState;
    private String content;
    private String pictureIds;

    public @interface Update {
    }

    public @interface Insert {
    }
}
