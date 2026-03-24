package com.labotigadelaterra.la_botiga_de_la_terra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.labotigadelaterra.la_botiga_de_la_terra.dto.request.DiagnosticFormRequestDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.DiagnosticForm;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.User;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.FormStatus;
import com.labotigadelaterra.la_botiga_de_la_terra.mapper.DiagnosticFormMapper;
import com.labotigadelaterra.la_botiga_de_la_terra.repository.DiagnosticFormRepository;

@Service
public class DiagnosticFormServiceImpl implements DiagnosticFormService {

    private final DiagnosticFormRepository diagnosticFormRepository;
    private final DiagnosticFormMapper diagnosticFormMapper;

    public DiagnosticFormServiceImpl(DiagnosticFormRepository diagnosticFormRepository,
            DiagnosticFormMapper diagnosticFormMapper) {
        this.diagnosticFormRepository = diagnosticFormRepository;
        this.diagnosticFormMapper = diagnosticFormMapper;
    }

    @Override
    public DiagnosticForm createForm(DiagnosticFormRequestDTO request, User user) {
        DiagnosticForm form = diagnosticFormMapper.toEntity(request, user);
        form.setFormStatus(FormStatus.DRAFT);
        return diagnosticFormRepository.save(form);
    }

    @Override
    public DiagnosticForm getFormById(int id) {
        return diagnosticFormRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Formulario no encontrado"));
    }

    // @Override
    // public List<DiagnosticForm> getFormsByUser(User user) {
    //     return 
    // }

    @Override
    public DiagnosticForm updateForm(int id, DiagnosticFormRequestDTO request) {
        DiagnosticForm existingForm = diagnosticFormRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formulario no encontrado"));
        if (existingForm.getFormStatus() != FormStatus.DRAFT) {
            throw new RuntimeException("Solo se pueden editar formularios en estado BORRADOR.");
        }
        diagnosticFormMapper.updateEntityFromDto(request, existingForm);
        return diagnosticFormRepository.save(existingForm);
    }

    @Override
    public void deleteForm(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteForm'");
    }
}
