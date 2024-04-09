package edu.icet.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.entity.StudentEntity;
import edu.icet.demo.model.Student;
import edu.icet.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    @Autowired
    ObjectMapper mapper;
    public Student createStudentData(Student student) {
        StudentEntity entity = mapper.convertValue(student, StudentEntity.class);
        StudentEntity save = repository.save(entity);

        return mapper.convertValue(save, Student.class);
    }
}
