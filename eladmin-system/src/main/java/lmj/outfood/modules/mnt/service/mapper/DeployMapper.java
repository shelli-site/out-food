package lmj.outfood.modules.mnt.service.mapper;

import lmj.outfood.modules.mnt.service.dto.DeployDto;
import lmj.outfood.base.BaseMapper;
import lmj.outfood.modules.mnt.domain.Deploy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",uses = {AppMapper.class, ServerDeployMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeployMapper extends BaseMapper<DeployDto, Deploy> {

}
