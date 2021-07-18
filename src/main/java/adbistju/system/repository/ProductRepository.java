package adbistju.system.repository;

import adbistju.system.obj.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductsByName(String productName);

    Optional<Product> findProductsByCategory(String category);

    Optional<Product> findProductsByPrice(Long price);

    Optional<Product> findProductsById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    void flush();
}