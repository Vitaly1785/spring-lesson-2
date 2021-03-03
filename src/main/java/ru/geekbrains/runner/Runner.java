package ru.geekbrains.runner;

import org.springframework.boot.CommandLineRunner;
import ru.geekbrains.basket.Cart;
import ru.geekbrains.basket.ProductRepository;

import java.util.Scanner;


public class Runner implements CommandLineRunner {

    private final Cart cart;
    private final ProductRepository productRepository;

    public Runner(Cart cart, ProductRepository productRepository) {
        this.cart = cart;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter operation number:\n1 - show All Products" +
                "\n2 - show product by ID\n3 - Add product to basket\n4 - Delete product from basket\n5 - Exit");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();

        switch (key) {
            case 1:
                System.out.println(productRepository.showAll());
                break;
            case 2:
                System.out.println("Please ID enter");
                int id = scanner.nextInt();
                System.out.println(productRepository.getProductById(id));
                break;
            case 3:
                System.out.println("Please enter ID");
                id = scanner.nextInt();
                cart.addProduct(id);
                break;
            case 4:
                System.out.println("Please enter ID");
                id = scanner.nextInt();
                cart.deleteProduct(id);
                break;
            case 5:
                break;
            default:
                System.out.println("This operation not found");
                break;
        }
    }
}



