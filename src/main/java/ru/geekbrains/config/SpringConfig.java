package ru.geekbrains.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.geekbrains.basket.Cart;
import ru.geekbrains.basket.ProductRepository;
import ru.geekbrains.product.*;
import ru.geekbrains.runner.Runner;

import java.util.Arrays;
import java.util.List;

@Configuration

public class SpringConfig {
    @Bean
    public TShirt tShirt(){
        return new TShirt();
    }
    @Bean
    public Jeans jeans(){
        return new Jeans();
    }
    @Bean
    public Cap cap(){
        return new Cap();
    }
    @Bean
    public Dress dress(){
        return new Dress();
    }
    @Bean
    public Sweatshirt sweatshirt(){
        return new Sweatshirt();
    }
    @Bean
    public List<Product> productList() {

        return Arrays.asList(tShirt(), jeans(), cap(), dress(), sweatshirt());
    }
    @Bean
    public ProductRepository productRepository(){
        return new ProductRepository(productList());
    }

    @Bean
    @Scope("prototype")
    public Cart cart(){
        return new Cart(productRepository());
    }

    @Bean
    public Runner runner(){return  new Runner(cart(), productRepository());}

    }

