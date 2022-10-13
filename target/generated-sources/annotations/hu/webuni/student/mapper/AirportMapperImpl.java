package hu.webuni.student.mapper;

import hu.webuni.student.dto.AirportDto;
import hu.webuni.student.model.Airport;
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
public class AirportMapperImpl implements AirportMapper {

    @Override
    public List<AirportDto> airportsToDtos(List<Airport> airports) {
        if ( airports == null ) {
            return null;
        }

        List<AirportDto> list = new ArrayList<AirportDto>( airports.size() );
        for ( Airport airport : airports ) {
            list.add( airportToDto( airport ) );
        }

        return list;
    }

    @Override
    public AirportDto airportToDto(Airport airport) {
        if ( airport == null ) {
            return null;
        }

        AirportDto airportDto = new AirportDto();

        airportDto.setId( airport.getId() );
        airportDto.setName( airport.getName() );
        airportDto.setIata( airport.getIata() );

        return airportDto;
    }

    @Override
    public Airport dtoToAirport(AirportDto airportDto) {
        if ( airportDto == null ) {
            return null;
        }

        Airport airport = new Airport();

        airport.setId( airportDto.getId() );
        airport.setName( airportDto.getName() );
        airport.setIata( airportDto.getIata() );

        return airport;
    }
}
