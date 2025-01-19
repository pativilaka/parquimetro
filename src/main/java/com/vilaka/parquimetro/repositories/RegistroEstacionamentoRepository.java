package com.vilaka.parquimetro.repositories;

import com.vilaka.parquimetro.entidades.RegistroEstacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEstacionamentoRepository extends JpaRepository<RegistroEstacionamento, Long> {
}
