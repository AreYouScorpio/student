package hu.webuni.student.service;

import hu.webuni.student.model.Airport;
import hu.webuni.student.model.AirportUser;
import hu.webuni.student.model.Flight;
import hu.webuni.student.repository.AirportRepository;
import hu.webuni.student.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class InitDbService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    AirportRepository airportRepository;
    @Autowired
    FlightService flightService;

    public InitDbService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        //super();
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void createUsersIfNeeded() {
        //userRepository.deleteAll(); - ha vmi szemét maradt a rendszerben, töröljük ki
        if(!userRepository.existsById("admin")) {
            userRepository.save(
                    new AirportUser("admin", passwordEncoder.encode("pass"),
                            Set.of("admin", "user") ));}
        if(!userRepository.existsById("user")) {
            userRepository.save(
                    new AirportUser("user",
                            passwordEncoder.encode("pass"),
                            Set.of("user") ));}


        }

    @Transactional
    public void addInitData() {
        Airport airport1 = airportRepository.save(new Airport("airport1", "BUD"));
        Airport airport2 = airportRepository.save(new Airport("airport2", "LAX"));
        Airport airport3 = airportRepository.save(new Airport("airport3", "JFK"));
        Airport airport4 = airportRepository.save(new Airport("airport4", "LGW"));

        flightService.save(new Flight(0, "ABC123", LocalDateTime.of(2022, 6, 10, 10, 10), airport1, airport2));
        flightService.save(new Flight(0, "ABC456", LocalDateTime.of(2022, 6, 10, 12, 10), airport2, airport3));
        flightService.save(new Flight(0, "DEF234", LocalDateTime.of(2022, 6, 12, 14, 10), airport2, airport4));
        flightService.save(new Flight(0, "GHI345", LocalDateTime.of(2022, 6, 13, 16, 10), airport4, airport1));
    }

    }


