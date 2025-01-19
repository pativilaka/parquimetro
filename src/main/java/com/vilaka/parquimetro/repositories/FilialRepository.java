package com.vilaka.parquimetro.repositories;

import com.vilaka.parquimetro.entidades.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilialRepository extends JpaRepository<Cobranca, Long> {
}
