package mb.te.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shenxi
 * @date 2020-01-01
 */
@Data
public class Food extends Model<Food> implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
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
    private String recommendationLevel;

    /**
     * 月销量
     */
    private String monthlySalesVolume;

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

    private Date createTime;

    public void copy(Food source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }
}