package com.rfid.api.repository;

import com.rfid.api.model.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {
}
