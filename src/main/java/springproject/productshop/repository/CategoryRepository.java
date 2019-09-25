package springproject.productshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springproject.productshop.domain.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
