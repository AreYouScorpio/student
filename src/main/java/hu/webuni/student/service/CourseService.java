package hu.webuni.student.service;

import com.google.common.collect.Lists;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import hu.webuni.student.model.Course;
import hu.webuni.student.model.QCourse;
import hu.webuni.student.repository.CourseRepository;
import hu.webuni.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    @Transactional
    public Course save(Course course) {
        //a takeoff/landing airportból csak az id-t vesszük figyelembe, már létezniük kell
//        student.setTakeoff(studentRepository.findById(flight.getTakeoff().getId()).get());
//        student.setLanding(studentRepository.findById(flight.getLanding().getId()).get());
        return courseRepository.save(course);
    }

    public List<Course> findCoursesByExample(Course example) {
        long courseId = example.getId();
        String courseName = example.getName();

        String teacherName = example.getTeacher().getName();

        long studentId = example.getStudent().getId();


        int semester = example.getStudent().getSemester();

        //Specification<Flight> spec = Specification.where(null); // üres Specification, ami semmire nem szűr

        // a FlightSpecifications feltételeit ide írjuk bele közvetlen --->

        ArrayList<Predicate> predicates = new ArrayList<Predicate>();

        QCourse course = QCourse.course;

        if (courseId > 0) {

            // spec = spec.and(FlightSpecifications.hasId(id));
            predicates.add(course.id.eq(courseId));
        }

        if (StringUtils.hasText(courseName)) // SpringFramework-ös StringUtils
            // spec = spec.and(FlightSpecifications.hasFlightNumber(flightNumber));
            predicates.add(course.name.startsWithIgnoreCase(courseName));


        if (studentId > 0) {

            // spec = spec.and(FlightSpecifications.hasId(id));
            predicates.add(course.student.id.eq(studentId));
        }

        if (semester >= 1) // SpringFramework-ös StringUtils
        //spec = spec.and(FlightSpecifications.hasTakeoffTime(takeoffTime));
        {

            predicates.add(course.student.semester.between(semester, semester+1));

        }


        //return flightRepository.findAll(spec, Sort.by("id"));
        return Lists.newArrayList(courseRepository.findAll(ExpressionUtils.allOf(predicates)));
    }

    public List<Course> findAll() {
        // return new ArrayList<>(airports.values());
        // return em.createQuery("SELECT a from Airport a", Airport.class).getResultList();

        return courseRepository.findAll();
    }

    public Optional<Course> findById(long id) {
        //return airports.get(id);
        //return em.find(Airport.class, id);
        return courseRepository.findById(id);
    }

    @Transactional
    public void delete(long id) {
        // em.remove(findById(id));
        // airports.remove(id);
        courseRepository.deleteById(id);
    }

    @Transactional
    public Course update(Course course) {
        // airports.put(id, airport);
        //checkUniqueIata(airport.getIata(), airport.getId());
        if (courseRepository.existsById(course.getId())) {
            //return airport;
            //return em.merge(airport); SD--->

//            logEntryService.createLog(String.format("Airport modified with id %d new name is %s",
//                    airport.getId(),
//                    airport.getName()));
//
//            callBackendSystem(); // mesterséges hiba generátor
            return courseRepository.save(course);
        } else
            throw new NoSuchElementException();
    }

}
