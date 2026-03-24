package com.labotigadelaterra.la_botiga_de_la_terra.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.EmotionalCondition;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.FormStatus;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.PhysicalCondition;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.TastePreference;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.TemperaturePreference;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.WaterIntake;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Min(0)
    @Max(120)
    private Integer age;

    @NotNull
    @Positive
    private Double height;

    @NotNull
    @Positive
    private Double weight;

    @NotNull
    @Enumerated(EnumType.STRING)
    private WaterIntake waterIntake;

    @Enumerated(EnumType.STRING)
    private TemperaturePreference temperaturePreference;

    @NotNull
    private Boolean digestiveIssues;

    @ElementCollection(targetClass = TastePreference.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "taste_preferences", joinColumns = @JoinColumn(name = "form_id"))
    @Column(name = "taste")
    private Set<TastePreference> tastePreferences = new HashSet<>();

    @NotEmpty
    @ElementCollection(targetClass = EmotionalCondition.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "emotional_conditions", joinColumns = @JoinColumn(name = "form_id"))
    @Column(name = "condition")
    private Set<EmotionalCondition> emotionalConditions = new HashSet<>();

    @NotEmpty
    @ElementCollection(targetClass = PhysicalCondition.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "physical_conditions", joinColumns = @JoinColumn(name = "form_id"))
    @Column(name = "condition")
    private Set<PhysicalCondition> physicalConditions = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormStatus formStatus = FormStatus.DRAFT;

    private LocalDateTime submittedAt;

}
