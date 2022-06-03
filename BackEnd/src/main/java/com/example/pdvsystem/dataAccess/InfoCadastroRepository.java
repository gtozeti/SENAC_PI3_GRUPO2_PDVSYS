package com.example.pdvsystem.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pdvsystem.businessLogic.model.InfoCadastro;

@Repository
public interface InfoCadastroRepository extends JpaRepository<InfoCadastro, Integer> {

}
