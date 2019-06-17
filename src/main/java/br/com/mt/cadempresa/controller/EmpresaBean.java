package br.com.mt.cadempresa.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

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
	
	private Empresa empresaSelecionada;

	/*
	 * Cria uma nova instãncia de Empresa para persistência no banco 
	 */
	public void preparaNovoCadastro() {
		empresaEdicao = new Empresa();
	}
	
	/*
	 * Metodo persiste uma empresa ao banco
	 */
	public void salvar() {
		this.empresaService.salvar(empresaEdicao);
		
		findAllEmpresas();
		
		messages.info("Nova empresa cadastrada.");
		
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msg", "frm:empresaTable"));
		
	}
	
	/*
	 * Metodo retorna uma lista com todas as empresas
	 */
	public void findAllEmpresas() {
		empresas = empresaRepository.findAll();
	}
	
	/*
	 *  Exclusão de empresa
	 */
	public void excluir() {
		empresaService.excluir(empresaSelecionada);
		empresaSelecionada = null;
		
		findAllEmpresas();
		
		messages.info("Empresa excluida!");
	}

	
	/*	Metodos Get and Set */
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

	public Empresa getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Empresa empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

}
