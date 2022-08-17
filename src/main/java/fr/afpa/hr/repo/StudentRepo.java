package fr.afpa.hr.repo;

import fr.afpa.hr.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long> {


    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);
}
