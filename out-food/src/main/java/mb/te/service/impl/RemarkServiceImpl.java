package mb.te.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lmj.outfood.modules.system.service.UserService;
import lmj.outfood.utils.SecurityUtils;
import mb.te.domain.Order;
import mb.te.domain.Remark;
import mb.te.mapper.RemarkMapper;
import mb.te.service.OrderService;
import mb.te.service.RemarkService;
import mb.te.service.dto.RemarkCreatVo;
import mb.te.service.dto.RemarkPublicVo;
import mb.te.service.dto.RemarkQueryCriteria;
import mb.te.service.dto.RemarkVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created By shenxi On 2020/2/26 21:11
 */
@Service
public class RemarkServiceImpl extends ServiceImpl<RemarkMapper, Remark> implements RemarkService {
    @Autowired
    UserService userService;
    @Autowired
    RemarkMapper remarkMapper;
    @Autowired
    OrderService orderService;

    @Override
    public Map<String, Object> getUserRemark(RemarkQueryCriteria criteria, Page page) {
        Map<String, Object> result = new HashMap<>();
        QueryWrapper<Remark> queryWrapper = new QueryWrapper<>();
        Long userId = userService.findByName(SecurityUtils.getUsername()).getId();
        queryWrapper.apply("order_id IN ( SELECT id FROM `order` WHERE user_id = {0} )", userId);
        IPage<RemarkVo> remarkIPage = remarkMapper.queryList(page.setSearchCount(false), queryWrapper);
        result.put("list", remarkIPage.getRecords());
        result.put("pageTotal", this.count(queryWrapper));
        result.put("pageNo", remarkIPage.getCurrent());
        result.put("pageSize", remarkIPage.getSize());
        return result;
    }

    @Override
    public Map<String, Object> getAllRemark(RemarkQueryCriteria criteria, Page page) {
        Map<String, Object> result = new HashMap<>();
        IPage<RemarkPublicVo> remarkIPage = remarkMapper.queryAllList(page.setSearchCount(false));
        result.put("list", remarkIPage.getRecords());
        result.put("pageTotal", this.count());
        result.put("pageNo", remarkIPage.getCurrent());
        result.put("pageSize", remarkIPage.getSize());
        return result;
    }

    @Override
    public RemarkVo getRemarkById(Long id) {
        return remarkMapper.queryOne(id);
    }

    @Override
    @Transactional
    public Long save(RemarkCreatVo remarkCreatVo) {
        Remark remark = new Remark();
        BeanUtils.copyProperties(remarkCreatVo, remark);
        remark.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        this.save(remark);
        UpdateWrapper<Order> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", remarkCreatVo.getOrderId()).set(true, "`status`", "done");
        orderService.update(wrapper);
        return Optional.ofNullable(remark.getId()).orElse(new Long(0));
    }
}
