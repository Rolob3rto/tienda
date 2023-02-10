package com.rolob3rto.springprojects.tienda;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rolob3rto.springprojects.tienda.model.Permission;
import com.rolob3rto.springprojects.tienda.model.User;
import com.rolob3rto.springprojects.tienda.repository.PermissionRepository;
import com.rolob3rto.springprojects.tienda.repository.UserRepository;



@SpringBootTest
class TiendaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	UserRepository usuarioRepository;

	@Autowired
	PermissionRepository permisoRepository;

	@Autowired
	PasswordEncoder encoder;

	@Test
	void crearUsersTest() {
		User usuario1 = new User();
		usuario1.setCodigo(1);
		usuario1.setNombre("usuario1");
		usuario1.setEmail("usuario1@gmail.com");
		usuario1.setPassword(encoder.encode("1234"));

		User usuario2 = new User();
		usuario2.setCodigo(2);
		usuario2.setNombre("usuario2");
		usuario2.setEmail("usuario2@gmail.com");
		usuario2.setPassword(encoder.encode("1234"));

		User usuario3 = new User();
		usuario3.setCodigo(3);
		usuario3.setNombre("usuario3");
		usuario3.setEmail("usuario3@gmail.com");
		usuario3.setPassword(encoder.encode("1234"));

		User usuario4 = new User();
		usuario4.setCodigo(4);
		usuario4.setNombre("usuario4");
		usuario4.setEmail("usuario4@gmail.com");
		usuario4.setPassword(encoder.encode("1234"));

		Permission permisoAdmin = new Permission();
		permisoAdmin.setId(1);
		permisoAdmin.setName("ADMIN");

		Permission permisoPedidos = new Permission();
		permisoPedidos.setId(2);
		permisoPedidos.setName("PEDIDOS");

		Permission permisoClientes = new Permission();
		permisoClientes.setId(3);
		permisoClientes.setName("CLIENTES");

		Permission permisoCesta = new Permission();
		permisoCesta.setId(4);
		permisoCesta.setName("CESTA");

		Permission permisoVendedores = new Permission();
		permisoVendedores.setId(5);
		permisoVendedores.setName("VENDEDORES");

		Permission permisoProductos = new Permission();
		permisoProductos.setId(6);
		permisoProductos.setName("PRODUCTOS");

		Permission permisoDepartamentos = new Permission();
		permisoDepartamentos.setId(7);
		permisoDepartamentos.setName("DEPARTAMENTOS");

		List<Permission> listaPermissionsTodos = new ArrayList<Permission>();
		listaPermissionsTodos.add(permisoAdmin);		

		List<Permission> listaPermissionsUser2 = new ArrayList<Permission>();
		listaPermissionsUser2.add(permisoPedidos);
		listaPermissionsUser2.add(permisoProductos);
		listaPermissionsUser2.add(permisoCesta);

		List<Permission> listaPermissionsUser3 = new ArrayList<Permission>();
		listaPermissionsUser3.add(permisoPedidos);
		listaPermissionsUser3.add(permisoClientes);
		listaPermissionsUser3.add(permisoProductos);
		listaPermissionsUser3.add(permisoCesta);

		usuario1.setPermisos(listaPermissionsTodos);
		usuario2.setPermisos(listaPermissionsUser2);
		usuario3.setPermisos(listaPermissionsUser3);

		permisoRepository.save(permisoAdmin);
		permisoRepository.save(permisoPedidos);
		permisoRepository.save(permisoClientes);
		permisoRepository.save(permisoProductos);
		permisoRepository.save(permisoCesta);
		permisoRepository.save(permisoDepartamentos);
		permisoRepository.save(permisoVendedores);

		usuarioRepository.save(usuario1);
		User saveUser2 = usuarioRepository.save(usuario2);
		usuarioRepository.save(usuario3);
		usuarioRepository.save(usuario4);

		assertTrue(usuario2.getPassword().equalsIgnoreCase(saveUser2.getPassword()));

	}

}