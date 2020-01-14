package lmj.outfood.modules.system.service.dto;

import lombok.Data;
import lmj.outfood.annotation.Query;

/**
 * @author Zheng Jie
 * 公共查询类
 */
@Data
public class DictQueryCriteria {

    @Query(blurry = "name,remark")
    private String blurry;
}
