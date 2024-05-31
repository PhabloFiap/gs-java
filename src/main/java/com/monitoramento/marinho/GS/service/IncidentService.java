package com.monitoramento.marinho.GS.service;

import com.monitoramento.marinho.GS.entity.Incident;
import com.monitoramento.marinho.GS.repository.IncidentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    private final IncidentRepository incidentRepository;


    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }
    @Transactional
    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public Optional<Incident> getIncidentById(Long id) {
        return incidentRepository.findById(id);
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    @Transactional
    public Incident updateIncident(Long id, Incident updatedIncident) {
        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Incident with id " + id + " does not exist"));
        incident.setDescricao(updatedIncident.getDescricao());
        incident.setLugar(updatedIncident.getLugar());
        incident.setTipo(updatedIncident.getTipo());
        return incidentRepository.save(incident);
    }

}
