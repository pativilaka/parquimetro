package com.vilaka.parquimetro.interfaces;

import java.time.LocalDateTime;

public interface ICobrancaService {

    double calcularCobranca(LocalDateTime entrada, LocalDateTime saida);

}
