package adbistju.system.controller;

import adbistju.system.obj.Product;
import adbistju.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getProductList(Model model){
        try {
            model.addAttribute("product", productService.getAllProducts());
        } catch (NullPointerException e) {

        }
        return "repo";
    }

    @GetMapping("/{id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findProductsById(id));
        System.out.println(productService.findProductsById(id));
        return "product_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/createProduct")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @PostMapping("/update")
    public String updateProduct(Product product) {
        if (!productService.findProductsById(product.getId()).equals(product.getId())) {
            System.out.println("ДА! тут такое есть! ");
            //update
            productService.update(product);
        } else {
            System.out.println("нет!");
            productService.insert(product);
        }
        return "redirect:/";
    }
}

