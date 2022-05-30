package br.com.cadastro_jsf.repository;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import br.com.cadastro_jsf.model.Usuario;
import br.com.cadastro_jsf.service.UsuarioService;

@Named
public class IDaoUsuarioImpl implements IDaoUsuario {

	@Override
	public Usuario consultarUsuario(String nome, String senha) {

		Usuario usuario = null;

		EntityManager entityManager = UsuarioService.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {
			usuario = (Usuario) entityManager
					.createQuery("SELECT u from Usuario u where u.nome = :nome and u.senha = :senha")
					.setParameter("nome", nome).setParameter("senha", senha).getSingleResult();

			transaction.commit();
			entityManager.close();

			return usuario;
		} catch (NoResultException exception) {
			return null;
		}

	}
}
