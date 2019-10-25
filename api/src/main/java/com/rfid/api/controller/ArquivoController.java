package com.rfid.api.controller;

import com.rfid.api.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/arquivo")
public class ArquivoController {

    @Autowired
    private ArquivoService arquivoService;

    @GetMapping("exibir/{id}")
    public ResponseEntity<List<Map<String, Object>>> listarArquivosPorAtividade(@PathVariable Integer id) {
        List<Map<String, Object>> arquivos = this.arquivoService.buscarArquivosPorAtividade(id);
        return new ResponseEntity<>(arquivos, HttpStatus.OK);
    }

    @GetMapping("exibirvf/{id}")
    public ResponseEntity<List<Map<String, Object>>> listarArquivosVFPorAtividade(@PathVariable Integer id){
        List<Map<String, Object>> arquivoVFS = this.arquivoService.buscarArquivosVFPorAtividade(id);
        return new ResponseEntity<>(arquivoVFS, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFile/{idAtividade}/{idArquivo}")
    public ResponseEntity removerArquivo(
            @PathVariable Integer idAtividade,
            @PathVariable Integer idArquivo){
        arquivoService.excluirArquivoAssociacao(idAtividade, idArquivo);
        return new ResponseEntity(HttpStatus.OK);
    }
}
