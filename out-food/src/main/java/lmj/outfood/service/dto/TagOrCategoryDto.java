package lmj.outfood.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author shenxi
* @date 2019-12-24
*/
@Data
public class TagOrCategoryDto implements Serializable {

    private Long id;

    /** 名称 */
    private String name;

    /** 排序 */
    private Long sort;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;
}