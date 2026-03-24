package com.labotigadelaterra.la_botiga_de_la_terra.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labotigadelaterra.la_botiga_de_la_terra.dto.request.DiagnosticFormRequestDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.dto.response.DiagnosticFormResponseDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.DiagnosticForm;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.User;
import com.labotigadelaterra.la_botiga_de_la_terra.mapper.DiagnosticFormMapper;
import com.labotigadelaterra.la_botiga_de_la_terra.service.DiagnosticFormService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/diagnosticforms")
public class DiagnosticFormController {

    private final DiagnosticFormService diagnosticFormService;
    private final DiagnosticFormMapper mapper;

    public DiagnosticFormController(DiagnosticFormService diagnosticFormService, DiagnosticFormMapper mapper) {
        this.diagnosticFormService = diagnosticFormService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<DiagnosticFormResponseDTO> createForm(@Valid @RequestBody DiagnosticFormRequestDTO request){
        User user = new User();
        user.setId(1); 
        //User user = authService.getCurrentUser();
        DiagnosticForm form = diagnosticFormService.createForm(request, user);
        DiagnosticFormResponseDTO response = mapper.toResponse(form);
        return ResponseEntity.ok(response);
    }
}

