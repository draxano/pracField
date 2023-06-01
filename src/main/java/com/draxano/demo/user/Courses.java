package com.draxano.demo.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // I added lombok library in order to provide getters and setter. Hence, removing boilerplate code.
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_course")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


}
