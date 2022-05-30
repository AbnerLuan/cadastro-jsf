package br.com.cadastro_jsf.repository;

import br.com.cadastro_jsf.model.Usuario;

public interface IDaoUsuario {

	Usuario consultarUsuario(String nome, String senha);

}
