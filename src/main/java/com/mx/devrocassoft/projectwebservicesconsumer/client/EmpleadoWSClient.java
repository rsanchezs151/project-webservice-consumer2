/**
 * 
 */
package com.mx.devrocassoft.projectwebservicesconsumer.client;

import java.time.LocalDateTime;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.mx.devrocassoft.projectwebservicesconsumer.dto.EmpleadoDTO;

/**
 * @author ROCASS
 *Clase que permite consumir el webservice de empleados.
 */
public class EmpleadoWSClient {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//:::::::::::::::::::::.. GET ..:::::::::::::::::://
		
		/*
		 * Client client = ClientBuilder.newClient(); WebTarget webtarget =
		 * client.target(
		 * "http://localhost:8080/project-webservices2/devpredator/empleadosWS/").path(
		 * "consulatEmpleadosPorId").path("10000");
		 * 
		 * Invocation.Builder invocationBuilder =
		 * webtarget.request(MediaType.APPLICATION_JSON); Response response =
		 * invocationBuilder.get();
		 * 
		 * if(response.getStatus() == 204) {
		 * System.out.println("No se encontró el empleado con el numero: "); }
		 * if(response.getStatus() == 200) { EmpleadoDTO empleado =
		 * response.readEntity(EmpleadoDTO.class);
		 * 
		 * System.out.println("Nombre del empleado = " + empleado.getNombre()); }
		 */
		
		//:::::::::::::::::::::.. POST ..:::::::::::::::::://
		
		Client client = ClientBuilder.newClient();
		WebTarget webtarget =
				 client.target(
				  "http://localhost:8080/project-webservices2/devpredator/empleadosWS/").path("guardarEmpleado");
		EmpleadoDTO emp = new EmpleadoDTO();
		emp.setNombre("Ramiro");
		emp.setPrimerApellido("Pérez");
		emp.setSegundoApellido("Donatello");
		emp.setEdad(38);
		emp.setFechaCreacion(LocalDateTime.now());
		
		
		Invocation.Builder invocationBuilder = webtarget.request(MediaType.APPLICATION_JSON); 
		Response response = invocationBuilder.post(Entity.entity(emp,MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 200) {
			String error = response.readEntity(String.class);
			System.out.println(error);
		}
		
		if(response.getStatus() == 200) {
			EmpleadoDTO empleadoDto = response.readEntity(EmpleadoDTO.class);
			
			System.out.println(empleadoDto.getNombre());
			System.out.println(empleadoDto.getFechaCreacion());
		}
		
		
		
	}
}
