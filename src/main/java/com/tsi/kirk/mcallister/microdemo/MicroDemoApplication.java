package com.tsi.kirk.mcallister.microdemo;

import com.tsi.kirk.mcallister.microdemo.inventory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.*;

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
	private InventoryRepository inventRepo;
	@Autowired
	private FilmCategoryRepository filmCatRepo;
	@Autowired
	private FilmActorRepository filmActorRepo;
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
								InventoryRepository inventRepo,
								FilmCategoryRepository filmCatRepo,
								FilmActorRepository filmActorRepo) {
		this.actorRepo = actorRepo;
		this.filmRepo = filmRepo;
		this.catRepo = catRepo;
		this.langRepo = langRepo;
		this.filmTextRepo = filmTextRepo;
		this.inventRepo = inventRepo;
		this.filmCatRepo = filmCatRepo;
		this.filmActorRepo = filmActorRepo;

	}
	// -----------------------------------------------------------------------

	//Main Method ------------------------------------------------------------
	public static void main(String[] args) {
		SpringApplication.run(MicroDemoApplication.class, args);
	}
	// -----------------------------------------------------------------------

	//Mappings ---------------------------------------------------------------
	//New --------------------------------------------------------------------
	@GetMapping("/Find_Films/{num}")
	public @ResponseBody
	ArrayList<Film> getRandomFilms(@PathVariable(value = "num") int numFilmsToFind) {
		ArrayList<Film> movies = new ArrayList<>();
		long numOfFilms = filmRepo.count();
		Random rand = new Random();

		if (numOfFilms <= numFilmsToFind) {
			getAllFilms().forEach(movies::add);
		} else {
			for (int i = 0; i < numFilmsToFind; i++) {
				int randFilmId = (int)rand.nextLong(numOfFilms);
				Film addFilm = getFilm(randFilmId);
				if (!movies.contains(addFilm)) {
					movies.add(addFilm);
				} else {
					i--;
				}
			}
		}

		return movies;
	}

	@RequestMapping(value = "/Find_Films_By_Genre/{genre}/{num}", method = RequestMethod.GET)
	public @ResponseBody
	ArrayList<Film> getRandomFilmsByGenre(@PathVariable(value = "genre") String genreName,
										  @PathVariable(value = "num") Integer numFilmsToFind) {
		ArrayList<Film> movies = new ArrayList<>();
		Optional<Category> genre = catRepo.findByName(genreName);

		if (genre.isPresent()) {
			Iterable<FilmCategory> filmCats = getFilmCatByCategoryId(genre.get().getCategoryId());

			for (FilmCategory element : filmCats) {
				movies.add(getFilm(element.getFilmId()));
			}
		}

		Random rand = new Random();

		while (movies.size() > numFilmsToFind) {
			movies.remove(rand.nextInt(movies.size()));
		}

		return movies;
	}

	@RequestMapping(value = "Find_Films_By_Actor/{f_name}/{l_name}/{num}", method = RequestMethod.GET)
	public @ResponseBody
	ArrayList<Film> getRandomFilmsByActor(@PathVariable(value = "f_name") String firstName,
										  @PathVariable(value = "l_name") String lastName,
										  @PathVariable(value = "num") Integer numFilmsToFind) {
		ArrayList<Film> movies = new ArrayList<>();
		Optional<Actor> actor = actorRepo.findByFirstNameAndLastName(firstName, lastName);

		if (actor.isPresent()) {
			Iterable<FilmActor> filmActors = getFilmActorByActorId(actor.get().getActorId());

			for (FilmActor element : filmActors) {
				movies.add(getFilm(element.getFilmId()));
			}
		}

		Random rand = new Random();

		while (movies.size() > numFilmsToFind) {
			movies.remove(rand.nextInt(movies.size()));
		}

		return movies;
	}
	// -----------------------------------------------------------------------

	//Old --------------------------------------------------------------------
	//Actor ******************************************************************
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
	void addActor(@RequestParam String firstName,
				  @RequestParam String lastName) {
		Actor newActor = new Actor(firstName, lastName);
		actorRepo.save(newActor);
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
	void updateActor(@RequestParam int id,
					 String firstName,
					 String lastName) {
		Actor updateActor = getActor(id);

		if (updateActor != null) {
			if (firstName != null && !firstName.isBlank()) {
				updateActor.setFirstName(firstName);
			}

			if (lastName != null && !lastName.isBlank()) {
				updateActor.setLastName(lastName);
			}

			actorRepo.save(updateActor);
		}
	}
	// ***********************************************************************

	//Film *******************************************************************
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
	void addFilm(@RequestParam String title,
				 @RequestParam int languageId,
				 @RequestParam(defaultValue = "3") Integer rentalDuration,
				 @RequestParam(defaultValue = "4.99") BigDecimal rentalRate,
				 @RequestParam(defaultValue = "19.99") BigDecimal replacementCost) {
		Film newFilm = new Film(title, languageId, rentalDuration, rentalRate, replacementCost);
		filmRepo.save(newFilm);
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
	void updateFilm(@RequestParam int id,
					String title,
					String description,
					Date releaseYear,
					Integer languageId,
					Integer originalLanguageId,
					Integer rentalDuration,
					BigDecimal rentalRate,
					Integer length,
					BigDecimal replacementCost,
					String rating,
					String specialFeatures) {
		Film updateFilm = getFilm(id);

		if (updateFilm != null) {
			if (title != null && !title.isBlank()) {
				updateFilm.setTitle(title);
			}

			if (description != null && !description.isBlank()) {
				updateFilm.setDescription(description);
			}

			if (releaseYear != null) {
				updateFilm.setReleaseYear(releaseYear);
			}

			if (languageId != null) {
				updateFilm.setLanguageId(languageId);
			}

			if (originalLanguageId != null) {
				updateFilm.setOriginalLanguageId(originalLanguageId);
			}

			if (rentalDuration != null) {
				updateFilm.setRentalDuration(rentalDuration);
			}

			if (rentalRate != null) {
				updateFilm.setRentalRate(rentalRate);
			}

			if (length != null) {
				updateFilm.setLength(length);
			}

			if (replacementCost != null) {
				updateFilm.setReplacementCost(replacementCost);
			}

			if (rating != null && !rating.isBlank()) {
				updateFilm.setRating(rating);
			}

			if (specialFeatures != null && !specialFeatures.isBlank()) {
				updateFilm.setSpecialFeatures(specialFeatures);
			}

			filmRepo.save(updateFilm);
		}
	}
	// ***********************************************************************

	//Category ***************************************************************
	@GetMapping("/All_Categories")
	public @ResponseBody
	Iterable<Category> getAllCategories() {
		return catRepo.findAll();
	}

	@GetMapping("/Get_Category")
	public @ResponseBody
	Category getCategory(@RequestParam int id) {
		Optional<Category> foundCategory = catRepo.findById(id);
		return foundCategory.orElse(null);
	}

	@PostMapping("/Add_Category")
	public @ResponseBody
	void addCategory(@RequestParam String name) {
		Category newCategory = new Category(name);
		catRepo.save(newCategory);
	}

	@DeleteMapping("/Delete_Category")
	public @ResponseBody
	void deleteCategory(@RequestParam int id) {
		if (catRepo.findById(id).isPresent()) {
			catRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Category")
	public @ResponseBody
	void updateCategory(@RequestParam int id,
						String name) {
		Category updateCategory = getCategory(id);

		if (updateCategory != null) {
			if (name != null && !name.isBlank()) {
				updateCategory.setName(name);
			}

			catRepo.save(updateCategory);
		}
	}
	// ***********************************************************************

	//Language ***************************************************************
	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language> getAllLanguages() {
		return langRepo.findAll();
	}

	@GetMapping("/Get_Language")
	public @ResponseBody
	Language getLanguage(@RequestParam int id) {
		Optional<Language> foundLanguage = langRepo.findById(id);
		return foundLanguage.orElse(null);
	}

	@PostMapping("/Add_Language")
	public @ResponseBody
	void addLanguage(@RequestParam String name) {
		Language newLanguage = new Language(name);
		langRepo.save(newLanguage);
	}

	@DeleteMapping("/Delete_Language")
	public @ResponseBody
	void deleteLanguage(@RequestParam int id) {
		if (langRepo.findById(id).isPresent()) {
			langRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Language")
	public @ResponseBody
	void updateLanguage(@RequestParam int id,
						String name) {
		Language updateLanguage = getLanguage(id);

		if (updateLanguage != null) {
			if (name != null && !name.isBlank()) {
				updateLanguage.setLangName(name);
			}
		}
	}
	// ***********************************************************************

	//Film Text **************************************************************
	@GetMapping("/All_Film_Texts")
	public @ResponseBody
	Iterable<FilmText> getAllFilmTexts() {
		return filmTextRepo.findAll();
	}

	@GetMapping("/Get_Film_Text")
	public @ResponseBody
	FilmText getFilmText(@RequestParam int id) {
		Optional<FilmText> foundFilmText = filmTextRepo.findById(id);
		return foundFilmText.orElse(null);
	}

	@PostMapping("/Add_Film_Text")
	public @ResponseBody
	void addFilmText(@RequestParam String title) {
		FilmText newFilmText = new FilmText(title);
		filmTextRepo.save(newFilmText);
	}

	@DeleteMapping("/Delete_Film_Text")
	public @ResponseBody
	void deleteFilmText(@RequestParam int id) {
		if (filmTextRepo.findById(id).isPresent()) {
			filmTextRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Film_Text")
	public @ResponseBody
	void updateFilmText(@RequestParam int id,
						String title,
						String description) {
		FilmText updateFilmText = getFilmText(id);

		if (updateFilmText != null) {
			if (title != null && !title.isBlank()) {
				updateFilmText.setTitle(title);
			}

			if (description != null && !description.isBlank()) {
				updateFilmText.setDescription(description);
			}

			filmTextRepo.save(updateFilmText);
		}
	}
	// ***********************************************************************

	//Inventory **************************************************************
	@GetMapping("/All_Inventory_Items")
	public @ResponseBody
	Iterable<Inventory> getAllInventoryItems() {
		return inventRepo.findAll();
	}

	@GetMapping("/Get_Inventory_Item")
	public @ResponseBody
	Inventory getInventoryItem(@RequestParam int id) {
		Optional<Inventory> foundInventoryItem = inventRepo.findById(id);
		return foundInventoryItem.orElse(null);
	}

	@PostMapping("/Add_Inventory_Item")
	public @ResponseBody
	void addInventoryItem(@RequestParam Integer filmId,
						  @RequestParam Integer storeId) {
		Inventory newInventoryItem = new Inventory(filmId, storeId);
		inventRepo.save(newInventoryItem);
	}

	@DeleteMapping("/Delete_Inventory_Item")
	public @ResponseBody
	void deleteInventoryItem(@RequestParam int id) {
		if (inventRepo.findById(id).isPresent()) {
			inventRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Inventory_Item")
	public @ResponseBody
	void updateInventoryItem(@RequestParam int id,
							 Integer filmId,
							 Integer storeId) {
		Inventory updateInventoryItem = getInventoryItem(id);

		if (updateInventoryItem != null) {
			if (filmId != null) {
				updateInventoryItem.setFilmId(filmId);
			}

			if (storeId != null) {
				updateInventoryItem.setStoreId(storeId);
			}

			inventRepo.save(updateInventoryItem);
		}
	}
	// ***********************************************************************

	//Film Category **********************************************************
	@GetMapping("/All_Film_Categories")
	public @ResponseBody
	Iterable<FilmCategory> getAllFilmCategories() {
		return filmCatRepo.findAll();
	}

	@GetMapping("/Get_Film_Category_By_Film_ID")
	public @ResponseBody
	Iterable<FilmCategory> getFilmCatByFilmId(@RequestParam int id) {
		return filmCatRepo.findByFilmId(id);
	}

	@GetMapping("/Get_Film_Category_By_Category_ID")
	public @ResponseBody
	Iterable<FilmCategory> getFilmCatByCategoryId(@RequestParam int id) {
		return filmCatRepo.findByCategoryId(id);
	}
	// ***********************************************************************

	//Film Actor *************************************************************
	@GetMapping("/All_Film_Actors")
	public @ResponseBody
	Iterable<FilmActor> getAllFilmActors() {
		return filmActorRepo.findAll();
	}

	@GetMapping("/Get_Film_Actor_By_Film_ID")
	public @ResponseBody
	Iterable<FilmActor> getFilmActorByFilmId(@RequestParam int id) {
		return filmActorRepo.findByFilmId(id);
	}

	@GetMapping("/Get_Film_Actor_By_Actor_ID")
	public @ResponseBody
	Iterable<FilmActor> getFilmActorByActorId(@RequestParam int id) {
		return filmActorRepo.findByActorId(id);
	}
	// ***********************************************************************
	// -----------------------------------------------------------------------
}
