package mb.te.service.dto;

import lombok.Data;

import java.util.List;

/**
 * Created By shenxi On 2020/1/13 21:53
 */
@Data
public class AppStatus {
    private String name;
    private String remark;
    private String appVersion;
    private String appDownloadLink;
    private List<VersionUpdateRecord> versionUpdateRecords;
}
