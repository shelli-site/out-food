package lmj.outfood.modules.mnt.service.mapper;

import lmj.outfood.base.BaseMapper;
import lmj.outfood.modules.mnt.domain.ServerDeploy;
import lmj.outfood.modules.mnt.service.dto.ServerDeployDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerDeployMapper extends BaseMapper<ServerDeployDto, ServerDeploy> {

}
