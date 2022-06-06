package com.tsi.kirk.mcallister.microdemo;

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
	@Autowired
	private final LanguageRepository langRepo;
	@Autowired
	private final FilmTextRepository filmTextRepo;
	@Autowired
	private final InventoryItemRepository inventRepo;

	public static void main(String[] args) {
		SpringApplication.run(MicroDemoApplication.class, args);
	}

	public MicroDemoApplication(ActorRepository actorRepo,
								FilmRepository filmRepo,
								CategoryRepository catRepo,
								LanguageRepository langRepo,
								FilmTextRepository filmTextRepo,
								InventoryItemRepository inventRepo) {

		this.actorRepo = actorRepo;
		this.filmRepo = filmRepo;
		this.catRepo = catRepo;
		this.langRepo = langRepo;
		this.filmTextRepo = filmTextRepo;
		this.inventRepo = inventRepo;
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

	@GetMapping("/All_Languages")
	public  @ResponseBody
	Iterable<Language> getAllLanguages() {
		return langRepo.findAll();
	}

	@GetMapping("/All_Film_Texts")
	public  @ResponseBody
	Iterable<FilmText> getAllFilmTexts() {
		return filmTextRepo.findAll();
	}

	@GetMapping("/All_Inventory_Items")
	public  @ResponseBody
	Iterable<InventoryItem> getAllInventoryItems() {
		return inventRepo.findAll();
	}
}
