package ru.geekbrains.basket;

import ru.geekbrains.product.Product;

import java.util.LinkedList;
import java.util.List;


public class Cart {

    private final ProductRepository productRepository;
    private List<Product> cartList = new LinkedList<>();

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int id) {
        Product product = productRepository.getProductById(id);
       cartList.add(product);
        System.out.println(product + " successful added");
    }
    public void deleteProduct(int id){
        for (Product product1 : cartList) {
            if (id == product1.getId()) {
                cartList.remove(product1);
                System.out.println(product1 + " successful deleted");
            }
        }
        System.out.println("Product can not deleted");
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartList=" + cartList +
                '}';
    }
}

