package mb.te.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lmj.outfood.annotation.AnonymousAccess;
import lmj.outfood.aop.log.Log;
import mb.te.service.FoodService;
import mb.te.service.dto.FoodQueryCriteria;
import mb.te.service.dto.FoodSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created By shenxi On 2020/1/2 10:21
 */
@Api(tags = "[LMJ]菜品管理")
@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping
    @Log("查询菜品")
    @ApiOperation("查询菜品")
    @AnonymousAccess
    public ResponseEntity<Object> getFood(FoodQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(foodService.list(criteria, pageable), HttpStatus.OK);
    }

    @PostMapping
    @Log("新增菜品")
    @ApiOperation("新增菜品")
    @PreAuthorize("@el.check('food:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody FoodSaveVo resources) {
        return new ResponseEntity<>(foodService.save(resources.toEntry()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Log("查询菜品详情")
    @ApiOperation("查询菜品详情")
    @PreAuthorize("@el.check('food:get')")
    public ResponseEntity<Object> get(@PathVariable Long id) {
        return new ResponseEntity<>(foodService.get(id), HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改菜品")
    @ApiOperation("修改菜品")
    @PreAuthorize("@el.check('food:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody FoodSaveVo resources) {
        return new ResponseEntity<>(foodService.updateById(resources.toEntry()), HttpStatus.CREATED);
    }

    @DeleteMapping
    @Log("删除菜品")
    @ApiOperation("删除菜品")
    @PreAuthorize("@el.check('food:del')")
    public ResponseEntity<Object> deleteAll(@RequestBody List<Long> ids) {
        foodService.removeByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
