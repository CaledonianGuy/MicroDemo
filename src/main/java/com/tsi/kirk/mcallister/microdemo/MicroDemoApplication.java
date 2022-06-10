package com.tsi.kirk.mcallister.microdemo;

import com.tsi.kirk.mcallister.microdemo.business.*;
import com.tsi.kirk.mcallister.microdemo.customerdata.*;
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
	private InventoryRepository inventRepo;
	@Autowired
	private FilmCategoryRepository filmCatRepo;
	@Autowired
	private FilmActorRepository filmActorRepo;

	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private CountryRepository countryRepo;
	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private PaymentRepository paymentRepo;
	@Autowired
	private RentalRepository rentalRepo;
	@Autowired
	private StaffRepository staffRepo;
	@Autowired
	private StoreRepository storeRepo;
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
	// ***********************************************************************

	//Category ***************************************************************
	@GetMapping("/All_Categories")
	public @ResponseBody
	Iterable<Category> getAllCategories() {
		return catRepo.findAll();
	}
	// ***********************************************************************

	//Language ***************************************************************
	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language> getAllLanguages() {
		return langRepo.findAll();
	}
	// ***********************************************************************

	//Film Text **************************************************************
	@GetMapping("/All_Film_Texts")
	public @ResponseBody
	Iterable<FilmText> getAllFilmTexts() {
		return filmTextRepo.findAll();
	}
	// ***********************************************************************

	//Inventory **************************************************************
	@GetMapping("/All_Inventory_Items")
	public @ResponseBody
	Iterable<Inventory> getAllInventoryItems() {
		return inventRepo.findAll();
	}
	// ***********************************************************************

	//Film Category 8*********************************************************
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
