package lmj.outfood.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author shenxi
* @date 2019-12-24
*/
@Entity
@Data
@Table(name="tag_or_category")
public class TagOrCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** 名称 */
    @Column(name = "name",nullable = false)
    @NotBlank
    private String name;

    /** 名称 */
    @Column(name = "type",nullable = false)
    @NotBlank
    private String type;

    /** 排序 */
    @Column(name = "sort")
    private Long sort;

    /** 创建时间 */
    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    public void copy(TagOrCategory source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}