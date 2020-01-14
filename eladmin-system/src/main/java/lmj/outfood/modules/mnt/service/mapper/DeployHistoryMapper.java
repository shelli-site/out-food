package lmj.outfood.modules.mnt.service.mapper;

import lmj.outfood.base.BaseMapper;
import lmj.outfood.modules.mnt.domain.DeployHistory;
import lmj.outfood.modules.mnt.service.dto.DeployHistoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeployHistoryMapper extends BaseMapper<DeployHistoryDto, DeployHistory> {

}
