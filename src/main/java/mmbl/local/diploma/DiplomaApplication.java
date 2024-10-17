package mmbl.local.diploma;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
public class DiplomaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiplomaApplication.class, args);
	}

}

@RestController
class RestApiController {
	private List<Coffee> coffees = new ArrayList<>();

	public RestApiController() {
		coffees.addAll(List.of(
				new Coffee("1", "Cafe Cereza")));
	}

	@GetMapping("/coffees")
	Iterable<Coffee> getCoffees() {
		return coffees;
	}

	@GetMapping("/coffees/{id}")
	Optional<Coffee> getCoffeeById(@PathVariable String id) {
		for (Coffee c : coffees) {
			if (c.getId().equals(id)) {
				return Optional.of(c);
			}
		}
		return Optional.empty();
	}

}