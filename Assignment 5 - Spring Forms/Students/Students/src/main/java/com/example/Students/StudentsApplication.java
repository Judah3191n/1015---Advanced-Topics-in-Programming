package com.example.Students;



import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.Students.Model.Alien;
import com.example.Students.repo.AlienRepo;


@SpringBootApplication
public class StudentsApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StudentsApplication.class, args);

        AlienRepo repo = context.getBean(AlienRepo.class);

        // Create a new Alien and save it
        Alien a1 = new Alien();
        a1.setId(111);
        a1.setName("Naven");
        a1.setTech("Java");
        int rows = repo.save(a1);
        System.out.println(rows + " row(s) inserted.");

        // Fetch all aliens
        List<Alien> aliens = repo.findAll();
        System.out.println("Finding all aliens:");
        aliens.forEach(System.out::println);
    }
}






