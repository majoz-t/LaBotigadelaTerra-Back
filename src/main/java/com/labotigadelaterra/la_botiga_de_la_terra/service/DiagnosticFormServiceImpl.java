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
    private final DiagnosticFormMapper mapper;

    public DiagnosticFormServiceImpl(DiagnosticFormRepository diagnosticFormRepository, DiagnosticFormMapper mapper) {
        this.diagnosticFormRepository = diagnosticFormRepository;
        this.mapper = mapper;
    }

    @Override
    public DiagnosticForm createForm(DiagnosticFormRequestDTO request, User user) {
        DiagnosticForm form = mapper.toEntity(request, user);
        form.setFormStatus(FormStatus.DRAFT);
        return diagnosticFormRepository.save(form);
    }

    @Override
    public DiagnosticForm getFormById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFormById'");
    }

    @Override
    public List<DiagnosticForm> getFormsByUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFormsByUser'");
    }

    @Override
    public DiagnosticForm updateForm(Integer id, DiagnosticFormRequestDTO request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateForm'");
    }

    @Override
    public void deleteForm(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteForm'");
    }
}
