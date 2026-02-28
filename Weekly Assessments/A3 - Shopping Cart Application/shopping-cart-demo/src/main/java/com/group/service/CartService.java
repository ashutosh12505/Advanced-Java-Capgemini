package com.group.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.group.model.CartItem;
import com.group.model.Product;

@Service
public class CartService {

    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Product product, int quantity) {

        // If product already exists, update quantity
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == product.getId()) {
                int newQuantity = item.getQuantity() + quantity;
                cartItems.remove(item);
                cartItems.add(new CartItem(product, newQuantity));
                return;
            }
        }

        cartItems.add(new CartItem(product, quantity));
    }

    public void updateQuantity(int productId, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == productId) {
                cartItems.remove(item);
                cartItems.add(new CartItem(item.getProduct(), quantity));
                return;
            }
        }
    }

    public void removeItem(int productId) {
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getProduct().getId() == productId) {
                iterator.remove();
            }
        }
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotalAmount() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotal();
        }
        return total;
    }
}