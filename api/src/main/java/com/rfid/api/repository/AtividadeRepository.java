package com.rfid.api.repository;

import com.rfid.api.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {
}
