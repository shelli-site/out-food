package mb.te.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mb.te.domain.Remark;
import mb.te.service.dto.RemarkPublicVo;
import mb.te.service.dto.RemarkVo;
import org.apache.ibatis.annotations.Param;

/**
 * Created By shenxi On 2020/2/26 21:05
 */
public interface RemarkMapper extends BaseMapper<Remark> {
    IPage<RemarkVo> queryList(Page page, @Param("ew") Wrapper queryWrapper);

    IPage<RemarkPublicVo> queryAllList(Page page);

    RemarkVo queryOne(Long id);
}
