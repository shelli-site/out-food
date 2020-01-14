package lmj.outfood.service.mapper;

import lmj.outfood.domain.TagOrCategory;
import lmj.outfood.service.dto.TagOrCategoryDto;
import lmj.outfood.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author shenxi
* @date 2019-12-24
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagOrCategoryMapper extends BaseMapper<TagOrCategoryDto, TagOrCategory> {

}