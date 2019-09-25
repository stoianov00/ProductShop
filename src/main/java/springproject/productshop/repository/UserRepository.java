package springproject.productshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springproject.productshop.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
