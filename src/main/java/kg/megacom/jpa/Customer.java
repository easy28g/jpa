package kg.megacom.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private Double balanceMoney;

    public Customer() { }

    public Customer(String firstName, String lastName, LocalDate birthDay, Double balanceMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.balanceMoney = balanceMoney;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', birthDay='%s', balanceMoney'%s']",
                id, firstName, lastName, birthDay, balanceMoney);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public Double getBalanceMoney() {
        return balanceMoney;
    }
}