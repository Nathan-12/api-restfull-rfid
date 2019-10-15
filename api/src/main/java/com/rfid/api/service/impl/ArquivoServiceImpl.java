package com.rfid.api.service.impl;

import com.rfid.api.model.Arquivo;
import com.rfid.api.repository.ArquivoRepository;
import com.rfid.api.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ArquivoServiceImpl implements ArquivoService {

    @Value("${contato.disco.raiz}")
    private String raiz;

    @Value("${contato.disco.diretorio-files}")
    private String diretorioArquivos;

    @Autowired
    private ArquivoRepository arquivoRepository;

    @Override
    public Arquivo adicionarArquivo(String diretorio, MultipartFile arquivo, Integer codigo ){
        Path diretorioPath = Paths.get(this.raiz, diretorio);
        String codigoRfidName = Integer.toString(codigo);
        Path arquivoPath = diretorioPath.resolve("00"+codigoRfidName);
        try {
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());

        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }
        return null;
    }

    public String analisar(String caminho)
    {
        //cria um objeto file para o caminho especificado pelo usuario
        File nome = new File (raiz);

        //se o nome existir e for diretorio , gera informações
        if (nome.exists() && nome.isDirectory())
        {
            //recebe a lista do nome dos arquivos
            String arquivos [] = nome.list();

            for (String item : arquivos){
                System.out.printf("%s\n",item);

            }
        }
        else 	System.out.printf("%s\n" , "Nao encontrado");
        return caminho;
    }

}
