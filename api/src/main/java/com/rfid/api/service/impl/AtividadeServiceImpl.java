package com.rfid.api.service.impl;

import com.rfid.api.model.Arquivo;
import com.rfid.api.model.Atividade;
import com.rfid.api.repository.ArquivoRepository;
import com.rfid.api.repository.AtividadeRepository;
import com.rfid.api.service.ArquivoService;
import com.rfid.api.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class AtividadeServiceImpl implements AtividadeService {

    @Value("${contato.disco.raiz}")
    private String raiz;

    @Value("${contato.disco.diretorio-files}")
    private String diretorioArquivos;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private ArquivoRepository arquivoRepository;

    @Autowired
    private ArquivoService arquivoService;

    @Override
    public Atividade criarAtividade(Atividade atividade){
        return atividadeRepository.save(atividade);
    }


    public void salvarArquivo(MultipartFile arquivo, Integer codigo, Integer idAtividade) {
        this.adicionarAtividade(this.diretorioArquivos, arquivo, codigo, idAtividade);
    }

    @Override
    public void adicionarAtividade(String diretorio, MultipartFile file, Integer codigo, Integer idAtividade){
        Arquivo arquivo = arquivoService.adicionarArquivo(diretorio, file, codigo);
        Atividade atividade = atividadeRepository.getOne(idAtividade);
        atividade.getArquivos().add(arquivo);
        atividadeRepository.save(atividade);
    }

    @Override
    public void removerAtividade(Integer idAtividade){
        Atividade atividade = atividadeRepository.getOne(idAtividade);
        List<Map<String, Object>> arquivos = arquivoRepository.findAllArquivosPorAtividade(idAtividade);
        atividade.getArquivos().removeAll(arquivos);
        atividadeRepository.save(atividade);
        atividadeRepository.deleteById(idAtividade);
        atividadeRepository.save(atividade);
    }

    @Override
    public List<Atividade> listarAtividadesCadastradas(){
        return atividadeRepository.findAll();
    }

}
