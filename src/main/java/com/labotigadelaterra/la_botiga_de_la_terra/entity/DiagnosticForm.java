package com.labotigadelaterra.la_botiga_de_la_terra.entity;

import java.time.LocalDateTime;

import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.FormStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diagnostic_forms")
@Data
@NoArgsConstructor
public class DiagnosticForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String responses;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormStatus formStatus;

    private LocalDateTime submittedAt;

}
