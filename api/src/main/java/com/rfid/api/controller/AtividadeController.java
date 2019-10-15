package com.rfid.api.controller;

import com.rfid.api.model.Atividade;
import com.rfid.api.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping("/adicionar")
    public Atividade adicionarAtividade(@RequestBody Atividade atividade){
        return atividadeService.criarAtividade(atividade);
    }

    @PostMapping("/{idAtividade}")
    public ResponseEntity adicionarAtividade(
            @RequestParam MultipartFile file,
            @RequestParam Integer codigo,
            @PathVariable Integer idAtividade){
        atividadeService.salvarArquivo(file, codigo, idAtividade);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{idAtividade}")
    public ResponseEntity removerAtividade(@PathVariable Integer idAtividade){
        atividadeService.removerAtividade(idAtividade);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Atividade>> listarAtividades(){
        List<Atividade> atividades = atividadeService.listarAtividadesCadastradas();
        return new ResponseEntity<>(atividades, HttpStatus.OK);
    }

}
