package mb.te.service.dto;

import lmj.outfood.domain.Picture;
import lombok.Data;

import java.util.List;

/**
 * Created By shenxi On 2020/1/2 21:10
 * 列表视图对象
 */
@Data
public class FoodVo {
    private Long id;

    /**
     * 菜品名称
     */
    private String name;

    /**
     * 菜品类型
     */
    private List<String> typeNames;

    /**
     * 菜品类型ID
     */
    private List<Long> typeIds;

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
    private List<String> tagNames;

    /**
     * 标签Id
     */
    private List<Long> tagIds;

    private List<Picture> pictures;

    private Long sort;

    private String createTime;
}
