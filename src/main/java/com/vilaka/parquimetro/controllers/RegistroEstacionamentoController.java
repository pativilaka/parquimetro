package com.vilaka.parquimetro.controllers;

import com.vilaka.parquimetro.dtos.CobrancaDTO;
import com.vilaka.parquimetro.dtos.RegistroEstacionamentoDTO;
import com.vilaka.parquimetro.dtos.RegistroSaidaDTO;
import com.vilaka.parquimetro.entidades.Cobranca;
import com.vilaka.parquimetro.entidades.RegistroEstacionamento;
import com.vilaka.parquimetro.services.RegistroEstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/estacionamento")
public class RegistroEstacionamentoController {

    @Autowired
    private RegistroEstacionamentoService registroEstacionamentoService;

    @PostMapping("/entrada")
    public ResponseEntity<RegistroEstacionamentoDTO> registrarEntrada(@RequestBody RegistroEstacionamentoDTO registroDTO) {
        RegistroEstacionamento registro = registroEstacionamentoService.registrarEntrada(registroDTO);
        RegistroEstacionamentoDTO responseDTO = new RegistroEstacionamentoDTO(
                registro.getId(),
                registro.getEntrada(),
                null, // A saída ainda não foi registrada
                registro.getVeiculo().getId(),
                registro.getFilial().getId()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PostMapping("/{registroId}/saida")
    public ResponseEntity<CobrancaDTO> registrarSaida(@PathVariable Long registroId, @RequestBody RegistroSaidaDTO registroSaidaDTO) {
        LocalDateTime saida = registroSaidaDTO.getSaida(); // Extrair o valor da saída
        Cobranca cobranca = registroEstacionamentoService.registrarSaida(registroId, saida);
        CobrancaDTO cobrancaDTO = new CobrancaDTO(
                cobranca.getId(),
                cobranca.getValor(),
                cobranca.isPago(),
                cobranca.getRegistro().getId()
        );
        return ResponseEntity.ok(cobrancaDTO);
    }
}
