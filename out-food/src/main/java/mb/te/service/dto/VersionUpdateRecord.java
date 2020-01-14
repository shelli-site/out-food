package mb.te.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Created By shenxi On 2020/1/13 21:53
 */
@Data
public class VersionUpdateRecord {
    private String version;
    private String title;
    private String content;
    private String sort;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp time;
}
