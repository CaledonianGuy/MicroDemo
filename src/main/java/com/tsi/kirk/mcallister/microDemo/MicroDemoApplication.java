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

	public static void main(String[] args) {
		SpringApplication.run(MicroDemoApplication.class, args);
	}

	public MicroDemoApplication(ActorRepository actorRepo) {
		this.actorRepo = actorRepo;
	}

	@GetMapping("/All_Actors")
	public  @ResponseBody
	Iterable<Actor>getAllActors() {
		return actorRepo.findAll();
	}

}
