package mb.te.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lmj.outfood.domain.Picture;
import lmj.outfood.service.PictureService;
import lmj.outfood.service.TagOrCategoryService;
import lmj.outfood.service.dto.PictureQueryCriteria;
import lmj.outfood.service.dto.TagOrCategoryDto;
import lmj.outfood.service.dto.TagOrCategoryQueryCriteria;
import lmj.outfood.utils.StringUtils;
import mb.te.domain.Food;
import mb.te.mapper.FoodMapper;
import mb.te.service.FoodService;
import mb.te.service.dto.*;
import mb.te.util.DateUtil;
import mb.te.util.Normal;
import mb.te.util.PageUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created By shenxi On 2020/1/2 10:17
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Autowired
    FoodMapper foodMapper;
    @Autowired
    TagOrCategoryService tagOrCategoryService;
    @Autowired
    PictureService pictureService;

    @Override
    public Map<String, Object> list(FoodQueryCriteria criteria, Pageable pageable) {
        Map<String, Object> res = new HashMap<>();
        Page<Food> page = PageUtil.Pageable2Page(pageable);
        IPage<Food> resPage = foodMapper.queryAll(page);
        List<Food> list = resPage.getRecords();
        List<TagOrCategoryDto> tagOrCategoryDtos = tagOrCategoryService.queryAll(new TagOrCategoryQueryCriteria());
        List<Picture> pictures = pictureService.queryAll(new PictureQueryCriteria());
        res.put("totalElements", resPage.getTotal());
        res.put("content", list.stream().map(food -> toVo(food, tagOrCategoryDtos, pictures)).collect(Collectors.toList()));
        return res;
    }

    @Override
    public FoodDto get(Long id) {
        Food food = foodMapper.selectById(id);
        List<TagOrCategoryDto> types = tagOrCategoryService.findByIds(Normal.String2Ids(food.getType()));
        List<TagOrCategoryDto> tags = tagOrCategoryService.findByIds(Normal.String2Ids(food.getTagsOrCategorys()));
        List<Picture> pictures = pictureService.findByIds(Normal.String2Ids(food.getPictureIds()));
        return toDto(food, types, tags, pictures);
    }

    @Override
    public List<HomeFoodListVo> listAllFood() {
        List<TagOrCategoryDto> types = tagOrCategoryService.queryAll(new TagOrCategoryQueryCriteria(null, "category"));
        types.sort((type1, type2) -> (int) (type1.getSort() - type2.getSort()));
        List<HomeFoodListVo> result = types.stream().map(type -> new HomeFoodListVo(type.getId(), type.getName())).collect(Collectors.toList());
        List<FoodVo> foodVos = (List<FoodVo>) list(null, null).get("content");
        result.stream().forEach(type -> {
            type.setFoodList(toAppHomeVo(type.getCategoryId(), foodVos));
        });
        return result;
    }

    private List<HomeFoodVo> toAppHomeVo(Long categoryId, List<FoodVo> foodVos) {
        if (Objects.isNull(categoryId)) return new ArrayList<>();
        return foodVos.stream().filter(foodVo -> foodVo.getTypeIds().indexOf(categoryId) != -1).map(
                foodVo -> {
                    HomeFoodVo homeFoodVo = new HomeFoodVo();
                    homeFoodVo.setFoodId(foodVo.getId());
                    homeFoodVo.setFoodName(foodVo.getName());
                    homeFoodVo.setPictureId(foodVo.getPictures().size() > 0 ? foodVo.getPictures().get(0).getId() : 0);
                    homeFoodVo.setPictureUrl(foodVo.getPictures().size() > 0 ? foodVo.getPictures().get(0).getUrl() : "");
                    homeFoodVo.setMonthlySalesVolume(foodVo.getMonthlySalesVolume());
                    homeFoodVo.setPrice(foodVo.getPrice());
                    homeFoodVo.setTags(foodVo.getTagNames());
                    return homeFoodVo;
                }
        ).collect(Collectors.toList());
    }

    /*
     * @Param: [food, types, tags, pictures]
     * @Return: mb.te.service.dto.FoodDto
     * Created By shenxi On 2020/1/5 20:25
     * 实体转成详情视图对象
     **/
    private FoodDto toDto(Food food, List<TagOrCategoryDto> types, List<TagOrCategoryDto> tags, List<Picture> pictures) {
        FoodDto foodDto = new FoodDto();
        BeanUtils.copyProperties(food, foodDto);
        foodDto.setTypes(types);
        foodDto.setTagsOrCategorys(tags);
        foodDto.setPictures(pictures);
        foodDto.setRecommendationLevel(StringUtils.isBlank(food.getRecommendationLevel()) ? null : Float.parseFloat(food.getRecommendationLevel()));
        foodDto.setCreateTime(DateUtil.format(food.getCreateTime()));
        return foodDto;
    }

    /*
     * @Param: [food, tagOrCategoryDtos, pictures]
     * @Return: mb.te.service.dto.FoodVo
     * Created By shenxi On 2020/1/5 20:24
     * 实体转成列表视图对象
     **/
    private FoodVo toVo(Food food, List<TagOrCategoryDto> tagOrCategoryDtos, List<Picture> pictures) {
        FoodVo foodVo = new FoodVo();
        foodVo.setId(food.getId());
        foodVo.setName(food.getName());
        foodVo.setTypeIds((Objects.isNull(food.getType()) || StringUtils.isBlank(food.getType())) ?
                null : Arrays.asList(food.getType().split(",")).stream().map(t -> Long.parseLong(t)).collect(Collectors.toList()));
        foodVo.setTagIds((Objects.isNull(food.getTagsOrCategorys()) || StringUtils.isBlank(food.getTagsOrCategorys())) ?
                null : Arrays.asList(food.getTagsOrCategorys().split(",")).stream().map(t -> Long.parseLong(t)).collect(Collectors.toList()));
        foodVo.setPrice(food.getPrice());
        foodVo.setRecommendationLevel(StringUtils.isBlank(food.getRecommendationLevel()) ? null : Float.parseFloat(food.getRecommendationLevel()));
        foodVo.setMonthlySalesVolume(food.getMonthlySalesVolume());
        foodVo.setSort(food.getSort());
        foodVo.setCreateTime(DateUtil.format(food.getCreateTime()));

        foodVo.setTypeNames(Objects.isNull(foodVo.getTypeIds()) ? null : tagOrCategoryDtos.stream().filter(t ->
                foodVo.getTypeIds().indexOf(t.getId()) != -1).map(t -> t.getName()).collect(Collectors.toList()));
        foodVo.setTagNames(Objects.isNull(foodVo.getTagIds()) ? null : tagOrCategoryDtos.stream().filter(t ->
                foodVo.getTagIds().indexOf(t.getId()) != -1).map(t -> t.getName()).collect(Collectors.toList()));
        foodVo.setPictures(
                Objects.isNull(food.getPictureIds()) ? null :
                        pictures.stream().filter(pic ->
                                Arrays.asList(food.getPictureIds().split(",")).stream().map(t -> Long.parseLong(t)).collect(Collectors.toList()).indexOf(pic.getId()) != -1
                        ).collect(Collectors.toList()));
        return foodVo;
    }


}
