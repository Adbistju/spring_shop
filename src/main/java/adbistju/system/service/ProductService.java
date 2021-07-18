package adbistju.system.service;

import adbistju.system.obj.Product;
import adbistju.system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Optional<Product> findProductsByName(String name){
        return productRepository.findProductsByName(name);
    }

    public Optional<Product> findProductsById(long i) {
        return productRepository.findProductsById(i);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public void insert(Product product){
        productRepository.save(product);
    }

    public void update(Product product) {
        //????????????????????????????????????
        Product prod = new Product();
        prod.setName(product.getName());
        prod.setCategory(product.getCategory());
        prod.setPrice(product.getPrice());
        System.out.println("обновляем");
        productRepository.flush();
        //????????????????????????????????????
    }
}
