package com.tsi.kirk.mcallister.microdemo;

import com.tsi.kirk.mcallister.microdemo.exceptions.ObjectNotFoundException;
import com.tsi.kirk.mcallister.microdemo.inventory.*;
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

	//Attributes -------------------------------------------------------------
	@Autowired
	private ActorRepository actorRepo;
	@Autowired
	private FilmRepository filmRepo;
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private LanguageRepository langRepo;
	@Autowired
	private FilmTextRepository filmTextRepo;
	@Autowired
	private InventoryItemRepository inventItemRepo;
	// -----------------------------------------------------------------------

	//Constructors -----------------------------------------------------------
	public MicroDemoApplication() {}
	public MicroDemoApplication(ActorRepository actorRepo) {
		this.actorRepo = actorRepo;
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
	// -----------------------------------------------------------------------

	//Main Method ------------------------------------------------------------
	public static void main(String[] args) {
		SpringApplication.run(MicroDemoApplication.class, args);
	}
	// -----------------------------------------------------------------------

	//Mappings (Inventory) ---------------------------------------------------

	//Actor
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
		if (actorRepo.findById(id).isPresent()) {
			actorRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Actor")
	public @ResponseBody
	void updateActor(@RequestParam int id, String firstName, String lastName) {
		Actor a = getActor(id);
		if (!firstName.isBlank()) {
			a.setFirstName(firstName);
		}
		if (!lastName.isBlank()) {
			a.setLastName(lastName);
		}
		actorRepo.save(a);
	}
	//

	//Film
	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film> getAllFilms() {
		return filmRepo.findAll();
	}

	@GetMapping("/Get_Film")
	public @ResponseBody
	Film getFilm(@RequestParam int id) {
		Optional<Film> foundFilm = filmRepo.findById(id);
		return foundFilm.orElse(null);
	}

	@PostMapping("/Add_Film")
	public @ResponseBody
	void addFilm(@RequestParam String firstName, @RequestParam String lastName) {
		//TODO switch to film
	}

	@DeleteMapping("/Delete_Film")
	public @ResponseBody
	void deleteFilm(@RequestParam int id) {
		if (filmRepo.findById(id).isPresent()) {
			filmRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Film")
	public @ResponseBody
	void updateFilm(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
		//TODO switch to film
	}
	//

	//Category
	@GetMapping("/All_Categories")
	public @ResponseBody
	Iterable<Category> getAllCategories() {
		return catRepo.findAll();
	}
	//

	//Language
	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language> getAllLanguages() {
		return langRepo.findAll();
	}
	//

	//Film Text
	@GetMapping("/All_Film_Texts")
	public @ResponseBody
	Iterable<FilmText> getAllFilmTexts() {
		return filmTextRepo.findAll();
	}
	//

	//Inventory
	@GetMapping("/All_Inventory_Items")
	public @ResponseBody
	Iterable<InventoryItem> getAllInventoryItems() {
		return inventItemRepo.findAll();
	}
	//
	// -----------------------------------------------------------------------
}
