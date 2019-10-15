package com.rfid.api.controller;

import com.rfid.api.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/arquivo")
public class ArquivoController {

    @Autowired
    private ArquivoService arquivoService;

    @GetMapping("exibir/{id}")
    public ResponseEntity<List<Map<String, Object>>> listarArquivosPorInscricao(@PathVariable Integer id) {
        List<Map<String, Object>> arquivos = this.arquivoService.buscarArquivosPorAtividade(id);
        return new ResponseEntity<>(arquivos, HttpStatus.OK);
    }
}
