package hu.webuni.student.mapper;

import hu.webuni.student.dto.AirportDto;
import hu.webuni.student.model.Airport;
import org.mapstruct.Mapper;

import java.util.List;


    @Mapper(componentModel = "spring")
    public interface AirportMapper {

        List<AirportDto> airportsToDtos(List<Airport> airports);

        AirportDto airportToDto(Airport airport);

        Airport dtoToAirport(AirportDto airportDto);
    }

        /*

        https://mapstruct.org/ ----> example:

        CarMapper INSTANCE = Mappers.getMapper( CarMapper.class ); 3

        @Mapping(source = "numberOfSeats", target = "seatCount")
        CarDto carToCarDto(Car car); 2

         */

