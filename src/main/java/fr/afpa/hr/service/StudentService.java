package fr.afpa.hr.service;

import fr.afpa.hr.exceptions.UserNotFoundException;
import fr.afpa.hr.model.Student;
import fr.afpa.hr.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepo studentRepo;


    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student){
        student.setCodeStudent(UUID.randomUUID().toString());
        return studentRepo.save(student);
    }

    public List<Student> chercerAllStudent(){
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    public  void deleteStudent(Long id){
        studentRepo.deleteStudentById(id);
    }

    public Student chercherUnStudent(Long id){
        return studentRepo.findStudentById(id).orElseThrow(()-> new UserNotFoundException("un student avec id "+id+" n'exist pas"));
    }
}
