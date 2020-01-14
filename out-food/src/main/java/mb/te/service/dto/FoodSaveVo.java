package mb.te.service.dto;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;
import mb.te.domain.Food;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.Objects;

/**
 * Created By shenxi On 2020/1/5 16:43
 * add/edit 存储视图对象
 */
@Data
public class FoodSaveVo {
    private Long id;

    /**
     * 菜品名称
     */
    private String name;

    /**
     * 菜品类型
     */
    private String type;

    /**
     * 价格
     */
    private Float price;

    /**
     * 推荐等级
     */
    private Float recommendationLevel;


    /**
     * 标签
     */
    private String tagsOrCategorys;

    /**
     * 详情图片
     */
    private String pictureIds;

    /**
     * 描述
     */
    private String description;

    /**
     * 额外信息
     */
    private String information;

    /**
     * 排序
     */
    private Long sort;


    public void copy(FoodSaveVo source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }

    public Food toEntry() {
        Food food = new Food();
        BeanUtils.copyProperties(this, food);
        if (Objects.nonNull(this.recommendationLevel)) food.setRecommendationLevel(this.recommendationLevel.toString());
        if (Objects.isNull(this.id)) food.setCreateTime(new Date());
        return food;
    }
}
