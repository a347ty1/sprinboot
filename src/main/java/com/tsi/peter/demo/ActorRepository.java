package com.tsi.peter.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication /* Tells the app to run this as a springboot app*/
@RestController /* Sets up as a rest controller*/
@RequestMapping("/home") /* Tells the app to load this method ontop of the "/home" domain to reduce text size (meaning we can call /actor and it will implicitly prepend the /home) */
@CrossOrigin /* Allows the app to be referenced by the same IP */
public interface ActorRepository extends JpaRepository<Actor,Integer>{
// We extend the repo to allow the main app to use it with a single import

}
