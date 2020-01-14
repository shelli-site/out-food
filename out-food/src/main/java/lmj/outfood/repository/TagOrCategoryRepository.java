package lmj.outfood.repository;

import lmj.outfood.domain.TagOrCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author shenxi
* @date 2019-12-24
*/
public interface TagOrCategoryRepository extends JpaRepository<TagOrCategory, Long>, JpaSpecificationExecutor<TagOrCategory> {
}