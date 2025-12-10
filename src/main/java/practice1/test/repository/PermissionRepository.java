package practice1.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice1.test.model.Permission;


@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}
