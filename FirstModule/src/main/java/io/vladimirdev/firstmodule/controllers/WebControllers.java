package io.vladimirdev.firstmodule.controllers;

import dtos.ProductDto;
import io.vladimirdev.firstmodule.entities.Product;
import io.vladimirdev.firstmodule.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequiredArgsConstructor
public class WebControllers {
    private final ProductService productService;
    @GetMapping("/")
    String getGreeting(){
        return "index.html";
    }
    @GetMapping("/market")
    String getMarket(){
        return "market.html";
    }
    @GetMapping("/get")
    String getProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "list-products.html";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new ProductDto());
        return "add-product";
    }
    @PostMapping("/add")
    String addProduct(@ModelAttribute("product") ProductDto product){
        productService.save(product);

        return "redirect:/get";
    }
    @GetMapping("/edit/{id}")
    String editProductForm(@PathVariable("id") Integer id, Model model) {
        Product product = productService.getProductById(id);  // Получение продукта по ID
//        ProductDto productDto = new ProductDto(product.getTitle(), product.getDetails());
        model.addAttribute("product", product);
        return "edit-product";
    }

    @PostMapping("/edit")
    String editProduct(@RequestParam("id") int id,
                       @RequestParam("title") String title,
                       @RequestParam("details") String details) {
        Product product = new Product(id, title, details);
        productService.update(product);
        return "redirect:/get";
    }
    @PostMapping("/update")
    public String updateProduct(@RequestParam("id") int id,
                                @RequestParam("title") String title,
                                @RequestParam("details") String details) {
        Product product = new Product(id, title, details);
        productService.update(product);
        return "redirect:/get";
    }
    @PostMapping("/delete")
    String deleteProduct(@ModelAttribute("product") Product product){
        productService.delete(product);
        return "redirect:/get";
    }
}

