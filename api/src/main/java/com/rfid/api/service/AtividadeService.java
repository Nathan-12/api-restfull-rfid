package com.rfid.api.service;

import org.springframework.web.multipart.MultipartFile;

public interface AtividadeService {

    void salvarArquivo(MultipartFile arquivo, Integer codigo, Integer idAtividade);

    void adicionarAtividade(String diretorio, MultipartFile file, Integer codigo, Integer idAtividade);
}
