package hu.webuni.student.service;

import hu.webuni.student.model.Student;
import hu.webuni.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class InitDbService {



    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;



    @Transactional
    public void addInitData() {
        Student student1 = studentRepository.save(new Student("student1", LocalDate.of(1977, 6, 27), 1));
        Student student2 = studentRepository.save(new Student("student2", LocalDate.of(1977, 7, 27), 2));
        Student student3 = studentRepository.save(new Student("student3", LocalDate.of(1977, 8, 27), 3));
        Student student4 = studentRepository.save(new Student("student4", LocalDate.of(1977, 9, 27), 4));

    }

    }


