package com.tsi.kirk.mcallister.microdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
	private final InventoryItemRepository inventItemRepo;

	public static void main(String[] args) {
		SpringApplication.run(MicroDemoApplication.class, args);
	}

	public MicroDemoApplication(ActorRepository actorRepo,
								FilmRepository filmRepo,
								CategoryRepository catRepo,
								LanguageRepository langRepo,
								FilmTextRepository filmTextRepo,
								InventoryItemRepository inventItemRepo) {

		this.actorRepo = actorRepo;
		this.filmRepo = filmRepo;
		this.catRepo = catRepo;
		this.langRepo = langRepo;
		this.filmTextRepo = filmTextRepo;
		this.inventItemRepo = inventItemRepo;
	}

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor> getAllActors() {
		return actorRepo.findAll();
	}

	@GetMapping("/Get_Actor")
	public @ResponseBody
	Actor getActor(@RequestParam int id) {
		Optional<Actor> foundActor = actorRepo.findById(id);
		return foundActor.orElse(null);
	}

	@PostMapping("/Add_Actor")
	public @ResponseBody
	void addActor(@RequestParam String firstName, String lastName) {
		Actor a = new Actor(firstName, lastName);
		actorRepo.save(a);
	}

	@DeleteMapping("/Delete_Actor")
	public @ResponseBody
	void deleteActor(@RequestParam int id) {
		if (actorRepo.existsById(id)) {
			actorRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Actor")
	public @ResponseBody
	void updateActor(@RequestParam int id, String firstName, String lastName) {
		if (actorRepo.existsById(id)) {
			Actor a = getActor(id);
			if (!firstName.isBlank()) {
				a.setFirstName(firstName);
			}
			if (!lastName.isBlank()) {
				a.setLastName(lastName);
			}
			actorRepo.save(a);
		}
	}

	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film> getAllFilms() {
		return filmRepo.findAll();
	}

	@GetMapping("/All_Categories")
	public @ResponseBody
	Iterable<Category> getAllCategories() {
		return catRepo.findAll();
	}

	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language> getAllLanguages() {
		return langRepo.findAll();
	}

	@GetMapping("/All_Film_Texts")
	public @ResponseBody
	Iterable<FilmText> getAllFilmTexts() {
		return filmTextRepo.findAll();
	}

	@GetMapping("/All_Inventory_Items")
	public @ResponseBody
	Iterable<InventoryItem> getAllInventoryItems() {
		return inventItemRepo.findAll();
	}
}
