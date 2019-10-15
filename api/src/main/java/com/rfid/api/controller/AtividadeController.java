package com.rfid.api.controller;

import com.rfid.api.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping
    public ResponseEntity adicionarAtividade(
            @RequestParam MultipartFile file,
            @RequestParam Integer codigo,
            @RequestParam Integer idAtividade){
        atividadeService.salvarArquivo(file, codigo, idAtividade);

        return new ResponseEntity(HttpStatus.OK);
    }

}
