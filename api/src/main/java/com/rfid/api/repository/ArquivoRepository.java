package com.rfid.api.repository;

import com.rfid.api.model.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {


    @Query("SELECT a.nome AS nome, a.codigo AS codigo, a.id AS id FROM Arquivo a, Atividade t LEFT JOIN t.arquivos d WHERE t.id = :id AND d.id = a.id")
    List<Map<String, Object>> findAllArquivosPorAtividade(@Param("id") Integer id);
}
