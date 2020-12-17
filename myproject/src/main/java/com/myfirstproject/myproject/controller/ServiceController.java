package com.myfirstproject.myproject.controller;

import java.util.ArrayList;
import java.util.List;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.myfirstproject.myproject.http.Pessoa;
import com.myfirstproject.myproject.repository.PessoaRepository;
import com.myfirstproject.myproject.repository.entity.PessoaEntity;

@Path("/service")
public class ServiceController {
	 	 
	public ServiceController(){
		
	}
	private final PessoaRepository repository = new PessoaRepository();
 
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(Pessoa pessoa){
		System.out.println ("Entrou no método cadastrar");

		PessoaEntity entity = new PessoaEntity();
 
		try {
 
			entity.setNome(pessoa.getNome());
			entity.setSexo(pessoa.getSexo());
 
			repository.Salvar(entity);
 
			return "Registro cadastrado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
 
	}

	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/alterar")
	public String Alterar(Pessoa pessoa){
 
		PessoaEntity entity = new PessoaEntity();
 
		try {
 
			entity.setCodigo(pessoa.getCodigo());
			entity.setNome(pessoa.getNome());
			entity.setSexo(pessoa.getSexo());
 
			repository.Alterar(entity);
 
			return "Registro alterado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao alterar o registro " + e.getMessage();
 
		}
 
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todasPessoas")
	public List<Pessoa> TodasPessoas(){
 
		List<Pessoa> pessoas =  new ArrayList<Pessoa>();
 
		List<PessoaEntity> listaEntityPessoas = repository.TodasPessoas();
 
		for (PessoaEntity entity : listaEntityPessoas) {
 
			pessoas.add(new Pessoa(entity.getCodigo(), entity.getNome(),entity.getSexo()));
		}
 
		return pessoas;
	}
 

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getPessoa/{codigo}")
	public Pessoa GetPessoa(@PathParam("codigo") Integer codigo){
 
		PessoaEntity entity = repository.GetPessoa(codigo);
 
		if(entity != null)
			return new Pessoa(entity.getCodigo(), entity.getNome(),entity.getSexo());
 
		return null;
	}
 

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{codigo}")	
	public String Excluir(@PathParam("codigo") Integer codigo){
 
		try {
 
			repository.Excluir(codigo);
 
			return "Registro excluido com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao excluir o registro! " + e.getMessage();
		}
 
	}
 
}
