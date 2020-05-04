package mb.te.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import mb.te.domain.Food;
import mb.te.service.dto.FoodDto;
import mb.te.service.dto.FoodQueryCriteria;
import mb.te.service.dto.HomeFoodListVo;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created By shenxi On 2020/1/2 10:14
 */
public interface FoodService extends IService<Food> {
    Map<String, Object> list(FoodQueryCriteria criteria, Pageable pageable);

    FoodDto get(Long id);

    List<HomeFoodListVo> listAllFood();

    Map<String, Object> listHistoryFood(Page page);
}
