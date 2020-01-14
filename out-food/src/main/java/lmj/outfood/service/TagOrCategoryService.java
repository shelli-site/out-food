package lmj.outfood.service;

import lmj.outfood.domain.TagOrCategory;
import lmj.outfood.service.dto.TagOrCategoryDto;
import lmj.outfood.service.dto.TagOrCategoryQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
* @author shenxi
* @date 2019-12-24
*/
public interface TagOrCategoryService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(TagOrCategoryQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<TagOrCategoryDto>
    */
    List<TagOrCategoryDto> queryAll(TagOrCategoryQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return TagOrCategoryDto
     */
    TagOrCategoryDto findById(Long id);

    List<TagOrCategoryDto> findByIds(List<Long> ids);

    /**
    * 创建
    * @param resources /
    * @return TagOrCategoryDto
    */
    TagOrCategoryDto create(TagOrCategory resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(TagOrCategory resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Long[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<TagOrCategoryDto> all, HttpServletResponse response) throws IOException;
}