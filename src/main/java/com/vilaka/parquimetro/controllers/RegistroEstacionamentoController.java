package com.vilaka.parquimetro.controllers;

import com.vilaka.parquimetro.doc.IRegistroEstacionamentoAPI;
import com.vilaka.parquimetro.dtos.CobrancaDTO;
import com.vilaka.parquimetro.dtos.RegistroEstacionamentoDTO;
import com.vilaka.parquimetro.dtos.RegistroSaidaDTO;
import com.vilaka.parquimetro.entidades.Cobranca;
import com.vilaka.parquimetro.entidades.RegistroEstacionamento;
import com.vilaka.parquimetro.services.RegistroEstacionamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/estacionamento")
public class RegistroEstacionamentoController implements IRegistroEstacionamentoAPI {

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

    @Override
    @Operation(
            summary = "Registrar saída de veículo",
            description = "Registra a saída de um veículo e retorna os detalhes da cobrança.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Saída registrada com sucesso",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            value = "{\n" +
                                                    "  \"id\": 123,\n" +
                                                    "  \"valor\": 15.50,\n" +
                                                    "  \"pago\": true,\n" +
                                                    "  \"registroId\": 456\n" +
                                                    "}"
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Erro na solicitação"),
                    @ApiResponse(responseCode = "404", description = "Registro não encontrado")
            }
    )
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
