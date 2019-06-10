package br.com.mt.cadempresa.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.mt.cadempresa.model.Empresa;
import br.com.mt.cadempresa.repository.EmpresaRepository;
import br.com.mt.cadempresa.util.Transacional;

public class CadastroEmpresaService implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepository empresasRepository;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresasRepository.save(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresasRepository.delete(empresa);
	}
}
