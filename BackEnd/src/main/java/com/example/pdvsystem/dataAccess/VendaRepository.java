package com.example.pdvsystem.dataAccess;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pdvsystem.businessLogic.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM Venda v WHERE v.empresa_id = ?1")
	List<Venda> getAllVendaFromEmpresa(Integer id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM Venda v WHERE v.empresa_id = ?1 AND (v.data_venda BETWEEN ?2 AND ?3)")
	List<Venda> getAllVendaFromEmpresaRangeDate(Integer id, Date inicio, Date fim);
	
}
