package lmj.outfood.modules.mnt.service.mapper;

import lmj.outfood.modules.mnt.service.dto.DatabaseDto;
import lmj.outfood.base.BaseMapper;
import lmj.outfood.modules.mnt.domain.Database;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DatabaseMapper extends BaseMapper<DatabaseDto, Database> {

}
