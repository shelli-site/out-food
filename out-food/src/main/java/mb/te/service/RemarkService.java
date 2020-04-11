package mb.te.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import mb.te.domain.Remark;
import mb.te.service.dto.RemarkCreatVo;
import mb.te.service.dto.RemarkQueryCriteria;
import mb.te.service.dto.RemarkVo;

import java.util.Map;

/**
 * Created By shenxi On 2020/2/26 21:10
 */
public interface RemarkService extends IService<Remark> {
    Map<String, Object> getUserRemark(RemarkQueryCriteria criteria, Page page);

    RemarkVo getRemarkById(Long id);

    Long save(RemarkCreatVo remarkCreatVo);

    Map<String, Object> getAllRemark(RemarkQueryCriteria criteria, Page page);
}
