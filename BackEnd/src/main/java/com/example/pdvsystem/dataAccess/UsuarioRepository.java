package com.example.pdvsystem.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pdvsystem.businessLogic.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM Usuario u WHERE u.empresa_id = ?1")
	public List<Usuario> findUsuarioByEmpresaId(Integer id);
	
	Usuario findByEmail(String email);
	
	Usuario findByDocumento(String documento);
}
