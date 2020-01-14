package mb.te.service.dto;

import lmj.outfood.domain.Picture;
import lmj.outfood.service.dto.TagOrCategoryDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author shenxi
 * @date 2020-01-01
 * 详情视图对象
 */
@Data
public class FoodDto implements Serializable {

    private Long id;

    /**
     * 菜品名称
     */
    private String name;

    /**
     * 菜品类型
     */
    private List<TagOrCategoryDto> types;

    /**
     * 价格
     */
    private Float price;

    /**
     * 推荐等级
     */
    private Float recommendationLevel;

    /**
     * 月销量
     */
    private String monthlySalesVolume;

    /**
     * 标签
     */
    private List<TagOrCategoryDto> tagsOrCategorys;

    /**
     * 详情图片
     */
    private List<Picture> pictures;

    /**
     * 描述
     */
    private String description;

    /**
     * 额外信息
     */
    private String information;

    private String createTime;
}