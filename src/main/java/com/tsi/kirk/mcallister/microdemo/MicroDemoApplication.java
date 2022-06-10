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
import java.sql.Date;
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
								InventoryRepository inventRepo,
								FilmCategoryRepository filmCatRepo,
								FilmActorRepository filmActorRepo,
								AddressRepository addressRepo,
								CityRepository cityRepo,
								CountryRepository countryRepo,
								CustomerRepository customerRepo,
								PaymentRepository paymentRepo,
								RentalRepository rentalRepo,
								StaffRepository staffRepo,
								StoreRepository storeRepo) {
		this.actorRepo = actorRepo;
		this.filmRepo = filmRepo;
		this.catRepo = catRepo;
		this.langRepo = langRepo;
		this.filmTextRepo = filmTextRepo;
		this.inventRepo = inventRepo;
		this.filmCatRepo = filmCatRepo;
		this.filmActorRepo = filmActorRepo;
		this.addressRepo = addressRepo;
		this.cityRepo = cityRepo;
		this.countryRepo = countryRepo;
		this.customerRepo = customerRepo;
		this.paymentRepo = paymentRepo;
		this.rentalRepo = rentalRepo;
		this.staffRepo = staffRepo;
		this.storeRepo = storeRepo;
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
				updateLanguage.setName(name);
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

	@GetMapping("/Get_Film_Category")
	public @ResponseBody
	FilmCategory getFilmCategory(@RequestParam int id) {
		Optional<FilmCategory> foundFilmCategory = filmCatRepo.findById(id);
		return foundFilmCategory.orElse(null);
	}
	// ***********************************************************************

	//Film Actor *************************************************************
	@GetMapping("/All_Film_Actors")
	public @ResponseBody
	Iterable<FilmActor> getAllFilmActors() {
		return filmActorRepo.findAll();
	}

	@GetMapping("/Get_Film_Actor")
	public @ResponseBody
	FilmActor getFilmActor(@RequestParam int id) {
		Optional<FilmActor> foundFilmActor = filmActorRepo.findById(id);
		return foundFilmActor.orElse(null);
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

	@GetMapping("/Get_Address")
	public @ResponseBody
	Address getAddress(@RequestParam int id) {
		Optional<Address> foundAddress = addressRepo.findById(id);
		return foundAddress.orElse(null);
	}

	@PostMapping("/Add_Address")
	public @ResponseBody
	void addAddress(@RequestParam String address,
					@RequestParam String district,
					@RequestParam Integer cityId,
					@RequestParam String phone) {
		Address newAddress = new Address(address, district, cityId, phone);
		addressRepo.save(newAddress);
	}

	@DeleteMapping("/Delete_Address")
	public @ResponseBody
	void deleteAddress(@RequestParam int id) {
		if (addressRepo.findById(id).isPresent()) {
			addressRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Address")
	public @ResponseBody
	void updateAddress(@RequestParam int id,
					   String address,
					   String address2,
					   String district,
					   Integer cityId,
					   String postalCode,
					   String phone) {
		Address updateAddress = getAddress(id);

		if (updateAddress != null) {
			if (address != null && !address.isBlank()) {
				updateAddress.setAddress(address);
			}

			if (address2 != null && !address2.isBlank()) {
				updateAddress.setAddress2(address2);
			}

			if (district != null && !district.isBlank()) {
				updateAddress.setDistrict(district);
			}

			if (cityId != null) {
				updateAddress.setCityId(cityId);
			}

			if (postalCode != null && !postalCode.isBlank()) {
				updateAddress.setPostCode(postalCode);
			}

			if (phone != null && !phone.isBlank()) {
				updateAddress.setPhone(phone);
			}
		}
	}
	// ***********************************************************************

	//City *******************************************************************
	@GetMapping("/All_Cities")
	public @ResponseBody
	Iterable<City> getAllCities() {
		return cityRepo.findAll();
	}

	@GetMapping("/Get_City")
	public @ResponseBody
	City getCity(@RequestParam int id) {
		Optional<City> foundCity = cityRepo.findById(id);
		return foundCity.orElse(null);
	}

	@PostMapping("/Add_City")
	public @ResponseBody
	void addCity() {
		//TODO build this mapping
	}

	@DeleteMapping("/Delete_City")
	public @ResponseBody
	void deleteCity(@RequestParam int id) {
		if (cityRepo.findById(id).isPresent()) {
			cityRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_City")
	public @ResponseBody
	void updateCity() {
		//TODO build this mapping
	}
	// ***********************************************************************

	//Country ****************************************************************
	@GetMapping("/All_Countries")
	public @ResponseBody
	Iterable<Country> getAllCountries() {
		return countryRepo.findAll();
	}

	@GetMapping("/Get_Country")
	public @ResponseBody
	Country getCountry(@RequestParam int id) {
		Optional<Country> foundCountry = countryRepo.findById(id);
		return foundCountry.orElse(null);
	}

	@PostMapping("/Add_Country")
	public @ResponseBody
	void addCountry() {
		//TODO build this mapping
	}

	@DeleteMapping("/Delete_Country")
	public @ResponseBody
	void deleteCountry(@RequestParam int id) {
		if (countryRepo.findById(id).isPresent()) {
			countryRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Country")
	public @ResponseBody
	void updateCountry() {
		//TODO build this mapping
	}
	// ***********************************************************************

	//Customer ***************************************************************
	@GetMapping("/All_Customers")
	public @ResponseBody
	Iterable<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@GetMapping("/Get_Customer")
	public @ResponseBody
	Customer getCustomer(@RequestParam int id) {
		Optional<Customer> foundCustomer = customerRepo.findById(id);
		return foundCustomer.orElse(null);
	}

	@PostMapping("/Add_Customer")
	public @ResponseBody
	void addCustomer() {
		//TODO build this mapping
	}

	@DeleteMapping("/Delete_Customer")
	public @ResponseBody
	void deleteCustomer(@RequestParam int id) {
		if (customerRepo.findById(id).isPresent()) {
			customerRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Customer")
	public @ResponseBody
	void updateCustomer() {
		//TODO build this mapping
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

	@GetMapping("/Get_Payment")
	public @ResponseBody
	Payment getPayment(@RequestParam int id) {
		Optional<Payment> foundPayment = paymentRepo.findById(id);
		return foundPayment.orElse(null);
	}

	@PostMapping("/Add_Payment")
	public @ResponseBody
	void addPayment() {
		//TODO build this mapping
	}

	@DeleteMapping("/Delete_Payment")
	public @ResponseBody
	void deletePayment(@RequestParam int id) {
		if (paymentRepo.findById(id).isPresent()) {
			paymentRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Payment")
	public @ResponseBody
	void updatePayment() {
		//TODO build this mapping
	}
	// ***********************************************************************

	//Rental *****************************************************************
	@GetMapping("/All_Rentals")
	public @ResponseBody
	Iterable<Rental> getAllRentals() {
		return rentalRepo.findAll();
	}

	@GetMapping("/Get_Rental")
	public @ResponseBody
	Rental getRental(@RequestParam int id) {
		Optional<Rental> foundRental = rentalRepo.findById(id);
		return foundRental.orElse(null);
	}

	@PostMapping("/Add_Rental")
	public @ResponseBody
	void addRental() {
		//TODO build this mapping
	}

	@DeleteMapping("/Delete_Rental")
	public @ResponseBody
	void deleteRental(@RequestParam int id) {
		if (rentalRepo.findById(id).isPresent()) {
			rentalRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Rental")
	public @ResponseBody
	void updateRental() {
		//TODO build this mapping
	}
	// ***********************************************************************

	//Staff ******************************************************************
	@GetMapping("/All_Staff")
	public @ResponseBody
	Iterable<Staff> getAllStaff() {
		return staffRepo.findAll();
	}

	@GetMapping("/Get_Staff")
	public @ResponseBody
	Staff getStaff(@RequestParam int id) {
		Optional<Staff> foundStaff = staffRepo.findById(id);
		return foundStaff.orElse(null);
	}

	@PostMapping("/Add_Staff")
	public @ResponseBody
	void addStaff() {
		//TODO build this mapping
	}

	@DeleteMapping("/Delete_Staff")
	public @ResponseBody
	void deleteStaff(@RequestParam int id) {
		if (staffRepo.findById(id).isPresent()) {
			staffRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Staff")
	public @ResponseBody
	void updateStaff() {
		//TODO build this mapping
	}
	// ***********************************************************************

	//Store ******************************************************************
	@GetMapping("/All_Stores")
	public @ResponseBody
	Iterable<Store> getAllStores() {
		return storeRepo.findAll();
	}

	@GetMapping("/Get_Store")
	public @ResponseBody
	Store getStore(@RequestParam int id) {
		Optional<Store> foundStore = storeRepo.findById(id);
		return foundStore.orElse(null);
	}

	@PostMapping("/Add_Store")
	public @ResponseBody
	void addStore() {
		//TODO build this mapping
	}

	@DeleteMapping("/Delete_Store")
	public @ResponseBody
	void deleteStore(@RequestParam int id) {
		if (storeRepo.findById(id).isPresent()) {
			storeRepo.deleteById(id);
		}
	}

	@PutMapping("/Update_Store")
	public @ResponseBody
	void updateStore() {
		//TODO build this mapping
	}
	// ***********************************************************************
	// -----------------------------------------------------------------------
}
