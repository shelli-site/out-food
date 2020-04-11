package mb.te.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lmj.outfood.annotation.AnonymousAccess;
import lmj.outfood.aop.log.Log;
import mb.te.service.RemarkService;
import mb.te.service.dto.RemarkCreatVo;
import mb.te.service.dto.RemarkQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created By shenxi On 2020/2/26 21:13
 * 【获取评价列表】、【详情】、【提交评价】
 */
@Api(tags = "[LMJ]APP评价")
@RestController
@RequestMapping("/api/app_remark")
public class AppRemarkController {
    private final RemarkService remarkService;

    @Autowired
    public AppRemarkController(RemarkService remarkService) {
        this.remarkService = remarkService;
    }

    @Log("[APP]用户评价订单")
    @ApiOperation("[APP]评价订单")
    @PreAuthorize("@el.check('app_remark:add')")
    @PostMapping
    public ResponseEntity<Object> remark(@Validated(RemarkCreatVo.Insert.class) @RequestBody RemarkCreatVo remarkCreatVo) {

        return new ResponseEntity<>(remarkService.save(remarkCreatVo), HttpStatus.OK);
    }

    @Log("[APP]用户获取全部评价列表")
    @ApiOperation("[APP]获取全部评价列表")
    @AnonymousAccess
    @GetMapping("/all")
    public ResponseEntity<Object> allRemark(RemarkQueryCriteria criteria,
                                             @RequestParam(value = "pageSize", required = false) Long pageSize,
                                             @RequestParam(value = "pageNo", required = false) Long PageNo) {
        return new ResponseEntity<>(remarkService.getAllRemark(criteria, new Page(PageNo, pageSize)), HttpStatus.OK);
    }
    @Log("[APP]用户获取个人评价列表")
    @ApiOperation("[APP]获取个人评价列表")
    @PreAuthorize("@el.check('app_remark:list')")
    @GetMapping
    public ResponseEntity<Object> listRemark(RemarkQueryCriteria criteria,
                                             @RequestParam(value = "pageSize", required = false) Long pageSize,
                                             @RequestParam(value = "pageNo", required = false) Long PageNo) {
        return new ResponseEntity<>(remarkService.getUserRemark(criteria, new Page(PageNo, pageSize)), HttpStatus.OK);
    }

    @Log("[APP]用户获取评价详情")
    @ApiOperation("[APP]获取评价详情")
    @PreAuthorize("@el.check('app_remark:get')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getRemark(@PathVariable Long id) {
        return new ResponseEntity<>(remarkService.getRemarkById(id), HttpStatus.OK);
    }


}
