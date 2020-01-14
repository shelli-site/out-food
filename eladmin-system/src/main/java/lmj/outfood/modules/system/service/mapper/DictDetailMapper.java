package lmj.outfood.modules.system.service.mapper;

import lmj.outfood.modules.system.service.dto.DictDetailDto;
import lmj.outfood.base.BaseMapper;
import lmj.outfood.modules.system.domain.DictDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Mapper(componentModel = "spring", uses = {DictSmallMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends BaseMapper<DictDetailDto, DictDetail> {

}