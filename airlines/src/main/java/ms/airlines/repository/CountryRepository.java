package ms.airlines.repository;

import ms.airlines.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
    boolean existsByNameIgnoreCase(String name);
}