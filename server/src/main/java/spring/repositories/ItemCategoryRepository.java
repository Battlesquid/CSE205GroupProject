package spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import spring.entity.ItemCategories;
import java.math.BigInteger;
import java.util.Optional;

public interface ItemCategoryRepository extends PagingAndSortingRepository<ItemCategories,BigInteger> {
    Optional<ItemCategories> findById( BigInteger id );

    @Query(
            value = "SELECT store.item_categories.id FROM store.item_categories WHERE store.item_categories.category_id = ?1",
            countQuery = "SELECT count(*) FROM store.item_categories WHERE store.item_categories.category_id = ?1",
            nativeQuery = true
    )
    Page<BigInteger> findItemsByCategoryId(
            String categoryID,
            Pageable pageable
    );
}
