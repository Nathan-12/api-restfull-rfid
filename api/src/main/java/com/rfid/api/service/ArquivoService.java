package com.rfid.api.service;

import com.rfid.api.model.Arquivo;
import com.rfid.api.model.ArquivoVF;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ArquivoService {

    Arquivo adicionarArquivo(String diretorio, MultipartFile arquivo, Integer codigo );

    ArquivoVF adicionarArquivoVF(String diretorio, MultipartFile fileVideo, MultipartFile fileImg, Integer codigoTeste );

    String analisar(String caminho);

    List<Map<String, Object>> buscarArquivosPorAtividade(Integer id);

    List<Map<String, Object>> buscarArquivosVFPorAtividade(Integer id);

    void excluirArquivoAssociacao(Integer idAtividade, Integer id);
}
