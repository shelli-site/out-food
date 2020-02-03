package mb.te.service.dto;

import lmj.outfood.service.dto.TagOrCategoryDto;
import lombok.Data;

import java.util.List;

/**
 * Created By shenxi On 2020/2/3 14:16
 */
@Data
public class HomeFoodVo {
    private Long pictureId;
    private String pictureUrl;
    private Long foodId;
    private String foodName;
    private String monthlySalesVolume;
    private Float price;
    private List<String> tags;
}
