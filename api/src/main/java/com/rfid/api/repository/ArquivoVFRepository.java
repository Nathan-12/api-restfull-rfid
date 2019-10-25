package com.rfid.api.repository;

import com.rfid.api.model.ArquivoVF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ArquivoVFRepository extends JpaRepository<ArquivoVF, Integer> {

    @Query("SELECT avf.nomeVideo AS nomeVideo, avf.nomeImg AS nomeImg, avf.codigoTeste AS codigoTeste, avf.id AS id FROM ArquivoVF avf, Atividade t LEFT JOIN t.arquivoVFS dvf WHERE t.id = :id AND dvf.id = avf.id")
    List<Map<String, Object>> findAllArquivosVFPorAtividade(@Param("id") Integer id);
}
