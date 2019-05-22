package com.facturacion.clientes.models;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table("cliente")
@Data
public class Cliente {
	@PrimaryKey
	private UUID id=UUID.randomUUID();
	@NotNull
	private String tipoCliente;
	@NotNull
	private String razonSocial;
	@NotNull
	private String tipoDocumento;
	@NotNull
	private String numeroDocumento;
	@NotNull
	private int telefono;
	@NotNull
	private String direccion;
	@NotNull
	private UUID ubigeo;
}
