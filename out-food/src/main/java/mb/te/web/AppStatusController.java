package mb.te.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lmj.outfood.annotation.AnonymousAccess;
import lmj.outfood.aop.log.Log;
import lmj.outfood.modules.system.service.DictService;
import lmj.outfood.modules.system.service.dto.DictDto;
import lmj.outfood.modules.system.service.dto.DictQueryCriteria;
import mb.te.service.dto.AppStatus;
import mb.te.service.dto.VersionUpdateRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created By shenxi On 2020/1/13 20:52
 */
@Api(tags = "[LMJ]APP状态")
@RestController
@RequestMapping("/api/app_status")
public class AppStatusController {

    private final DictService dictService;

    @Autowired
    public AppStatusController(DictService dictService) {
        this.dictService = dictService;
    }

    @GetMapping
    @Log("查询APP状态")
    @ApiOperation("查询APP状态")
    @AnonymousAccess
    public ResponseEntity<Object> getStatusInfo() {
        DictQueryCriteria dict = new DictQueryCriteria();
        dict.setBlurry("app_status");
        return new ResponseEntity<>(toAppStatus(dictService.queryAll(dict)), HttpStatus.OK);
    }

    private AppStatus toAppStatus(List<DictDto> dictDtoList) {
        if (Objects.isNull(dictDtoList) || dictDtoList.size() == 0) return null;
        DictDto dictDto = dictDtoList.get(0);
        AppStatus appStatus = new AppStatus();
        appStatus.setName(dictDto.getName());
        appStatus.setRemark(dictDto.getRemark());
        List<VersionUpdateRecord> versionUpdateRecords = new ArrayList<>();
        dictDto.getDictDetails().forEach(dict -> {
            switch (dict.getValue()) {
                case "version":
                    appStatus.setAppVersion(dict.getLabel());
                    break;
                case "download_link":
                    appStatus.setAppDownloadLink(dict.getLabel());
                    break;
                default:
                    VersionUpdateRecord versionUpdateRecord = new VersionUpdateRecord();
                    Matcher matcher = Pattern.compile("(?<version>[\\d|.]+)").matcher(dict.getValue());
                    versionUpdateRecord.setVersion(matcher.find() ? matcher.group("version") : "未知版本");
                    versionUpdateRecord.setTitle(dict.getValue());
                    versionUpdateRecord.setContent(dict.getLabel());
                    versionUpdateRecord.setSort(dict.getSort());
                    versionUpdateRecord.setTime(dict.getCreateTime());
                    versionUpdateRecords.add(versionUpdateRecord);
                    break;
            }
        });
        versionUpdateRecords.sort((versionUpdateRecord1, versionUpdateRecord2) -> (int) (Integer.parseInt(versionUpdateRecord1.getSort()) - Integer.parseInt(versionUpdateRecord2.getSort())));
        appStatus.setVersionUpdateRecords(versionUpdateRecords);
        return appStatus;
    }
}
