package lmj.outfood.service.impl;

import lmj.outfood.domain.TagOrCategory;
import lmj.outfood.repository.TagOrCategoryRepository;
import lmj.outfood.service.TagOrCategoryService;
import lmj.outfood.service.dto.TagOrCategoryDto;
import lmj.outfood.service.dto.TagOrCategoryQueryCriteria;
import lmj.outfood.service.mapper.TagOrCategoryMapper;
import lmj.outfood.utils.FileUtil;
import lmj.outfood.utils.PageUtil;
import lmj.outfood.utils.QueryHelp;
import lmj.outfood.utils.ValidationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author shenxi
* @date 2019-12-24
*/
@Service
//@CacheConfig(cacheNames = "tagOrCategory")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TagOrCategoryServiceImpl implements TagOrCategoryService {

    private final TagOrCategoryRepository tagOrCategoryRepository;

    private final TagOrCategoryMapper tagOrCategoryMapper;

    public TagOrCategoryServiceImpl(TagOrCategoryRepository tagOrCategoryRepository, TagOrCategoryMapper tagOrCategoryMapper) {
        this.tagOrCategoryRepository = tagOrCategoryRepository;
        this.tagOrCategoryMapper = tagOrCategoryMapper;
    }

    @Override
    //@Cacheable
    public Map<String,Object> queryAll(TagOrCategoryQueryCriteria criteria, Pageable pageable){
        Page<TagOrCategory> page = tagOrCategoryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tagOrCategoryMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<TagOrCategoryDto> queryAll(TagOrCategoryQueryCriteria criteria){
        return tagOrCategoryMapper.toDto(tagOrCategoryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public TagOrCategoryDto findById(Long id) {
        TagOrCategory tagOrCategory = tagOrCategoryRepository.findById(id).orElseGet(TagOrCategory::new);
        ValidationUtil.isNull(tagOrCategory.getId(),"TagOrCategory","id",id);
        return tagOrCategoryMapper.toDto(tagOrCategory);
    }

    @Override
    public List<TagOrCategoryDto> findByIds(List<Long> ids){
        if (Objects.isNull(ids)) return new ArrayList<>();
        List<TagOrCategoryDto> tagOrCategories = tagOrCategoryRepository.findAllById(ids).stream().map(tagOrCategoryMapper::toDto).collect(Collectors.toList());
        return tagOrCategories;
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public TagOrCategoryDto create(TagOrCategory resources) {
        return tagOrCategoryMapper.toDto(tagOrCategoryRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(TagOrCategory resources) {
        TagOrCategory tagOrCategory = tagOrCategoryRepository.findById(resources.getId()).orElseGet(TagOrCategory::new);
        ValidationUtil.isNull( tagOrCategory.getId(),"TagOrCategory","id",resources.getId());
        tagOrCategory.copy(resources);
        tagOrCategoryRepository.save(tagOrCategory);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            tagOrCategoryRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<TagOrCategoryDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (TagOrCategoryDto tagOrCategory : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("名称", tagOrCategory.getName());
            map.put("排序", tagOrCategory.getSort());
            map.put("创建时间", tagOrCategory.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}