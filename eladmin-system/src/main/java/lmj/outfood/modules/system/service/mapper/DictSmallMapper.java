package lmj.outfood.modules.system.service.mapper;

import lmj.outfood.base.BaseMapper;
import lmj.outfood.modules.system.domain.Dict;
import lmj.outfood.modules.system.service.dto.DictSmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictSmallMapper extends BaseMapper<DictSmallDto, Dict> {

}