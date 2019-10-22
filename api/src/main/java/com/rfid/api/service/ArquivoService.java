package com.rfid.api.service;

import com.rfid.api.model.Arquivo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ArquivoService {

    Arquivo adicionarArquivo(String diretorio, MultipartFile arquivo, Integer codigo );

    Arquivo adicionarArquivoVouF(String diretorio, MultipartFile[] files, Boolean opcao );

    String analisar(String caminho);

    List<Map<String, Object>> buscarArquivosPorAtividade(Integer id);
}
