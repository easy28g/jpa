package kg.megacom.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class JpaApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer", LocalDate.of(1990, 12, 2), 532.32));
			repository.save(new Customer("Chloe", "O'Brian", LocalDate.of(2002, 7, 15), 3231.2));
			repository.save(new Customer("Kim", "Bauer", LocalDate.of(2004, 12, 23), 1555.23));
			repository.save(new Customer("David", "Palmer", LocalDate.of(2009, 4, 9), 9899.74));
			repository.save(new Customer("Michelle", "Dessler", LocalDate.of(1999, 9, 21), 532.32));
			repository.save(new Customer("zhyldyzbek", "osmonkulov", LocalDate.of(2002, 7, 15), 251.5));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("-------------------------------");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("");
			log.info(customer.toString());
			log.info("--------------------------------");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("");
			repository.findByLastName("Bauer")
					.forEach(bauer ->  log.info(bauer.toString()) );
			log.info("--------------------------------------------");

			log.info("Customer found by with findByLastNameAndFirstName ('Palmer', 'David')");
			log.info("");
			repository.findByLastNameAndFirstName("Palmer", "David")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByLastNameOrFirstName ('Palmer', 'Michelle')");
			log.info("");
			repository.findByLastNameOrFirstName("Palmer", "Michelle")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByFirstNameEquals( 'Chloe' )");
			log.info("");
			repository.findByFirstNameEquals("Chloe")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByBalanceMoneyBetween(500,  3500)");
			log.info("");
			repository.findByBalanceMoneyBetween(500.0, 3500.0)
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByBalanceMoneyLessThanOrBirthDayBetween(1000.0,  1998 - 2003)");
			log.info("");
			repository.findByBalanceMoneyLessThanOrBirthDayBetween(1000.0,LocalDate.of(1998, 1, 1), LocalDate.of(2003, 1, 1))
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByBalanceMoneyGreaterThan(5000.0)");
			log.info("");
			repository.findByBalanceMoneyGreaterThan(5000.0)
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByBalanceMoneyOrderByFirstNameDesc('532.32')");
			log.info("");
			repository.findByBalanceMoneyOrderByFirstNameDesc(532.32)
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByBalanceMoneyGreaterThanOrBirthDayBefore(5000.0, 2000 - 1 - 1)");
			log.info("");
			repository.findByBalanceMoneyGreaterThanOrBirthDayBefore(5000.0, LocalDate.of(2000, 1, 1))
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByLastNameEqualsOrBirthDayAfter(Palmer, 2003 - 1 - 1)");
			log.info("");
			repository.findByLastNameEqualsOrBirthDayAfter("Palmer", LocalDate.of(2003, 1, 1))
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByFirstNameLikeAndFirstNameNotLike(the first name ends with an 'e' but not 'oe')");
			log.info("");
			repository.findByFirstNameLikeAndFirstNameNotLike("%e", "%oe")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByLastNameStartingWith(the last name start with an 'B' and first name ends 'd')");
			log.info("");
			repository.findByLastNameStartingWithOrFirstNameEndingWith("B", "d")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByFirstNameIgnoreCase('ZHYLDYZBEK')");
			log.info("");
			repository.findByFirstNameIgnoreCase("ZHYLDYZBEK")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByBalanceMoneyIn('532.32' '251.5' '1555.23')");
			log.info("");
			repository.findByBalanceMoneyIn(Arrays.asList(532.32, 251.5, 1555.23))
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByBalanceMoneyNotIn('532.32' '251.5' '1555.23')");
			log.info("");
			repository.findByBalanceMoneyNotIn(Arrays.asList(532.32, 251.5, 1555.23))
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByLastNameNot('Dessler')");
			log.info("");
			repository.findByLastNameNot("Dessler")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");


		};
	}
}