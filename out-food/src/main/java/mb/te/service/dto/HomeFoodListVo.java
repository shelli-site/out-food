package mb.te.service.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By shenxi On 2020/2/3 13:38
 */
@Data
public class HomeFoodListVo {
    private Long categoryId;
    private String categoryName;
    private List<HomeFoodVo> foodList;

    public HomeFoodListVo(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.foodList = new ArrayList<>();
    }
}
