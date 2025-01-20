package com.vilaka.parquimetro.doc;

import com.vilaka.parquimetro.dtos.CobrancaDTO;
import com.vilaka.parquimetro.dtos.RegistroEstacionamentoDTO;
import com.vilaka.parquimetro.dtos.RegistroSaidaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Registro Estacionamento", description = "APIs para registrar entradas e saídas de veículos no estacionamento")
public interface IRegistroEstacionamentoAPI {

    @Operation(
            summary = "Registrar entrada de veículo",
            description = "Registra a entrada de um veículo no estacionamento e retorna os detalhes do registro.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Entrada registrada com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegistroEstacionamentoDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Erro na solicitação", content = @Content)
            }
    )
    @PostMapping("/entrada")
    ResponseEntity<RegistroEstacionamentoDTO> registrarEntrada(@RequestBody RegistroEstacionamentoDTO registroDTO);

    @Operation(
            summary = "Registrar saída de veículo",
            description = "Registra a saída de um veículo e retorna os detalhes da cobrança.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Saída registrada com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CobrancaDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Erro na solicitação", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Registro não encontrado", content = @Content)
            }
    )
    @PostMapping("/{registroId}/saida")
    ResponseEntity<CobrancaDTO> registrarSaida(@PathVariable Long registroId, @RequestBody RegistroSaidaDTO registroSaidaDTO);
}
