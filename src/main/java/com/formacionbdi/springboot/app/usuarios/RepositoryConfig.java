package com.formacionbdi.springboot.app.usuarios;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Role;
import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;

/*
 * Clase de configuración que ayudará a añadir el "id" en el JSON del response de nuestra clase "Usuario"
 * 
 * RepositoryRestConfigurer
 * Es la interfaz que ayudará a la configuración
 */
@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

	// Método implementado de la interfaz "RepositoryRestConfigurer"
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// Indicamos las clases cuyos "ids" serán expuestos en el JSON del response de cada petición HTTP
		config.exposeIdsFor(Usuario.class, Role.class);
		//RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
	}
	
	
	

}
