package lmj.outfood.modules.system.service.mapper;

import lmj.outfood.base.BaseMapper;
import lmj.outfood.modules.system.domain.Dept;
import lmj.outfood.modules.system.service.dto.DeptDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends BaseMapper<DeptDto, Dept> {

}