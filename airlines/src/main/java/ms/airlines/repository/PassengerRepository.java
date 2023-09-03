package ms.airlines.repository;

import ms.airlines.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, String> {
    boolean existsByFirstNameIgnoreCase(String firstName);
    boolean existsByLastNameIgnoreCase(String lastName);
}