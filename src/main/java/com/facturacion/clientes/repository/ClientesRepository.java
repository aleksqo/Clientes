package com.facturacion.clientes.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.facturacion.clientes.models.Cliente;

public interface ClientesRepository extends CassandraRepository<Cliente, UUID> {
	
	@Query(allowFiltering=true)
	Cliente findByid(UUID id);
	
	@Query(allowFiltering=true)
	Cliente findByTipoCliente(String tipocliente);
	
	@Query(allowFiltering=true)
	Cliente findByRazonSocial(String razonSocial);
	
	@Query(allowFiltering=true)
	Cliente findByTipoDocumento(String tipoDocumento);
	
	@Query(allowFiltering=true)
	Cliente findByNumeroDocumento(String numeroDocumento);
	
	@Query(allowFiltering=true)
	Cliente findByDireccion(String direccion);

}
