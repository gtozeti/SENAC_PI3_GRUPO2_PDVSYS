package com.example.pdvsystem.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pdvsystem.businessLogic.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM Cliente c WHERE c.empresa_id = ?1")
	List<Cliente> getAllClienteFromEmpresa(Integer id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM Cliente c WHERE c.emppresa_id = ?1 AND c.documento = ?2")
	Cliente documentoExisteAtEmpresa(Integer id, String documento);
	
}
