package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence")
    private Long courseMaterialId;
    private String url;
    //********************Mapping one:one
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
