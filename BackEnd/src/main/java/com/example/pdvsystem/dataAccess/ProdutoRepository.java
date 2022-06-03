package com.example.pdvsystem.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pdvsystem.businessLogic.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM Produto p WHERE p.empresa_id = ?1")
	List<Produto> getAllProdutosFromEmpresa(Integer id);
	
}
