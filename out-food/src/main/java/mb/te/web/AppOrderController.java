package mb.te.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lmj.outfood.annotation.AnonymousAccess;
import lmj.outfood.aop.log.Log;
import mb.te.service.OrderService;
import mb.te.service.dto.OrderQueryCriteria;
import mb.te.service.dto.OrderSubmitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created By shenxi On 2020/2/26 21:13
 */
@Api(tags = "[LMJ]APP订单")
@RestController
@RequestMapping("/api/app_order")
public class AppOrderController {
    private final OrderService orderService;

    @Autowired
    public AppOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Log("[APP]用户获取订单列表")
    @ApiOperation("[APP]获取订单列表")
    @PreAuthorize("@el.check('app_order:list')")
    @GetMapping
    public ResponseEntity<Object> listOrder(OrderQueryCriteria criteria,
                                            @RequestParam(value = "pageSize", required = false) Long pageSize,
                                            @RequestParam(value = "pageNo", required = false) Long PageNo) {
        return new ResponseEntity<>(orderService.list(criteria, new Page(PageNo, pageSize)), HttpStatus.OK);
    }

    @Log("[APP]用户提交订单")
    @ApiOperation("[APP]提交订单")
    @PreAuthorize("@el.check('app_order:submit')")
    @PostMapping
    public ResponseEntity<Object> submitOrder(@Validated @RequestBody OrderSubmitVo orderSubmitVo) {
        return new ResponseEntity<>(orderService.submitOrder(orderSubmitVo), HttpStatus.OK);
    }

    @Log("[APP]用户支付订单")
    @ApiOperation("[APP]支付订单")
    @PreAuthorize("@el.check('app_order:paid')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> paidOrder(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.paidOrder(id), HttpStatus.OK);
    }

    @Log("[APP]用户获取订单详情")
    @ApiOperation("[APP]获取订单详情")
    @PreAuthorize("@el.check('app_order:get')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }


}
