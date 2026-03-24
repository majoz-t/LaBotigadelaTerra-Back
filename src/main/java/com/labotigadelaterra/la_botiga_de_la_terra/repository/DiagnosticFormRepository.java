package com.labotigadelaterra.la_botiga_de_la_terra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labotigadelaterra.la_botiga_de_la_terra.entity.DiagnosticForm;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.User;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.FormStatus;

public interface DiagnosticFormRepository extends JpaRepository<DiagnosticForm, Integer> {

    List<DiagnosticForm> findByUser(User user);

    List<DiagnosticForm> findByFormStatus(FormStatus status);
    
}
