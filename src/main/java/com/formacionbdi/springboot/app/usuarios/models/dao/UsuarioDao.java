package com.formacionbdi.springboot.app.usuarios.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;
/*
 * @RepositoryRestResource
 * Anotación propia de la dependencia "spring-boot-starter-data-rest"
 * Crea un CRUD automático con el servicio y el controller por debajo
 * 
 * path = "usuarios"
 * Asignamos el endpoint donde expondremos el recurso.
 */
@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {
	/*
	 * Por medio de este "Query method name" se ejecutará por detrás la consulta JPQL
	 * 
	 * @@RestResource
	 * El endpoint que por defecto es "/findByUsername", ahora se personaliza a "/buscar-username"
	 * 
	 * @Param("nombre")
	 * El param que por defecto es "username", ahora se personaliza a "nombre"
	 */
	@RestResource(path = "buscar-username")
	public Usuario findByUsername(@Param("nombre") String username);
		
	@Query(value = "select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);
	

}
