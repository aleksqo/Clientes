package com.facturacion.clientes.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.clientes.models.Cliente;
import com.facturacion.clientes.service.ClientesService;
@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
@RestController
@RequestMapping("/clientes")
public class ClientesController {
	@Autowired
	private ClientesService service;
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<Object> create(@Valid @RequestBody Cliente cliente){
		Cliente responseSave;
		responseSave=service.create(cliente);
		if(responseSave!=null) 
		{
			Cliente responseId=service.findByid(responseSave.getId());
			if(responseId!=null) {
				return new ResponseEntity<>(responseSave,HttpStatus.OK);
			}
			else 
			{
				return new ResponseEntity<>("No Esta Registrado!",HttpStatus.BAD_REQUEST);
			}
		}
		else 
		{
			return new ResponseEntity<Object>("Ya Existe Registro!",HttpStatus.BAD_REQUEST);
		}
		 
	}
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public ResponseEntity<Object> findAll(){
		List<Cliente> responsefindAll;
		responsefindAll=service.findAll();
		if (responsefindAll.isEmpty()) {
			return new ResponseEntity<>("No hay ninguna Clientes para Listar",HttpStatus.OK);
		}
			return new ResponseEntity<>(responsefindAll,HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public ResponseEntity<Object> update(@Valid @RequestBody Cliente clientes){
		Cliente responseUpdate;
		responseUpdate=service.update(clientes.getId(), clientes);
		if (responseUpdate!=null) {
			return new ResponseEntity<Object>(responseUpdate,HttpStatus.OK);
		}
			return new ResponseEntity<Object>("Error al actualizar",HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	public ResponseEntity<Object> updateAll(@Valid @RequestBody Cliente clientes){
		Cliente responseUpdate;
		responseUpdate=service.update(clientes.getId(), clientes);
		if (responseUpdate!=null) {
			return new ResponseEntity<>(responseUpdate,HttpStatus.OK);
		}
			return new ResponseEntity<>("Error al actualizar",HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Object> findById(@PathVariable UUID id){
		Cliente responseFindById;
		responseFindById=service.findByid(id);
		if (responseFindById!=null) {
			return new ResponseEntity<>(responseFindById,HttpStatus.OK);
		}
			return new ResponseEntity<>("No Hay Datos",HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable UUID id){
		Cliente responseDelete;
		responseDelete=service.findByid(id);
		
		if (responseDelete != null) {
			service.delete(id);
			return new ResponseEntity<Object>("Eliminado!",HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Object>("No se pudo eleminar",HttpStatus.BAD_REQUEST);
		}
	}
}
