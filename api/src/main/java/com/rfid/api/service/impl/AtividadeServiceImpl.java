package com.rfid.api.service.impl;

import com.rfid.api.model.Arquivo;
import com.rfid.api.model.ArquivoVF;
import com.rfid.api.model.Atividade;
import com.rfid.api.repository.ArquivoRepository;
import com.rfid.api.repository.ArquivoVFRepository;
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
    private ArquivoVFRepository arquivoVFRepository;

    @Autowired
    private ArquivoService arquivoService;

    @Override
    public Atividade criarAtividade(Atividade atividade){
        return atividadeRepository.save(atividade);
    }


    public void salvarArquivo(MultipartFile arquivo, Integer codigo, Integer idAtividade) {
        this.adicionarAtividade(this.diretorioArquivos, arquivo, codigo, idAtividade);
    }

    public void salvarArquivoVF(MultipartFile arquivoVideo, MultipartFile arquivoImg, Integer codigoTeste, Integer idAtividade){
        this.adicionarAtividadeVF(this.diretorioArquivos, arquivoVideo, arquivoImg, codigoTeste, idAtividade);
    }

    @Override
    public void adicionarAtividade(String diretorio, MultipartFile file, Integer codigo, Integer idAtividade){
        Arquivo arquivo = arquivoService.adicionarArquivo(diretorio, file, codigo);
        Atividade atividade = atividadeRepository.getOne(idAtividade);
        atividade.getArquivos().add(arquivo);
        atividadeRepository.save(atividade);
    }

    @Override
    public void adicionarAtividadeVF(String diretorio, MultipartFile fileVideo, MultipartFile fileImg, Integer codigoTeste, Integer idAtividade){
        ArquivoVF arquivoVF = arquivoService.adicionarArquivoVF(diretorio, fileVideo, fileImg,codigoTeste);
        Atividade atividade = atividadeRepository.getOne(idAtividade);
        atividade.getArquivoVFS().add(arquivoVF);
        atividadeRepository.save(atividade);
    }

    @Override
    public void removerAtividade(Integer idAtividade){

        Atividade atividade = atividadeRepository.getOne(idAtividade);
        List<Map<String, Object>> arquivos = arquivoRepository.findAllArquivosPorAtividade(idAtividade);

        if(arquivos != null){
            atividade.getArquivos().removeAll(arquivos);
            atividadeRepository.delete(atividade);
        }else {
            atividadeRepository.delete(atividade);
        }
        atividadeRepository.save(atividade);
    }

    @Override
    public List<Atividade> listarAtividadesCadastradas(){
        return atividadeRepository.findAll();
    }

}
