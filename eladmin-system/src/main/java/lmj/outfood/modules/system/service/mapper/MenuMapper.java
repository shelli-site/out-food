package lmj.outfood.modules.system.service.mapper;

import lmj.outfood.base.BaseMapper;
import lmj.outfood.modules.system.domain.Menu;
import lmj.outfood.modules.system.service.dto.MenuDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2018-12-17
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends BaseMapper<MenuDto, Menu> {

}
