package ms.airlines.repository;


import ms.airlines.model.AirCraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirCraftRepository extends JpaRepository<AirCraft, String> {
    AirCraft findByNumber(String number);
}