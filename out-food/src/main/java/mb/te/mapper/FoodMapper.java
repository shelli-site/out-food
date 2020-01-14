package mb.te.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mb.te.domain.Food;

/**
 * Created By shenxi On 2020/1/1 23:59
 */
public interface FoodMapper extends BaseMapper<Food> {

    IPage<Food> queryAll(Page page);

}
