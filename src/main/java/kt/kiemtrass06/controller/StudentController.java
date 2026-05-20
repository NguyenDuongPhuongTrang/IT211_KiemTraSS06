package kt.kiemtrass06.controller;

import kt.kiemtrass06.model.dto.request.StudentDTO;
import kt.kiemtrass06.model.dto.response.ApiDataResponse;
import kt.kiemtrass06.model.entity.Student;
import kt.kiemtrass06.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Student>>> getAllStudents() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách sinh viên thành công",
                studentService.findAll(),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Student>> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy thông tin sinh viên thành công",
                studentService.findById(id),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Student>> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Tạo sinh viên thành công",
                studentService.createStudent(student),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Student>> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Cập nhật sinh viên thành công",
                studentService.updateStudent(id, student),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Student>> patchStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Cập nhật thành công",
                studentService.patchStudent(id, studentDTO),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Void>> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Xóa sinh viên thành công",
                null,
                HttpStatus.NO_CONTENT
        ), HttpStatus.NO_CONTENT);
    }
}
