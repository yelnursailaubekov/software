package practice1.test.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice1.test.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
