package com.rfid.api.service;

import com.rfid.api.model.Atividade;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AtividadeService {

    Atividade criarAtividade(Atividade atividade);

    void salvarArquivo(MultipartFile arquivo, Integer codigo, Integer idAtividade);

    void salvarArquivoVF(MultipartFile arquivoVideo, MultipartFile arquivoImg, Integer codigoTeste, Integer idAtividade);

    void adicionarAtividade(String diretorio, MultipartFile file, Integer codigo, Integer idAtividade);

    void adicionarAtividadeVF(String diretorio, MultipartFile fileVideo, MultipartFile fileImg, Integer codigoTeste, Integer idAtividade);

    List<Atividade> listarAtividadesCadastradas();

    void removerAtividade(Integer idAtividade);
}
