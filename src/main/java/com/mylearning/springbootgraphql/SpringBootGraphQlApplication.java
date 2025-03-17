package com.mylearning.springbootgraphql;

import com.mylearning.springbootgraphql.entity.Product;
import com.mylearning.springbootgraphql.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootGraphQlApplication {

    @Autowired
    private ProductRepository productRepository;

    //Some extra notes for revision of the previous concepts
    //Stream.of() in Java creates an immutable stream.
    //This means that once a stream is created, it cannot be modified (e.g., elements cannot be added or removed). However, operations on the stream (like map(), filter(), flatMap()) produce new streams rather than modifying the existing one.

    // the List<Product> created in your initDB() method is mutable despite using Stream.of().
    // This is because Stream.of() returns a stream, which is immutable, but when you collect it into a list using List<Product> products = ..., you are creating a mutable list.

    //Use List.of() or Stream.toList() (Java 16+) to ensure immutability.
    //Avoid Collectors.toList() if you need an immutable list

    //Streams are immutable – You can't change the original stream after creation.
    //Basically all streams are immutable

    //Streams themselves are immutable – Once created, a stream cannot be modified (e.g., you cannot add/remove elements from an existing stream).
    //Stream operations like map() create new transformed streams – They do not modify the original elements but instead return new elements based on the transformation.
    //If objects inside the stream are mutable, you can modify them – But this does not change the structure of the stream itself.
//    @PostConstruct
    public void initDB()
    {
        List<Product> products = Stream.of(
                //list is mutable inside this immutable stream
                new Product("Laptop", "Electronics", 100000.0, 100, "High-performance laptop with latest processor and SSD storage."),
                new Product("Smartphone", "Electronics", 20000.0, 200, "Feature-rich smartphone with AMOLED display and long battery life."),
                new Product("TV", "Electronics", 30000.0, 300, "55-inch 4K Ultra HD Smart TV with built-in streaming apps."),
                new Product("Camera", "Electronics", 40000.0, 400, "Professional DSLR camera with 24MP sensor and optical zoom."),
                new Product("Tablet", "Electronics", 5000.0, 500, "Lightweight tablet with 10-inch display and stylus support."),
                new Product("Monitor", "Electronics", 6000.0, 600, "27-inch Full HD IPS monitor with 75Hz refresh rate."),
                new Product("Office Chair", "Furniture", 7000.0, 700, "Ergonomic office chair with adjustable height and lumbar support."),
                new Product("Desk", "Furniture", 8000.0, 800, "Sturdy wooden desk with spacious workspace and storage drawers."),
                new Product("Bed", "Furniture", 9000.0, 900, "King-size wooden bed frame with premium memory foam mattress."),
                new Product("Sofa", "Furniture", 10000.0, 1000, "Comfortable 3-seater sofa with high-density foam cushioning."),
                new Product("Notebook", "Stationary", 110.0, 1100, "A5-sized spiral notebook with 200 ruled pages."),
                new Product("Pen", "Stationary", 12000.0, 1200, "Premium ballpoint pen with smooth ink flow and metal body."),
                new Product("Pencil", "Stationary", 13.0, 1300, "HB graphite pencil with an ergonomic grip and break-resistant lead."),
                new Product("Eraser", "Stationary", 14.0, 1400, "Dust-free eraser for clean and smudge-free erasing."),
                new Product("Calculator", "Stationary", 150.0, 1500, "Scientific calculator with 240 functions and dual power."),
                new Product("Scale", "Stationary", 160.0, 1600, "30 cm transparent plastic ruler with precise markings."),
                new Product("Water Bottle", "Accessories", 170.0, 1700, "1-liter BPA-free insulated water bottle with leak-proof cap."),
                new Product("School Bag", "Accessories", 1800.0, 1800, "Durable backpack with multiple compartments and laptop sleeve."),
                new Product("Headphones Case", "Accessories", 1900.0, 1900, "Protective hard-shell case for wireless headphones."),
                new Product("Mobile Stand", "Accessories", 2000.0, 2000, "Adjustable aluminum mobile stand with anti-slip design.")
        ).toList();

        productRepository.saveAll(products);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphQlApplication.class, args);
    }

}
