package com.tsi.peter.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Optional;


/*
	I want to bring up a list of films then from those films bring up a list of actors in the film

	Flow is:

	Start at film, get the name of the film and the film ID

	Go to Film Actor, search for all films matching that Film ID and take the actor IDs

	Go to actors, search the actors for actors matching that ID and return first name last name.

	Pathways
	1 - A react container that takes in the data and sends off 3 api requests for each film
		in sequence to find each thing (Might take a while and not be worth it)
	2 - A built in program that responds to a single api request with all information.
		Doable but complicated, not sure on returning format. (that said, should work like get all films)
	3 - Simplify; First request just all films (easy return) strip and only take the name. Then if clicked show the actors.

*/


@SpringBootApplication /* Tells the compiler to run this as a springboot app as main*/
@RestController
@RequestMapping("/home") /* Maps the requests onto /home/ of the url:port address and prepares for requests */
@CrossOrigin /* No idea what this does */
public class DemoApplication {
	@Autowired /* Lets springboot communicate with other beans implicitly */
	private ActorRepository actorRepo; /* take in the repo from the ActorRepository class */

	@Autowired
	private FilmRepository filmRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private FilmActorRepository filmActorRepo;


	/*
	** This is my def for finding the actors in a film.
	** Input is a film id to sort and find.
	 */


	// Finds all actors
	@GetMapping("/actor") /* Maps the following list onto "url:port/home/allActors" */
	public Iterable<Actor> getAllActors(){
		return actorRepo.findAll();
	}

	// Finds all films
	@GetMapping("/film")
	public Iterable<Film> getAllFilms(){
		return filmRepo.findAll();
	}

	// Finds all customers
	@GetMapping("/customers")
	public Iterable<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	// Finds an actor by their ID
	@GetMapping("/actor/{actor_id}")
	public Optional<Actor> getActorById(@PathVariable("actor_id") Integer id){
		return actorRepo.findById(id);
	}


	//This one does work and provably so, turns any actor to an actor of a chosen name. Doesn't touch film data at all.
	@PutMapping("/actor/{actor_id}")
	public ResponseEntity<Actor> changeActor(@RequestBody Actor actor, @PathVariable("actor_id") Integer id){
		Optional<Actor> optActor = actorRepo.findById(id);
		if (optActor.isPresent())
		{
			int actorId = optActor.get().getActor_id();
			actor.setActor_id(actorId);
			actorRepo.save(actor);
			return ResponseEntity.status(HttpStatus.OK).body(actor);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(actor);
		}
	}

	// Map the delete call and then setup to delete by ID, currently doesn't work due to data scheme issues
	@DeleteMapping("/actor/{actor_id}")
	public void deleteActor(@PathVariable int actor_id){
		actorRepo.deleteById(actor_id);
	}

	/*
	 * This currently doesn't function due to an error in the data schema which doesn't allow the addition of an item
	 * with an explicit value but equally will not auto increase.
	 * This method does reach the SQL, and attempts to troubleshoot futher were pushed back over intent to finish
	 * the working methods
	 */
	@PostMapping("/actor") /* Sets up function as posting */
	public ResponseEntity<Actor> createFilm(@RequestBody Actor actor) {
        actor = actorRepo.save(actor);
		return ResponseEntity.status(HttpStatus.CREATED).body(actor);
	}

	// Constructor
	public DemoApplication(ActorRepository actorRepo, FilmRepository filmRepo, CustomerRepository customerRepo){
		this.actorRepo = actorRepo;
		this.filmRepo = filmRepo;
		this.customerRepo = customerRepo;
	}

	// Run Main Method
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
