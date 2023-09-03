package ms.airlines.service;

import lombok.extern.slf4j.Slf4j;
import ms.airlines.dto.TransactionDto;
import ms.airlines.dto.converter.TransactionDtoConverter;
import ms.airlines.dto.request.CreateTransactionRequest;
import ms.airlines.exception.TransactionalNotFoundException;
import ms.airlines.helper.messages.BusinessLogMessage;
import ms.airlines.model.Transaction;
import ms.airlines.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final PassengerService passengerService;
    private final FlightScheduleService flightScheduleService;
    private final TransactionDtoConverter converter;

    public TransactionService(TransactionRepository transactionRepository,
                              PassengerService passengerService,
                              FlightScheduleService flightScheduleService,
                              TransactionDtoConverter converter) {
        this.transactionRepository = transactionRepository;
        this.passengerService = passengerService;
        this.flightScheduleService = flightScheduleService;
        this.converter = converter;
    }

    public void createTransaction(CreateTransactionRequest request) {
        Transaction transaction = new Transaction();

        transaction.setBookingDate(request.getBookingDate());
        transaction.setDepartureDate(request.getDepartureDate());
        transaction.setPassenger(passengerService.findPassengerByPassengerId(request.getPassengerId()));
        transaction.setFlightSchedule(flightScheduleService
                .findFLightScheduleByFlightScheduleId(request.getFlightScheduleId()));
        transaction.setType(request.getType());

        transactionRepository.save(transaction);
        log.info(BusinessLogMessage.Transaction.TRANSACTION_CREATED);
    }

    public void updateTransaction(final String id, CreateTransactionRequest request) {
        Transaction transaction = findTransactionByTransactionId(id);

        transaction.setBookingDate(request.getBookingDate());
        transaction.setDepartureDate(request.getDepartureDate());
        transaction.setPassenger(passengerService.findPassengerByPassengerId(request.getPassengerId()));
        transaction.setFlightSchedule(flightScheduleService
                .findFLightScheduleByFlightScheduleId(request.getFlightScheduleId()));
        transaction.setType(request.getType());

        transactionRepository.save(transaction);
        log.info(BusinessLogMessage.Transaction.TRANSACTION_UPDATED + id);
    }

    public void deleteTransaction(final String id) {
        transactionRepository.delete(findTransactionByTransactionId(id));
        log.info(BusinessLogMessage.Transaction.TRANSACTION_DELETED + id);
    }

    public TransactionDto findTransactionById(final String id) {
        Transaction transaction = findTransactionByTransactionId(id);

        log.info(BusinessLogMessage.Transaction.TRANSACTION_FOUND + id);
        return converter.convert(transaction);
    }

    public List<TransactionDto> findAllTransactions() {
        List<Transaction> transactionList = transactionRepository.findAll();

        if (transactionList.isEmpty()) {
            log.info(BusinessLogMessage.Transaction.TRANSACTION_LIST_EMPTY);
            throw new TransactionalNotFoundException(BusinessLogMessage.Transaction.TRANSACTION_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Transaction.TRANSACTION_LISTED);
        return converter.convert(transactionList);
    }

    private Transaction findTransactionByTransactionId(final String id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.Transaction.TRANSACTION_NOT_FOUND + id);
                    throw new TransactionalNotFoundException(BusinessLogMessage.Transaction.TRANSACTION_NOT_FOUND + id);
                });
    }
}
