package com.labotigadelaterra.la_botiga_de_la_terra.service;

import java.util.List;

import com.labotigadelaterra.la_botiga_de_la_terra.dto.request.DiagnosticFormRequestDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.dto.response.DiagnosticFormResponseDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.User;

public interface DiagnosticFormService {

    public DiagnosticFormResponseDTO createForm(DiagnosticFormRequestDTO request, User user);

    public DiagnosticFormResponseDTO getFormById(int id);

    public List<DiagnosticFormResponseDTO> getFormsByUser(User user);

    public DiagnosticFormResponseDTO updateForm(int id, DiagnosticFormRequestDTO request);

    public void deleteForm(Integer id);
}
