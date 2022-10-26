package hu.webuni.student.mapper;

import hu.webuni.student.dto.CourseDto;
import hu.webuni.student.model.Course;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CourseMapper {

    List<CourseDto> coursesToDtos(List<Course> courses);

    CourseDto courseToDto(Course course);

    Course dtoToCourse(CourseDto courseDto);
}

        /*

        https://mapstruct.org/ ----> example:

        CarMapper INSTANCE = Mappers.getMapper( CarMapper.class ); 3

        @Mapping(source = "numberOfSeats", target = "seatCount")
        CarDto carToCarDto(Car car); 2

         */

