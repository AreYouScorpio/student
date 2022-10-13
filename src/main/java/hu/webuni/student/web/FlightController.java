package hu.webuni.student.web;


import com.querydsl.core.types.Predicate;
import hu.webuni.student.dto.FlightDto;
import hu.webuni.student.mapper.FlightMapper;
import hu.webuni.student.repository.FlightRepository;
import hu.webuni.student.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    FlightService flightService;
    @Autowired
    FlightMapper flightMapper;
    @Autowired
    FlightRepository flightRepository;

    @PostMapping
    public FlightDto createFlight(@RequestBody @Valid FlightDto flightDto) {
        Flight flight = flightService.save(flightMapper.dtoToFlight(flightDto));
        return flightMapper.flightToDto(flight);
    }

    @PostMapping("/search")
    public List<FlightDto> searchFlights(@RequestBody FlightDto example){



        return flightMapper.flightsToDtos(flightService.findFlightsByExample(flightMapper.dtoToFlight(example)));
    }

    @GetMapping("/search")
    public List<FlightDto> searchFlights2(@QuerydslPredicate(root = Flight.class) Predicate predicate){


        return flightMapper.flightsToDtos(flightRepository.findAll(predicate));
    }

}
