package hu.webuni.student.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import hu.webuni.student.model.Course;
import hu.webuni.student.model.HistoryData;
import hu.webuni.student.model.QCourse;
import hu.webuni.student.repository.CourseRepository;
import hu.webuni.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Service
public class CourseService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    @PersistenceContext
    EntityManager em;

    @Transactional
    public List<Course> searchCourses(Predicate predicate, Pageable pageable) {

        /*

        // without Pageable:
        List<Course> courses = courseRepository.findAll(predicate, "Course.students", EntityGraph.EntityGraphType.LOAD);
        courses = courseRepository.findAll(QCourse.course.in(courses), "Course.teachers", EntityGraph.EntityGraphType.LOAD);
         */

        //with Pageable:

        Page<Course> coursePage = courseRepository.findAll(predicate, pageable);

        BooleanExpression inPredicate = QCourse.course.in(coursePage.getContent());
        List<Course> courses =
                courseRepository.findAll(inPredicate, "Course.students", EntityGraph.EntityGraphType.LOAD, Sort.unsorted());
        // itt felesleges rendezni, viszont mivel hozzaadtuk a sort parametert a QueryDslWithEntityGraphRepository-hoz, muszaj legyen egy parameter, am lehetne itt is pageable.getSort()

        courses =
                courseRepository.findAll(inPredicate, "Course.teachers", EntityGraph.EntityGraphType.LOAD, pageable.getSort());

        return courses;
    }

    @Transactional
    public Course save(Course course) {
        //a takeoff/landing airportból csak az id-t vesszük figyelembe, már létezniük kell
//        student.setTakeoff(studentRepository.findById(flight.getTakeoff().getId()).get());
//        student.setLanding(studentRepository.findById(flight.getLanding().getId()).get());
        return courseRepository.save(course);
    }

    /* my old version
    *** from here


    public List<Course> findCoursesByExample(Course example) {
        long courseId = example.getId();
        System.out.println(courseId);
        String courseName = example.getName();
        System.out.println(courseName);
        String teacherName = null;
        Teacher teacher = example.getTeacher();
        if (teacher != null)
            teacherName = teacher.getName();
        System.out.println(teacherName);
        long studentId = 0L;
        int semester = 0;
        Student student = example.getStudent();
        if (student != null)
            studentId = student.getId();
        System.out.println(studentId);
        if (student != null)
            semester = example.getStudent().getSemester();
        System.out.println(semester);


        //Specification<Flight> spec = Specification.where(null); // üres Specification, ami semmire nem szűr

        // a FlightSpecifications feltételeit ide írjuk bele közvetlen --->

        ArrayList<Predicate> predicates = new ArrayList<Predicate>();


        QCourse course = QCourse.course;

        if (courseId > 0 ) {

            // spec = spec.and(FlightSpecifications.hasId(id));
            predicates.add(course.id.eq(courseId));
        }

        if (StringUtils.hasText(courseName)) // SpringFramework-ös StringUtils
            // spec = spec.and(FlightSpecifications.hasFlightNumber(flightNumber));
            predicates.add(course.name.startsWithIgnoreCase(courseName));


        if (StringUtils.hasText(teacherName)) // SpringFramework-ös StringUtils
            // spec = spec.and(FlightSpecifications.hasFlightNumber(flightNumber));
            predicates.add(course.teacher.name.startsWithIgnoreCase(teacherName));

        if (studentId > 0) {

            // spec = spec.and(FlightSpecifications.hasId(id));
            predicates.add(course.student.id.eq(studentId));
        }

        if (semester > 0) {

            // spec = spec.and(FlightSpecifications.hasId(id));
            predicates.add(course.student.semester.between(semester, semester));
        }



        //return flightRepository.findAll(spec, Sort.by("id"));
        return Lists.newArrayList(courseRepository.findAll(ExpressionUtils.allOf(predicates)));
    }

    * to here ***
     */

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

    // this will be okay for fixed revision, forRevisionsOfEntity + traverseRelation
//
//    @Transactional
//    @SuppressWarnings({"rawtypes", "unchecked"})
//    public List<HistoryData<Course>> getCourseHistory(long id) {
//        List resultList = AuditReaderFactory.get(em)
//                .createQuery()
//                .forRevisionsOfEntity(Course.class, false, true) //csak entitasokat v torolt sorokat is
//                .add(AuditEntity.property("id").eq(id))
//                .traverseRelation("address", JoinType.LEFT)
//                .getResultList()
//                .stream()
//                .map(o-> {
//                    Object[] objArray = (Object[]) o;
//                    DefaultRevisionEntity revisionEntity = (DefaultRevisionEntity) objArray[1];
//                    return new HistoryData<Course> (
//                            (Course)  objArray[0],
//                            (RevisionType) objArray[2],
//                            revisionEntity.getId(),
//                            revisionEntity.getRevisionDate()
//                            );
//                }).toList();
//
//        return resultList;
//    }


    @Transactional
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<HistoryData<Course>> getCourseHistory(long id) {
        List resultList = AuditReaderFactory.get(em)
                .createQuery()
                .forRevisionsOfEntity(Course.class, false, true) //csak entitasokat v torolt sorokat is
                .add(AuditEntity.property("id").eq(id))
                //.traverseRelation("address", JoinType.LEFT) torolni kell, sajnos nem fixed revision-nel nem lehet, lentebb kell megoldani
                .getResultList()
                .stream()
                .map(o -> {
                    Object[] objArray = (Object[]) o;
                    DefaultRevisionEntity revisionEntity = (DefaultRevisionEntity) objArray[1];
                    Course course = (Course) objArray[0];
                    course.getName().toString(); //betoltes kikenyszeritese, barmit hivok rajta, csak akkor toltodik be (controllerben sima mappeles, h a kapcsolatok is jojjenek, de lecsatolt allapotban kerulnek ide)
                    course.getStudents().size();
                    course.getTeachers().size();
                    return new HistoryData<Course>(
                            course,
                            (RevisionType) objArray[2],
                            revisionEntity.getId(),
                            revisionEntity.getRevisionDate()
                    );
                }).toList();

        return resultList;
    }


    @Transactional
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<HistoryData<Course>> getCourseHistoryByDate(LocalDateTime date) {


        //https://stackoverflow.com/questions/45914795/hibernate-envers-how-to-get-all-current-enties-with-their-creation-timestamps
//        AuditQuery query = AuditReaderFactory.get(em)
//                .createQuery()
//                .forRevisionsOfEntity( Course.class, true, false )
//                .addProjection( AuditEntity.id() )
//                .addProjection( AuditEntity.revisionProperty( "date" ) )
//                .add( AuditEntity.revisionType().eq( RevisionType.ADD ) );
//
//
//        AuditQuery query2 = AuditReaderFactory.get(em)
//                .createQuery()
//                .forRevisionsOfEntity( Course.class, true, false )
//                .addProjection( AuditEntity.id() )
//                .addProjection( AuditEntity.revisionNumber().max() );
//
//        for ( Map.Entry<YourEntityIdType,Number> entry : idRevisionPairs.entrySet() ) {
//            AuditQuery query = auditReader.createQuery()
//                    .forEntitiesAtRevision( Client.class, entry.getValue() )
//                    .add( AuditEntity.id().eq( entry.getKey() )
//                            .addProjection( ... );
//
//            // here take the results from query and the id-timestamp pairs and
//            // marry them into some DTO you return.
//        }

//        https://stackoverflow.com/questions/21591381/querying-all-hibernate-envers-revisions-between-two-dates
//        List<Object[]> revisions = (List<Object[]>) getAuditReader().createQuery()
//                .forRevisionsOfEntity(MYCLASS.class, false, true)
//                .add(AuditEntity.revisionProperty("timestamp").gt(startDate))
//                .add(AuditEntity.revisionProperty("timestamp").lt(endDate))
//                .getResultList();

        //Timestamp timestamp = new Timestamp(new Date(String.valueOf(date)).getTime());
        Date date1 = new Date();
        date1 = convertToDateViaSqlDate(date.toLocalDate()); //for date
        long date2 = date1.getTime();

        List resultList = AuditReaderFactory.get(em)
                .createQuery()
                .forRevisionsOfEntity(Course.class, false, true) //csak entitasokat v torolt sorokat is
                //.add(AuditEntity.property("id").eq(id))
                //.add(AuditEntity.property("timestamp").le(date2))
                //.add(AuditEntity.revisionProperty("date").between(date.minusDays(1),date.plusDays(1)))
                //.addProjection( AuditEntity.revisionProperty( "date" ) )
                .add(AuditEntity.revisionProperty("timestamp").le(date2))
                //.add(AuditEntity.revisionProperty("date").gt(date.minusDays(1)))
                //.add(AuditEntity.revisionProperty("date").lt(date.plusDays(1)))
                //.traverseRelation("teacher", JoinType.LEFT)
                //.traverseRelation("student", JoinType.LEFT)
                .getResultList()
                .stream()
                .map(o -> {
                    Object[] objArray = (Object[]) o;
                    DefaultRevisionEntity revisionEntity = (DefaultRevisionEntity) objArray[1];
                    Course course = (Course) objArray[0];
                    course.getName().toString(); //betoltes kikenyszeritese, barmit hivok rajta, csak akkor toltodik be (controllerben sima mappeles, h a kapcsolatok is jojjenek, de lecsatolt allapotban kerulnek ide)
                    course.getStudents().size();
                    course.getTeachers().size();
                    return new HistoryData<Course>(
                            course,
                            (RevisionType) objArray[2],
                            revisionEntity.getId(),
                            revisionEntity.getRevisionDate()
                    );
                }).toList();

        return resultList;
    }


    @Transactional
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<HistoryData<Course>> getCourseStatusByDateTime(long id, LocalDateTime date) throws Throwable {


        //Timestamp timestamp = new Timestamp(new Date(String.valueOf(date)).getTime());
        Date date1 = new Date();
        date1 = convertToDateViaSqlDateTime(date);
        long date2 = date1.getTime();

        List resultList = AuditReaderFactory.get(em)
                .createQuery()
                .forRevisionsOfEntity(Course.class, false, false) //csak entitasokat v torolt sorokat is
                //.add(AuditEntity.property("id").eq(id))
                //.add(AuditEntity.property("timestamp").le(date2))
                //.add(AuditEntity.revisionProperty("date").between(date.minusDays(1),date.plusDays(1)))
                //.addProjection( AuditEntity.revisionProperty( "date" ) )
                .add(AuditEntity.revisionProperty("timestamp").le(date2))
                .add(AuditEntity.property("id").eq(id))
                //.add(AuditEntity.revisionNumber().maximize())
                //.add(AuditEntity.revisionProperty("date").gt(date.minusDays(1)))
                //.add(AuditEntity.revisionProperty("date").lt(date.plusDays(1)))
                //.traverseRelation("teacher", JoinType.LEFT)
                //.traverseRelation("student", JoinType.LEFT)
                .getResultList()
                .stream()
                .map(o -> {
                    Object[] objArray = (Object[]) o;
                    DefaultRevisionEntity revisionEntity = (DefaultRevisionEntity) objArray[1];
                    Course course = (Course) objArray[0];
                    course.getName().toString(); //betoltes kikenyszeritese, barmit hivok rajta, csak akkor toltodik be (controllerben sima mappeles, h a kapcsolatok is jojjenek, de lecsatolt allapotban kerulnek ide)
                    course.getStudents().size();
                    course.getTeachers().size();
                    return new HistoryData<Course>(
                            course,
                            (RevisionType) objArray[2],
                            revisionEntity.getId(),
                            revisionEntity.getRevisionDate()
                    );
                })
             //   .toList().stream()
                .max(Comparator.comparing(o -> {
                    Object[] objArray = (Object[]) o;
                    DefaultRevisionEntity revisionEntity = (DefaultRevisionEntity) objArray[1];
                    return revisionEntity.getRevisionDate();
                })).orElseThrow(NoSuchElementException::new)
                .toList();

//        List new = resultList.forEach(o -> o);
//        List filteredResultList = resultList.stream().filter((o) -> o.() == id);
//
//        return filteredResultList;
        return resultList;
    }









    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    public Date convertToDateViaSqlDateTime(LocalDateTime dateToConvert) {


        Timestamp timestamp = Timestamp.valueOf(dateToConvert.plusHours(1));

    //LocalDateTime dt = dateToConvert;
// save time information (hour, minute, seconds, fraction of seconds)
      //      LocalTime savedTime = dt.toLocalTime();
    // convert to Date (time information is lost)
    //java.sql.Date date = java.sql.Date.valueOf(dt.toLocalDate());

    // retrieve back the LocalDate (only day/month/year)
    //LocalDate localDate = date.toLocalDate();
    // retrieve the LocalDateTime, with the original time values
    //LocalDateTime ldt = localDate.atTime(savedTime);

//    public LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
//        return Instant.ofEpochMilli(dateToConvert.getTime())
//                .atZone(ZoneId.systemDefault())
//                .toLocalDateTime();
//    }
        return timestamp;
    }
}
