package mb.te.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lmj.outfood.annotation.AnonymousAccess;
import lmj.outfood.aop.log.Log;
import mb.te.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By shenxi On 2020/2/3 13:33
 */
@Api(tags = "[APP]菜品管理")
@RestController
@RequestMapping("/api/app_food")
public class AppFoodController {

    private final FoodService foodService;

    @Autowired
    public AppFoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    @Log("[APP]查询菜品")
    @ApiOperation("[APP]查询菜品")
    @AnonymousAccess
    public ResponseEntity<Object> getHomeFood() {
        return new ResponseEntity<>(foodService.listAllFood(), HttpStatus.OK);
    }

    @GetMapping("/history")
    @Log("[APP]查询已点过菜品")
    @ApiOperation("[APP]查询已点过菜品")
    @PreAuthorize("@el.check('app_food:history')")
    public ResponseEntity<Object> getHistoryFoodList(@RequestParam(value = "pageSize", required = false) Long pageSize,
                                                     @RequestParam(value = "pageNo", required = false) Long PageNo) {
        return new ResponseEntity<>(foodService.listHistoryFood(new Page(PageNo, pageSize)), HttpStatus.OK);
    }
}
