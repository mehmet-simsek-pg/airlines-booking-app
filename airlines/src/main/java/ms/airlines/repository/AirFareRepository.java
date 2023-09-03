package ms.airlines.repository;

import ms.airlines.model.AirFare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirFareRepository extends JpaRepository<AirFare, String> {
}