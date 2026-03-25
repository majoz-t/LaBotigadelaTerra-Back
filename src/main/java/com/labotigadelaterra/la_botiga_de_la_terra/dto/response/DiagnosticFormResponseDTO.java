package com.labotigadelaterra.la_botiga_de_la_terra.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.EmotionalCondition;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.FormStatus;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.PhysicalCondition;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.TastePreference;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.TemperaturePreference;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.WaterIntake;

public record DiagnosticFormResponseDTO(
 Integer id,
    Integer age,
    Double height,
    Double weight,
    WaterIntake waterIntake,
    TemperaturePreference temperaturePreference,
    Boolean digestiveIssues,
    Set<TastePreference> tastePreferences,
    Set<EmotionalCondition> emotionalConditions,
    Set<PhysicalCondition> physicalConditions,
    FormStatus formStatus,       
    LocalDateTime submittedAt   
) {}
