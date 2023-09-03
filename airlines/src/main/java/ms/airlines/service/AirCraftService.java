package ms.airlines.service;

import lombok.extern.slf4j.Slf4j;
import ms.airlines.dto.AirCraftDto;
import ms.airlines.dto.converter.AirCraftDtoConverter;
import ms.airlines.dto.request.CreateAirCraftRequest;
import ms.airlines.dto.request.UpdateAirCraftRequest;
import ms.airlines.exception.AirCraftNotFoundException;
import ms.airlines.helper.Generator;
import ms.airlines.helper.messages.BusinessLogMessage;
import ms.airlines.helper.messages.BusinessMessage;
import ms.airlines.model.AirCraft;
import ms.airlines.repository.AirCraftRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class AirCraftService {
    private final AirCraftRepository airCraftRepository;
    private final FlightScheduleService flightScheduleService;
    private final AirCraftDtoConverter converter;

    public AirCraftService(AirCraftRepository airCraftRepository,
                           FlightScheduleService flightScheduleService,
                           AirCraftDtoConverter converter) {
        this.airCraftRepository = airCraftRepository;
        this.flightScheduleService = flightScheduleService;
        this.converter = converter;
    }

    public void createAirCraft(CreateAirCraftRequest request) {
        AirCraft airCraft = new AirCraft();

        airCraft.setNumber(Generator.generateAirCraftNumber());
        airCraft.setCapacity(request.getCapacity());
        airCraft.setManufacturer(request.getManufacturer());
        airCraft.setManufactureDate(request.getManufactureDate());
        airCraft.setFlightSchedule(flightScheduleService
                .findFLightScheduleByFlightScheduleId(request.getFlightScheduleId()));

        airCraftRepository.save(airCraft);
        log.info(BusinessLogMessage.AirCraft.AIR_CRAFT_CREATED);
    }

    public void updateAirCraft(final String id, UpdateAirCraftRequest request) {
        AirCraft airCraft = findAirCraftByAirCraftId(id);

        airCraft.setCapacity(request.getCapacity());
        airCraft.setManufacturer(request.getManufacturer());
        airCraft.setManufactureDate(request.getManufactureDate());
        airCraft.setFlightSchedule(flightScheduleService
                .findFLightScheduleByFlightScheduleId(request.getFlightScheduleId()));

        airCraftRepository.save(airCraft);
        log.info(BusinessLogMessage.AirCraft.AIR_CRAFT_UPDATED + id);
    }

    public void updateCapacity(final String id, final Integer capacity) {
        AirCraft airCraft = findAirCraftByAirCraftId(id);

        airCraft.setCapacity(capacity);

        airCraftRepository.save(airCraft);
        log.info(BusinessLogMessage.AirCraft.AIR_CRAFT_UPDATED + id);
    }

    public void updateManufacturer(final String id, final String manufacturer) {
        AirCraft airCraft = findAirCraftByAirCraftId(id);

        airCraft.setManufacturer(manufacturer);

        airCraftRepository.save(airCraft);
        log.info(BusinessLogMessage.AirCraft.AIR_CRAFT_UPDATED + id);
    }

    public void updateManufactureDate(final String id, final LocalDate manufactureDate) {
        AirCraft airCraft = findAirCraftByAirCraftId(id);

        airCraft.setManufactureDate(manufactureDate);

        airCraftRepository.save(airCraft);
        log.info(BusinessLogMessage.AirCraft.AIR_CRAFT_UPDATED + id);
    }

    public void updateFlightSchedule(final String id, final String flightScheduleId) {
        AirCraft airCraft = findAirCraftByAirCraftId(id);

        airCraft.setFlightSchedule(flightScheduleService
                .findFLightScheduleByFlightScheduleId(flightScheduleId));

        airCraftRepository.save(airCraft);
        log.info(BusinessLogMessage.AirCraft.AIR_CRAFT_UPDATED + id);
    }

    public void deleteAirCraft(final String id) {
        airCraftRepository.delete(findAirCraftByAirCraftId(id));
        log.info(BusinessLogMessage.AirCraft.AIR_CRAFT_DELETED + id);
    }

    public AirCraftDto findAirCraftById(final String id) {
        AirCraft airCraft = findAirCraftByAirCraftId(id);

        log.info(BusinessLogMessage.AirCraft.AIR_CRAFT_FOUND + id);
        return converter.convert(airCraft);
    }

    public AirCraftDto findAirCraftByNumber(final String number) {
        AirCraft airCraft = airCraftRepository.findByNumber(number);

        log.info(BusinessLogMessage.AirCraft.AIR_CRAFT_FOUND + number);
        return converter.convert(airCraft);
    }

    public List<AirCraftDto> findAllAirCrafts() {
        List<AirCraft> airCraftList = airCraftRepository.findAll();

        if (airCraftList.isEmpty()) {
            log.error(BusinessMessage.AirCraft.AIRCRAFT_LIST_EMPTY);
            throw new AirCraftNotFoundException(BusinessMessage.AirCraft.AIRCRAFT_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.AirCraft.AIR_CRAFT_LISTED);
        return converter.convert(airCraftList);
    }

    private AirCraft findAirCraftByAirCraftId(final String id) {
        return airCraftRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.AirCraft.AIRCRAFT_NOT_FOUND + id);
                    throw new AirCraftNotFoundException(BusinessMessage.AirCraft.AIRCRAFT_NOT_FOUND);
                });
    }

}
