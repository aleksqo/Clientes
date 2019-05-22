package com.facturacion.clientes.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.clientes.models.Cliente;
import com.facturacion.clientes.repository.ClientesRepository;

@Service
public class ClientesService {
	@Autowired
	private ClientesRepository repository;
	
	public Cliente create(Cliente cliente) {
		if (this.exits(cliente)) {
			return null;
		}
		return repository.save(cliente);
	}
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente update(Cliente cliente) {
		return repository.save(cliente);
	}
	
	//Update                                   
	public Cliente update(UUID id,Cliente clientes)      
	{   
		Cliente _exists_tipocliente = this.findByTipoCliente(clientes.getTipoCliente());
		Cliente _exists_razonsocial = this.findByRazonSocial(clientes.getRazonSocial());
		Cliente _exists_tipodoc = this.findByTipodocumento(clientes.getTipoDocumento());
		Cliente _exists_numerodoc = this.findByNumerodocumento(clientes.getNumeroDocumento());
		Cliente _exists_direccion = this.findByDireccion(clientes.getDireccion());
		
		if(_exists_tipocliente!=null)
		{
			if(_exists_tipocliente.getId().equals(id))
			{
				return repository.save(clientes);
			}
			return null;
		}
		
		if(_exists_razonsocial!=null)
		{
			if(_exists_razonsocial.getId().equals(id))
			{
				return repository.save(clientes);
			}
			return null;
		}

		if(_exists_tipodoc!=null)
		{
			if(_exists_tipodoc.getId().equals(id))
			{
				return repository.save(clientes);
			}
			return null;
		}

		if(_exists_numerodoc!=null)
		{
			if(_exists_numerodoc.getId().equals(id))
			{
				return repository.save(clientes);
			}
			return null;
		}

		if(_exists_direccion!=null)
		{
			if(_exists_direccion.getId().equals(id))
			{
				return repository.save(clientes);
			}
			return null;
		}
		
		return repository.save(clientes);          
	}
	
	
	public Cliente findByid(UUID id){
		return repository.findByid(id);
	}
	
	public void delete(UUID id) {
		repository.deleteById(id);
	}
	
	/*Validaciones*/
	
	public Boolean exits(Cliente cliente) {
		Boolean _exists=false;
		if (this.findByTipoCliente(cliente.getTipoCliente())!=null) {
			return _exists=true;
		}
		if (this.findByRazonSocial(cliente.getRazonSocial())!=null) {
			return _exists=true;
		}
		if (this.findByTipodocumento(cliente.getTipoDocumento())!=null) {
			return _exists=true;
		}
		if (this.findByNumerodocumento(cliente.getNumeroDocumento())!=null) {
			return _exists=true;
		}
		if (this.findByDireccion(cliente.getDireccion())!=null) {
			return _exists=true;
		}
		return _exists;
	}
	
	public Cliente findByTipoCliente(String tipocliente) {
		return repository.findByTipoCliente(tipocliente);
	}
	 
	public Cliente findByRazonSocial(String razonsocial) {
		return repository.findByRazonSocial(razonsocial);
	}
	
	public Cliente findByTipodocumento(String tipodocumento) {
		return repository.findByTipoDocumento(tipodocumento);
	}
	
	public Cliente findByNumerodocumento(String numerodocumneto) {
		return repository.findByNumeroDocumento(numerodocumneto);
	}
	
	public Cliente findByDireccion(String direccion) {
		return repository.findByDireccion(direccion);
	}
}
