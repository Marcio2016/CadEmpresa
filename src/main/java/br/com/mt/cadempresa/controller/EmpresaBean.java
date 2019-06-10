package br.com.mt.cadempresa.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mt.cadempresa.model.Empresa;
import br.com.mt.cadempresa.repository.EmpresaRepository;

@Named
@ViewScoped
public class EmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepository empresaRepository;
	
	private List<Empresa> empresas;
	
	public void findAllEmpresas(){
		empresas = empresaRepository.findAll();
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}	
	

}
