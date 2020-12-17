package com.myfirstproject.myproject.repository.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_pessoa")

public class PessoaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codigo")
	private UUID codigo;
 
	@Column(name="nome")	
	private String  nome;
 
	@Column(name="sexo")
	private String  sexo;
 
	public UUID getCodigo() {
		return codigo;
	}
 
	public void setCodigo(UUID codigo) {
		this.codigo = codigo;
	}
 
	public String getNome() {
		return nome;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
	}
 
	public String getSexo() {
		return sexo;
	}
 
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
