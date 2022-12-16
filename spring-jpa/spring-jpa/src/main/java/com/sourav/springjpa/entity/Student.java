package com.sourav.springjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "student", uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email"))
public class Student {

    @Id
    @SequenceGenerator(name = "sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long studentId;
    private String firstname;
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Embedded
    private Guardian guardian;

}
