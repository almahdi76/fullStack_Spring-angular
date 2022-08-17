package fr.afpa.hr.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
 @NoArgsConstructor
@Table(name="student_college")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @Column(nullable = false,unique = true,updatable = false)
    private String codeStudent;
    private String urlPhoto;

    public Student(String name, String email, String codeStudent, String urlPhoto) {
        this.name = name;
        this.email = email;
        this.codeStudent = codeStudent;
        this.urlPhoto = urlPhoto;
    }

}
