package br.com.mt.cadempresa.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mt.cadempresa.model.Empresa;
import br.com.mt.cadempresa.model.TipoEmpresa;
import br.com.mt.cadempresa.repository.EmpresaRepository;
import br.com.mt.cadempresa.service.CadastroEmpresaService;
import br.com.mt.cadempresa.util.FacesMessages;

@Named
@ViewScoped
public class EmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private EmpresaRepository empresaRepository;
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private CadastroEmpresaService empresaService;
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private FacesMessages messages;

	private List<Empresa> empresas;

	private Empresa empresaEdicao = new Empresa();


	public void preparaNovoCadastro() {
		empresaEdicao = new Empresa();
	}
	
	public void salvar() {
		empresaService.salvar(empresaEdicao);
		findAllEmpresas();
		messages.info("Empresa cadastrada");
		
	}
	
	public void findAllEmpresas() {
		empresas = empresaRepository.findAll();
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public TipoEmpresa[] getTiposEmpresas() {
		return TipoEmpresa.values();
	}

	public Empresa getEmpresaEdicao() {
		return empresaEdicao;
	}

	public void setEmpresaEdicao(Empresa empresaEdicao) {
		this.empresaEdicao = empresaEdicao;
	}

}
