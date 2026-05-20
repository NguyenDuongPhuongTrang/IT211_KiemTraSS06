package kt.kiemtrass06.service;

import kt.kiemtrass06.model.dto.request.StudentDTO;
import kt.kiemtrass06.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    Student findById(Long id);
    Student patchStudent(Long id, StudentDTO studentDTO);
    void delete(Long id);
}
