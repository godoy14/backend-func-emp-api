package com.func.cont.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.func.cont.domain.model.Desempenho;

@Repository
public interface DesempenhoRepository extends JpaRepository<Desempenho, Long>{
	
	@Query("from Desempenho where funcionario_id = :id")
	List<Desempenho> consultarPorFuncionarioId(@Param("id") Long funcionarioId);
	
}
