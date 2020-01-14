package lmj.outfood.rest;

import lmj.outfood.domain.TagOrCategory;
import lmj.outfood.service.TagOrCategoryService;
import lmj.outfood.service.dto.TagOrCategoryQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lmj.outfood.aop.log.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author shenxi
 * @date 2019-12-24
 */
@Api(tags = "[LMJ]标签管理")
@RestController
@RequestMapping("/api/tagOrCategory")
public class TagOrCategoryController {

    private final TagOrCategoryService tagOrCategoryService;

    public TagOrCategoryController(TagOrCategoryService tagOrCategoryService) {
        this.tagOrCategoryService = tagOrCategoryService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('tagOrCategory:list')")
    public void download(HttpServletResponse response, TagOrCategoryQueryCriteria criteria) throws IOException {
        tagOrCategoryService.download(tagOrCategoryService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询标签")
    @ApiOperation("查询标签")
    @PreAuthorize("@el.check('tagOrCategory:list')")
    public ResponseEntity<Object> getTagOrCategorys(TagOrCategoryQueryCriteria criteria, Pageable pageable, @RequestParam(value = "paging", required = false) Boolean paging) {
        return new ResponseEntity<>(Objects.isNull(paging) || paging ? tagOrCategoryService.queryAll(criteria, pageable) : tagOrCategoryService.queryAll(criteria), HttpStatus.OK);
    }

    @PostMapping
    @Log("新增标签")
    @ApiOperation("新增标签")
    @PreAuthorize("@el.check('tagOrCategory:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody TagOrCategory resources) {
        return new ResponseEntity<>(tagOrCategoryService.create(resources), HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改标签")
    @ApiOperation("修改标签")
    @PreAuthorize("@el.check('tagOrCategory:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody TagOrCategory resources) {
        tagOrCategoryService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除标签")
    @ApiOperation("删除标签")
    @PreAuthorize("@el.check('tagOrCategory:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        tagOrCategoryService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}