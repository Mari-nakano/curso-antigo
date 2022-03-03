package com.brq.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brq.models.UsuarioModel;
import com.brq.repositories.UsuarioRepository;
import com.brq.security.CredencialSecurityModel;


@Service
public class CredentialDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuarioModel usuario = this.usuarioRepository.findByEmail( email );
		
		if (usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new CredencialSecurityModel (usuario.getId(), usuario.getEmail(), 
				usuario.getSenha(), usuario.getNome(),  usuario.getPerfis() );
	}
}

