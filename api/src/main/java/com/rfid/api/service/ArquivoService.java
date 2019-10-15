package com.rfid.api.service;

import com.rfid.api.model.Arquivo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ArquivoService {

    Arquivo adicionarArquivo(String diretorio, MultipartFile arquivo, Integer codigo );

    String analisar(String caminho);

    List<Map<String, Object>> buscarArquivosPorAtividade(Integer id);
}
