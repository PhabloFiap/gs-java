package com.monitoramento.marinho.GS.repository;

import com.monitoramento.marinho.GS.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface IncidentRepository extends JpaRepository<Incident, Long>{


    }

