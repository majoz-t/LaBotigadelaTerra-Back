package com.labotigadelaterra.la_botiga_de_la_terra.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.labotigadelaterra.la_botiga_de_la_terra.dto.request.DiagnosticFormRequestDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.dto.response.DiagnosticFormResponseDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.DiagnosticForm;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.User;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.FormStatus;
import com.labotigadelaterra.la_botiga_de_la_terra.mapper.DiagnosticFormMapper;
import com.labotigadelaterra.la_botiga_de_la_terra.repository.DiagnosticFormRepository;

import jakarta.transaction.Transactional;

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
    @Transactional
    public DiagnosticFormResponseDTO createForm(DiagnosticFormRequestDTO request, User user) {
        DiagnosticForm form = diagnosticFormMapper.toEntity(request, user);
        form.setFormStatus(FormStatus.DRAFT);
        DiagnosticForm savedForm = diagnosticFormRepository.save(form);
        diagnosticFormRepository.flush();
        return diagnosticFormMapper.toResponse(savedForm);
    }

    @Override
    @Transactional
    public DiagnosticFormResponseDTO updateForm(int id, DiagnosticFormRequestDTO request) {
        DiagnosticForm existingForm = diagnosticFormRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formulario no encontrado"));
        if (existingForm.getFormStatus() != FormStatus.DRAFT) {
            throw new RuntimeException("Solo se pueden editar formularios en estado BORRADOR.");
        }
        diagnosticFormMapper.updateEntityFromDto(request, existingForm);
        DiagnosticForm updatedForm = diagnosticFormRepository.save(existingForm);
        return diagnosticFormMapper.toResponse(updatedForm);
    }

    @Override
    public DiagnosticFormResponseDTO getFormById(int id) {
        DiagnosticForm form = diagnosticFormRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formulario no encontrado"));
        return diagnosticFormMapper.toResponse(form);
    }

    @Override
    public List<DiagnosticFormResponseDTO> getFormsByUser(User user) {
        if (user == null || user.getId() == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        List<DiagnosticForm> forms = diagnosticFormRepository.findByUser(user);
        return forms.stream()
                .map(diagnosticFormMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void deleteForm(int id) {
        DiagnosticForm form = diagnosticFormRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El formulario no existe."));
        if (form.getFormStatus() == FormStatus.SUBMITTED || form.getFormStatus() == FormStatus.COMPLETED) {
            throw new RuntimeException("No se puede eliminar un formulario que ya ha sido enviado.");
        }
        diagnosticFormRepository.delete(form);
    }

    @Override
    @Transactional
    public DiagnosticFormResponseDTO submitForm(int id) {
        DiagnosticForm form = diagnosticFormRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formulario no encontrado"));
        if (form.getFormStatus() != FormStatus.DRAFT) {
            throw new IllegalStateException("El formulario ya ha sido enviado o está en proceso de pago.");
        }
        form.setFormStatus(FormStatus.PENDING_PAYMENT);
        DiagnosticForm updatedForm = diagnosticFormRepository.save(form);
        return diagnosticFormMapper.toResponse(updatedForm);
    }

    @Override
    public List<DiagnosticFormResponseDTO> getFormsForDoctor() {
        List<DiagnosticForm> forms = diagnosticFormRepository.findByFormStatus(FormStatus.SUBMITTED);
        return forms.stream()
                .map(diagnosticFormMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public DiagnosticFormResponseDTO confirmPayment(int id) {
        DiagnosticForm form = diagnosticFormRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formulario no encontrado"));
        if (form.getFormStatus() != FormStatus.PENDING_PAYMENT) {
            throw new IllegalStateException("El formulario no está en espera de pago.");
        }
        form.setFormStatus(FormStatus.SUBMITTED);
        form.setSubmittedAt(LocalDateTime.now());
        DiagnosticForm updatedForm = diagnosticFormRepository.save(form);
        return diagnosticFormMapper.toResponse(updatedForm);

    }

}
