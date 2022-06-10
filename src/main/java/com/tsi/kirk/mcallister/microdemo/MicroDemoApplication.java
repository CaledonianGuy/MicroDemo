package com.tsi.kirk.mcallister.microdemo;

import com.tsi.kirk.mcallister.microdemo.business.*;
import com.tsi.kirk.mcallister.microdemo.customerdata.*;
import com.tsi.kirk.mcallister.microdemo.inventory.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@CrossOrigin(origins = "*") //needed for receiving request via api
@SpringBootApplication
@RestController //Handles GET, POST, DELETE, PUT requests
@RequestMapping("/Home") //base URL
public class MicroDemoApplication {

	//Attributes -------------------------------------------------------------
	//Inventory **************************************************************
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
	// ***********************************************************************

	//Customer Data **********************************************************
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private CountryRepository countryRepo;
	@Autowired
	private CustomerRepository customerRepo;
	// ***********************************************************************

	//Business ***************************************************************
	@Autowired
	private PaymentRepository paymentRepo;
	@Autowired
	private RentalRepository rentalRepo;
	@Autowired
	private StaffRepository staffRepo;
	@Autowired
	private StoreRepository storeRepo;
	// ***********************************************************************
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
								InventoryRepository inventRepo) {
		this.actorRepo = actorRepo;
		this.filmRepo = filmRepo;
		this.catRepo = catRepo;
		this.langRepo = langRepo;
		this.filmTextRepo = filmTextRepo;
		this.inventRepo = inventRepo;
	}
	// -----------------------------------------------------------------------

	//Main Method ------------------------------------------------------------
	public static void main(String[] args) {
		SpringApplication.run(MicroDemoApplication.class, args);
	}
	// -----------------------------------------------------------------------

	//Mappings (Inventory) ---------------------------------------------------
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
					 @NotNull String firstName,
					 String lastName) {
		Actor updateActor = getActor(id);

		if (updateActor != null) {
			if (!firstName.isBlank()) {
				updateActor.setFirstName(firstName);
			}

			if ((lastName != null) && (!lastName.isBlank())) {
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
					Integer languageId,
					Integer rentalDuration,
					BigDecimal rentalRate,
					BigDecimal replacementCost) {
		Film updateFilm = getFilm(id);

		if (updateFilm != null) {
			if (!title.isBlank()) {
				updateFilm.setTitle(title);
			}

			if (languageId != null) {
				updateFilm.setLanguageId(languageId);
			}

			if (rentalDuration != null) {
				updateFilm.setRentalDuration(rentalDuration);
			}

			if (rentalRate != null) {
				updateFilm.setRentalRate(rentalRate);
			}

			if (replacementCost != null) {
				updateFilm.setReplacementCost(replacementCost);
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
	void addCategory() {
		//TODO build this mapping
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
	void updateCategory() {
		//TODO build this mapping
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
	void addLanguage() {
		//TODO build this mapping
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
	void updateLanguage() {
		//TODO build this mapping
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
	void addFilmText() {
		//TODO build this mapping
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
	void updateFilmText() {
		//TODO build this mapping
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
	void addInventoryItem() {
		//TODO build this mapping
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
	void updateInventoryItem() {
		//TODO build this mapping
	}
	// ***********************************************************************

	//Film Category **********************************************************
	@GetMapping("/All_Film_Categories")
	public @ResponseBody
	Iterable<FilmCategory> getAllFilmCategories() {
		return filmCatRepo.findAll();
	}
	// ***********************************************************************

	//Film Actor *************************************************************
	@GetMapping("/All_Film_Actors")
	public @ResponseBody
	Iterable<FilmActor> getAllFilmActors() {
		return filmActorRepo.findAll();
	}
	// ***********************************************************************
	// -----------------------------------------------------------------------

	//Mappings (Customer Data) -----------------------------------------------
	//Address ****************************************************************
	@GetMapping("/All_Addresses")
	public @ResponseBody
	Iterable<Address> getAllAddresses() {
		return addressRepo.findAll();
	}
	// ***********************************************************************

	//City *******************************************************************
	@GetMapping("/All_Cities")
	public @ResponseBody
	Iterable<City> getAllCities() {
		return cityRepo.findAll();
	}
	// ***********************************************************************

	//Country ****************************************************************
	@GetMapping("/All_Countries")
	public @ResponseBody
	Iterable<Country> getAllCountries() {
		return countryRepo.findAll();
	}
	// ***********************************************************************

	//Customer ***************************************************************
	@GetMapping("/All_Customers")
	public @ResponseBody
	Iterable<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
	// ***********************************************************************
	// -----------------------------------------------------------------------

	//Mappings (Business) ----------------------------------------------------
	//Payment ****************************************************************
	@GetMapping("/All_Payments")
	public @ResponseBody
	Iterable<Payment> getAllPayments() {
		return paymentRepo.findAll();
	}
	// ***********************************************************************

	//Rental *****************************************************************
	@GetMapping("/All_Rentals")
	public @ResponseBody
	Iterable<Rental> getAllRentals() {
		return rentalRepo.findAll();
	}
	// ***********************************************************************

	//Staff ******************************************************************
	@GetMapping("/All_Staff")
	public @ResponseBody
	Iterable<Staff> getAllStaff() {
		return staffRepo.findAll();
	}
	// ***********************************************************************

	//Store ******************************************************************
	@GetMapping("/All_Stores")
	public @ResponseBody
	Iterable<Store> getAllStores() {
		return storeRepo.findAll();
	}
	// ***********************************************************************
	// -----------------------------------------------------------------------
}
