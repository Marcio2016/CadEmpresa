package br.com.mt.cadempresa.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.mt.cadempresa.model.Empresa;

public class EmpresaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Empresa findId(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<Empresa> findAll() {
		return manager.createQuery("from Empresa", Empresa.class).getResultList();
	}

	public Empresa save(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void delete(Empresa empresa) {
		empresa = findId(empresa.getId());
		manager.remove(empresa);
	}

}
