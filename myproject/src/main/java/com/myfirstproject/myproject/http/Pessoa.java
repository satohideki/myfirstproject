package com.myfirstproject.myproject.http;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pessoa {
 
	private UUID codigo;
	private String nome;
	private String sexo;
 
	public Pessoa(){
 
	}
 
	public Pessoa(UUID codigo, String nome, String sexo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sexo = sexo;
	}
 
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
	public String getSexo(){
		return sexo;
	}
	public void setSexo(String sexo){
		this.sexo =  sexo;
	}	
 
}