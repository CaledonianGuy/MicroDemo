package com.tsi.kirk.mcallister.microdemo;

import com.tsi.kirk.mcallister.microdemo.inventory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class MicroDemoApplication {

	//Attributes -------------------------------------------------------------
	@Autowired
	private ActorRepository actorRepo;
	@Autowired
	private FilmRepository filmRepo;
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private FilmCategoryRepository filmCatRepo;
	@Autowired
	private FilmActorRepository filmActorRepo;
	private final Random rand = new Random();
	// -----------------------------------------------------------------------

	//Constructors -----------------------------------------------------------
	public MicroDemoApplication() {}

	public MicroDemoApplication(ActorRepository actorRepo,
								FilmRepository filmRepo,
								CategoryRepository catRepo,
								FilmCategoryRepository filmCatRepo,
								FilmActorRepository filmActorRepo) {
		this.actorRepo = actorRepo;
		this.filmRepo = filmRepo;
		this.catRepo = catRepo;
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
	List<Film> getRandomFilms(@PathVariable(value = "num") int numFilmsToFind) {
		List<Film> movies = new ArrayList<>();
		long numOfFilms = filmRepo.count();

		if (numOfFilms <= numFilmsToFind) {
			getAllFilms().forEach(movies::add);
		} else {
			while (movies.size() < numFilmsToFind) {
				int randFilmId = (int)rand.nextLong(numOfFilms);
				Film addFilm = getFilm(randFilmId);
				if (!movies.contains(addFilm)) {
					movies.add(addFilm);
				}
			}
		}

		return movies;
	}

	@GetMapping(value = "/Find_Films_By_Genre/{genre}/{num}")
	public @ResponseBody
	List<Film> getRandomFilmsByGenre(@PathVariable(value = "genre") String genreName,
									 @PathVariable(value = "num") Integer numFilmsToFind) {
		List<Film> movies = new ArrayList<>();
		Optional<Category> genre = catRepo.findByName(genreName);

		if (genre.isPresent()) {
			Iterable<FilmCategory> filmCats = getFilmCatByCategoryId(genre.get().getCategoryId());

			for (FilmCategory element : filmCats) {
				movies.add(getFilm(element.getFilmId()));
			}
		}

		while (movies.size() > numFilmsToFind) {
			movies.remove(rand.nextInt(movies.size()));
		}

		return movies;
	}

	@GetMapping(value = "/Find_Films_By_Actor/{first_name}/{last_name}/{num}")
	public @ResponseBody
	List<Film> getRandomFilmsByActor(@PathVariable(value = "first_name") String firstName,
									 @PathVariable(value = "last_name") String lastName,
									 @PathVariable(value = "num") Integer numFilmsToFind) {
		List<Film> movies = new ArrayList<>();
		Optional<Actor> actor = actorRepo.findByFirstNameAndLastName(firstName, lastName);

		if (actor.isPresent()) {
			Iterable<FilmActor> filmActors = getFilmActorByActorId(actor.get().getActorId());

			for (FilmActor element : filmActors) {
				movies.add(getFilm(element.getFilmId()));
			}
		}

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
	// ***********************************************************************

	//Film Category **********************************************************
	@GetMapping("/Get_Film_Category_By_Category_ID")
	public @ResponseBody
	Iterable<FilmCategory> getFilmCatByCategoryId(@RequestParam int id) {
		return filmCatRepo.findByCategoryId(id);
	}
	// ***********************************************************************

	//Film Actor *************************************************************
	@GetMapping("/Get_Film_Actor_By_Actor_ID")
	public @ResponseBody
	Iterable<FilmActor> getFilmActorByActorId(@RequestParam int id) {
		return filmActorRepo.findByActorId(id);
	}
	// ***********************************************************************
	// -----------------------------------------------------------------------
}
