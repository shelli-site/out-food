package mb.te.service.dto;

import lmj.outfood.annotation.Query;
import lombok.Data;

/**
 * @author shenxi
 * @date 2020-01-01
 */
@Data
public class FoodQueryCriteria {

    /**
     * 模糊
     */
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    /**
     * 精确
     */
    @Query
    private String type;
}