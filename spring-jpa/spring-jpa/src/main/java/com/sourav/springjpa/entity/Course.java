package com.sourav.springjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="student_course", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    , inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"))

    private List<Student> students;
}
