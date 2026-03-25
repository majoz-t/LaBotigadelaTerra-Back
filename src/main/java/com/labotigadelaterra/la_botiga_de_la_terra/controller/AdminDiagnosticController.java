package com.labotigadelaterra.la_botiga_de_la_terra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labotigadelaterra.la_botiga_de_la_terra.dto.response.DiagnosticFormResponseDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.service.DiagnosticFormService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/admin/diagnostics")
public class AdminDiagnosticController {

    private final DiagnosticFormService diagnosticFormService;

    public AdminDiagnosticController(DiagnosticFormService diagnosticFormService){
        this.diagnosticFormService= diagnosticFormService;
    }

    @GetMapping("/pending")
    public ResponseEntity<List<DiagnosticFormResponseDTO>> getFormsForDoctor() {
        List<DiagnosticFormResponseDTO> forms = diagnosticFormService.getFormsForDoctor();
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }
    

}
