package kt.kiemtrass06.service;

import kt.kiemtrass06.model.dto.request.StudentDTO;
import kt.kiemtrass06.model.entity.Student;
import kt.kiemtrass06.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student s = findById(id);
        s.setFullName(student.getFullName());
        s.setEmail(student.getEmail());
        s.setGpa(student.getGpa());
        return studentRepository.save(s);
    }

    @Override
    public Student patchStudent(Long id, StudentDTO studentDTO) {
        Student s = findById(id);
        if (studentDTO.getFullName() != null && !studentDTO.getFullName().isBlank()) {
            s.setFullName(studentDTO.getFullName());
        }
        if (studentDTO.getEmail() != null && !studentDTO.getEmail().isBlank()) {
            s.setEmail(studentDTO.getEmail());
        }
        if (studentDTO.getGpa() != null && studentDTO.getGpa() > 0) {
            s.setGpa(studentDTO.getGpa());
        }
        return studentRepository.save(s);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
