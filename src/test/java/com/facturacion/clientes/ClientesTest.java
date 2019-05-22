package com.facturacion.clientes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ClientesTest {
	@Autowired
	MockMvc mockMvc;
			
	@Test
	public void Create_Empty_Error() throws Exception
	{
		String body ="{}";
		this.mockMvc.perform(
				post("/clientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(body)
				).andExpect(status().isBadRequest());
	}
	
	@Test
	public void Create_FullData_ok() throws Exception
	{
		String body ="{\"id\":\"982ea674-f46c-40da-b9d5-680b1038570c\","
				+ "\"tipoCliente\":\"Natural\","
				+ "\"razonSocial\":\"Rober\","
				+ "\"tipoDocumento\":\"DNI\","
				+ "\"numeroDocumento\":\"71807225\","
				+ "\"telefono\":\"922007190\","
				+ "\"direccion\":\"Jr. Ayacucho 980\","
				+ "\"ubigeo\":\"5864\"}";
		this.mockMvc.perform(
				post("/clientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(body)
				).andExpect(status().isOk());
	}
	
	@Test
	public void Create_DuplicaName_Error() throws Exception
	{
		String body ="{\"id\":\"982ea674-f46c-40da-b9d5-680b1038570c\","
				+ "\"tipoCliente\":\"Natural\","
				+ "\"razonSocial\":\"Rober\","
				+ "\"tipoDocumento\":\"DNI\","
				+ "\"numeroDocumento\":\"71807225\","
				+ "\"telefono\":\"922007190\","
				+ "\"direccion\":\"Jr. Ayacucho 980\","
				+ "\"ubigeo\":\"5864\"}";
		this.mockMvc.perform(
				post("/clientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(body)
				).andExpect(status().isBadRequest());
	}
	
	@Test
	public void Update_FullData_ok() throws Exception
	{
		String body ="{\"id\":\"982ea674-f46c-40da-b9d5-680b1038570c\","
				+ "\"tipoCliente\":\"Natural\","
				+ "\"razonSocial\":\"Rober\","
				+ "\"tipoDocumento\":\"DNI\","
				+ "\"numeroDocumento\":\"71807225\","
				+ "\"telefono\":\"922007190\","
				+ "\"direccion\":\"Jr. Ayacucho 980\","
				+ "\"ubigeo\":\"5864\"}";
		this.mockMvc.perform(
				put("/clientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(body)
				).andExpect(status().isOk());
	}
	
	@Test
	public void Update_JustTipoCliente_ok() throws Exception
	{
		String body ="{\"id\":\"982ea674-f46c-40da-b9d5-680b1038570c\",\"tipoCliente\":\"Natural\"}";
		this.mockMvc.perform(
				patch("/clientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(body)
				).andExpect(status().isOk());
	}
	
	@Test
	public void List_Clientes_ok() throws Exception
	{
		this.mockMvc.perform(
				get("/clientes")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());
	}
	
	@Test
	public void Delete_Exists_ok() throws Exception
	{
		this.mockMvc.perform(
				delete("/clientes/{id}","982ea674-f46c-40da-b9d5-680b1038570c")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());
	}
	
	@Test
	public void Delete_NoExists_Error() throws Exception
	{
		this.mockMvc.perform(
				delete("/clientes/{id}","982ea674-f46c-40da-b9d5-680b1038570c")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isBadRequest());
	}
}
