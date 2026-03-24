package com.labotigadelaterra.la_botiga_de_la_terra.dto.request;

import java.util.Set;

import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.EmotionalCondition;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.PhysicalCondition;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.TastePreference;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.TemperaturePreference;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.WaterIntake;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record DiagnosticFormRequestDTO( 
    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    @Max(value = 120, message = "Edad no válida")
    Integer age,

    @NotNull(message = "La altura es obligatoria")
    @Positive(message = "La altura debe ser positiva")
    Double height,

    @NotNull(message = "El peso es obligatorio")
    @Positive(message = "El peso debe ser positivo")
    Double weight,

    @NotNull(message = "El consumo de agua es obligatorio")
    WaterIntake waterIntake,

    
    TemperaturePreference temperaturePreference,

    @NotNull(message = "Debe indicar si tiene problemas digestivos")
    Boolean digestiveIssues,

    Set<TastePreference> tastePreferences,

    @Size(min = 1, message = "Debe seleccionar al menos una opción")
    Set<EmotionalCondition> emotionalConditions,

    @Size(min = 1, message = "Debe seleccionar al menos una opción")
    Set<PhysicalCondition> physicalConditions
) {}


