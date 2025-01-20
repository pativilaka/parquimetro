package com.vilaka.parquimetro.services;

import com.vilaka.parquimetro.dtos.RegistroEstacionamentoDTO;
import com.vilaka.parquimetro.entidades.Cobranca;
import com.vilaka.parquimetro.entidades.Filial;
import com.vilaka.parquimetro.entidades.RegistroEstacionamento;
import com.vilaka.parquimetro.entidades.Veiculo;
import com.vilaka.parquimetro.repositories.CobrancaRepository;
import com.vilaka.parquimetro.repositories.FilialRepository;
import com.vilaka.parquimetro.repositories.RegistroEstacionamentoRepository;
import com.vilaka.parquimetro.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistroEstacionamentoService {
    @Autowired
    private RegistroEstacionamentoRepository registroRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private CobrancaRepository cobrancaRepository;

    @Autowired
    private CobrancaService cobrancaService;

    public RegistroEstacionamento registrarEntrada(RegistroEstacionamentoDTO registroDTO) {
        Veiculo veiculo = veiculoRepository.findById(registroDTO.getVeiculoId())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        Filial filial = filialRepository.findById(registroDTO.getFilialId())
                .orElseThrow(() -> new RuntimeException("Filial não encontrada"));

        RegistroEstacionamento registro = new RegistroEstacionamento();
        registro.setEntrada(registroDTO.getEntrada());
        registro.setVeiculo(veiculo);
        registro.setFilial(filial);

        return registroRepository.save(registro);
    }

    @Transactional
    public Cobranca registrarSaida(Long registroId, LocalDateTime saida) {

        RegistroEstacionamento registro = registroRepository.findById(registroId)
                .orElseThrow(() -> new RuntimeException("Registro de estacionamento não encontrado"));

        if (registro.getSaida() != null) {
            //teste
            System.out.println("Saída já registrada anteriormente. Atualizando para novo valor para fins de teste.");
            //throw new RuntimeException("A saída já foi registrada para este registro.");
        }

        registro.setSaida(saida);

        double valorCobranca = cobrancaService.calcularCobranca(registro.getEntrada(), saida);

        Cobranca cobranca = registro.getCobranca();
        if (cobranca == null) {
            cobranca = new Cobranca();
            cobranca.setRegistro(registro);
        }

        cobranca.setValor(valorCobranca);
        cobranca.setPago(false);

        registro.setCobranca(cobranca);
        registroRepository.save(registro);

       return cobranca;

    }

    public List<RegistroEstacionamento> listarTodos() {
        return registroRepository.findAll();
    }
}
