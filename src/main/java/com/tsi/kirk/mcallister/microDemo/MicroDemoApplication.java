package com.tsi.kirk.mcallister.microDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") //needed for receiving request via api
@SpringBootApplication
@RestController //Handles GET, POST, DELETE, PUT requests
@RequestMapping("/Home") //base URL
public class MicroDemoApplication {

	@Autowired
	private final ActorRepository actorRepo;
	@Autowired
	private final FilmRepository filmRepo;
	@Autowired
	private final CategoryRepository catRepo;

	public static void main(String[] args) {
		SpringApplication.run(MicroDemoApplication.class, args);
	}

	public MicroDemoApplication(ActorRepository actorRepo, FilmRepository filmRepo, CategoryRepository catRepo) {
		this.actorRepo = actorRepo;
		this.filmRepo = filmRepo;
		this.catRepo = catRepo;
	}

	@GetMapping("/All_Actors")
	public  @ResponseBody
	Iterable<Actor>getAllActors() {
		return actorRepo.findAll();
	}

//	@PostMapping("/Post_Actors")
//
//	@DeleteMapping("/Delete_Actors")
//
//	@PutMapping("/Put_Actors")

	@GetMapping("/All_Films")
	public  @ResponseBody
	Iterable<Film>getAllFilms() {
		return filmRepo.findAll();
	}

	@GetMapping("/All_Categories")
	public  @ResponseBody
	Iterable<Category> getAllCategories() {
		return catRepo.findAll();
	}
}
