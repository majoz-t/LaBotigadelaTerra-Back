package com.labotigadelaterra.la_botiga_de_la_terra.service;

import java.util.List;

import com.labotigadelaterra.la_botiga_de_la_terra.dto.request.DiagnosticFormRequestDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.DiagnosticForm;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.User;

public interface DiagnosticFormService {
    public DiagnosticForm createForm(DiagnosticFormRequestDTO request, User user);

    public DiagnosticForm getFormById(Integer id);

    public List<DiagnosticForm> getFormsByUser(User user);

    public DiagnosticForm updateForm(Integer id, DiagnosticFormRequestDTO request);

    public void deleteForm(Integer id);
}
