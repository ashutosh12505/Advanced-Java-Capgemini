package com.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.group.service.ProductService;
import com.group.service.CartService;
import com.group.model.Product;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    // Show product list
    @RequestMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    // Add item to cart
    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") int productId,
                            @RequestParam("quantity") int quantity) {

        Product product = productService.getProductById(productId);
        cartService.addToCart(product, quantity);

        return "redirect:/cart";
    }

    // Show cart summary
    @RequestMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotalAmount());
        return "cart";
    }
    @PostMapping("/update")
    public String updateCart(@RequestParam("productId") int productId,
                             @RequestParam("quantity") int quantity) {

        cartService.updateQuantity(productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removeItem(@RequestParam("productId") int productId) {

        cartService.removeItem(productId);
        return "redirect:/cart";
    }
}