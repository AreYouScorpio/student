package hu.webuni.student.mapper;

import hu.webuni.student.dto.FlightDto;
import hu.webuni.student.model.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-13T15:04:30+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class FlightMapperImpl implements FlightMapper {

    @Override
    public Flight dtoToFlight(FlightDto flightDto) {
        if ( flightDto == null ) {
            return null;
        }

        Flight flight = new Flight();

        return flight;
    }

    @Override
    public FlightDto flightToDto(Flight flight) {
        if ( flight == null ) {
            return null;
        }

        FlightDto flightDto = new FlightDto();

        return flightDto;
    }

    @Override
    public List<FlightDto> flightsToDtos(Iterable<Flight> findAll) {
        if ( findAll == null ) {
            return null;
        }

        List<FlightDto> list = new ArrayList<FlightDto>();
        for ( Flight flight : findAll ) {
            list.add( flightToDto( flight ) );
        }

        return list;
    }
}
