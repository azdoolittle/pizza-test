package com.example.demo;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.repository.ToppingRepository;
import com.example.demo.tables.Pizza;
import com.example.demo.tables.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    ToppingRepository toppingRepository;

    @Autowired
    PizzaRepository pizzaRepository;

    @Override
    public void run (String... strings) throws Exception {
        Topping topping;
        topping = new Topping("Pepperoni");
        toppingRepository.save(topping);
        topping = new Topping("Sausage");
        toppingRepository.save(topping);
        topping = new Topping("Spicy Italian Sausage");
        toppingRepository.save(topping);
        topping = new Topping("Chicken");
        toppingRepository.save(topping);
        topping = new Topping("Bacon");
        toppingRepository.save(topping);
        topping = new Topping("Canadian Bacon");
        toppingRepository.save(topping);
        topping = new Topping("Beef");
        toppingRepository.save(topping);
        topping = new Topping("Olives");
        toppingRepository.save(topping);
        topping = new Topping("Green Peppers");
        toppingRepository.save(topping);
        topping = new Topping("Pineapple");
        toppingRepository.save(topping);
        topping = new Topping("Onions");
        toppingRepository.save(topping);
        topping = new Topping("Tomato");
        toppingRepository.save(topping);
        topping = new Topping("Mushrooms");
        toppingRepository.save(topping);

        Set<Topping> toppings = new HashSet<>();
        toppings.add(toppingRepository.findToppingByName("Pepperoni"));
        toppings.add(toppingRepository.findToppingByName("Sausage"));
        toppings.add(toppingRepository.findToppingByName("Chicken"));
        toppings.add(toppingRepository.findToppingByName("Bacon"));
        Pizza pizza;
        pizza = new Pizza();
        pizza.setName("Meat Lovers");
        pizza.setToppings(toppings);
        pizza.setPrice(pizza.getPrice());
        pizzaRepository.save(pizza);

        Set<Topping> toppings2 = new HashSet<>();
        toppings.add(toppingRepository.findToppingByName("Olives"));
        toppings.add(toppingRepository.findToppingByName("Green Peppers"));
        toppings.add(toppingRepository.findToppingByName("Pineapples"));
        toppings.add(toppingRepository.findToppingByName("Onions"));
        pizza = new Pizza();
        pizza.setName("Veggie");
        pizza.setToppings(toppings2);
        pizza.setPrice(pizza.getPrice());
        pizzaRepository.save(pizza);

        /* === SPECIALTY PIZZAS === */

        // The Works
        pizza = new Pizza();
        pizza.setName("The Works");
        pizza.setSpecialty(true);
        pizza.setSauce("Classic Tomato");

        Set<Topping> toppings3 = new HashSet<>();
        toppings.add(toppingRepository.findToppingByName("Spicy Italian Sausage"));
        toppings.add(toppingRepository.findToppingByName("Pepperoni"));
        toppings.add(toppingRepository.findToppingByName("Canadian Bacon"));
        toppings.add(toppingRepository.findToppingByName("Green Peppers"));
        toppings.add(toppingRepository.findToppingByName("Olives"));
        toppings.add(toppingRepository.findToppingByName("Onions"));

        pizza.setToppings(toppings3);
        pizza.setPrice(pizza.getPrice());
        pizzaRepository.save(pizza);

    }
}
