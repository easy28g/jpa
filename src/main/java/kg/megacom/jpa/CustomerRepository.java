package kg.megacom.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);

    List<Customer> findByLastNameAndFirstName(String lastName, String firstName);

    List<Customer> findByLastNameOrFirstName(String lastName, String firstName);

    List<Customer> findByFirstNameEquals(String firstName);

    List<Customer> findByBalanceMoneyBetween(Double balance, Double balance1);

    List<Customer> findByBalanceMoneyLessThanOrBirthDayBetween(Double balance, LocalDate localDate1, LocalDate localDate2);

    List<Customer> findByBalanceMoneyGreaterThan(Double balance);

    List<Customer> findByBalanceMoneyGreaterThanOrBirthDayBefore(Double balance, LocalDate localDate);

    List<Customer> findByBalanceMoneyOrderByFirstNameDesc(Double balanceMoney);

    List<Customer> findByLastNameEqualsOrBirthDayAfter(String lastName, LocalDate localDate);

    List<Customer> findByFirstNameLikeAndFirstNameNotLike(String like, String notLike);

    List<Customer> findByLastNameStartingWithOrFirstNameEndingWith(String start, String endName);

    List<Customer> findByFirstNameIgnoreCase(String firstName);

    List<Customer> findByBalanceMoneyIn(Collection<Double> ages);

    List<Customer> findByBalanceMoneyNotIn(Collection<Double> ages);

    List<Customer> findByLastNameNot(String lastName);
}