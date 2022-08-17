package fr.afpa.hr.controller;


import fr.afpa.hr.model.Student;
import fr.afpa.hr.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentResource {
    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student>listStudent=studentService.chercerAllStudent();
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable ("id") Long id){
        Student student=studentService.chercherUnStudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody  Student student){
        Student studentAdded=studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);

    }

    @PutMapping("/edit")
    public ResponseEntity<Student> editStudent(@RequestBody  Student student){
        Student studentEdit=studentService.updateStudent(student);
        return new ResponseEntity<>(studentEdit, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable ("id") Long id){
       studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
