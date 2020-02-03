package lmj.outfood.service.dto;

import lombok.Data;
import lmj.outfood.annotation.Query;

/**
* @author shenxi
* @date 2019-12-24
*/
@Data
public class TagOrCategoryQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    /** 模糊 */
    @Query(type = Query.Type.EQUAL)
    private String type;

    public TagOrCategoryQueryCriteria() {
    }

    public TagOrCategoryQueryCriteria(String name, String type) {
        this.name = name;
        this.type = type;
    }
}