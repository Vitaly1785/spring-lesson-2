package ru.geekbrains.basket;

import ru.geekbrains.product.Product;

import java.util.List;


public class ProductRepository {
    private final List<Product> productList;

    public ProductRepository(List<Product> productList) {
        this.productList = productList;
    }

    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id)
                return product;
        }
        System.out.println("This product not found");
        return null;
    }

    public List<Product> showAll() {
        return productList;
    }

}
