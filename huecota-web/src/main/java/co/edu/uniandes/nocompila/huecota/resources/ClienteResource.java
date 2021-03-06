/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.resources;

import co.edu.uniandes.nocompila.huecota.dtos.ClienteDetailDTO;
import co.edu.uniandes.nocompila.huecota.ejb.ClienteLogic;
import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;
import co.edu.uniandes.nocompila.huecota.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author c.martinezc1
 */
@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class ClienteResource {
 
    @Inject
    ClienteLogic clienteLogic;
    
    private static final Logger LOGGER = Logger.getLogger(ClienteResource.class.getName());

    /**
     * POST http://localhost:8080/huecota-web/api/clientes
     *
     * @param cliente correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "HuecoDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST
    public ClienteDetailDTO createCliente(ClienteDetailDTO cliente) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        ClienteEntity entity = cliente.toEntity();
        // Invoca la lógica para crear el cliente nuev
        ClienteEntity nuevoCliente = clienteLogic.createCliente(entity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new ClienteDetailDTO(nuevoCliente);
    }
    
    /**
     * GET para todas los clientes.
     * http://localhost:8080/huecota-web/api/clientes
     *
     * @return la lista de todas los clientes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<ClienteDetailDTO> getClientes() throws BusinessLogicException {
        return listEntity2DetailDTO(clienteLogic.getClientes());
    }
    
     /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos ClienteEntity a una lista de
     * objetos CLienteDetailDTO (json)
     *
     * @param entityList corresponde a la lista de clientes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de clientes en forma DTO (json)
     */
    private List<ClienteDetailDTO> listEntity2DetailDTO(List<ClienteEntity> entityList) {
        List<ClienteDetailDTO> list = new ArrayList<ClienteDetailDTO>();
        for (ClienteEntity entity : entityList) {
            list.add(new ClienteDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * GET para un cliente.
     * http://localhost:8080/huecota-web/api/clientes/{id}
     *
     * @param id
     * @return el cliente en objeto json DTO.
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public ClienteDetailDTO getCliente(@PathParam("id") Long id) throws BusinessLogicException{
        ClienteDetailDTO dto = new ClienteDetailDTO(clienteLogic.getCliente(id));
        return dto;
    }
    
     /**
     * PUT http://localhost:8080/huecota-web/api/clientes/{id} 
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde al cliente a actualizar.
     * @param cliente corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return El cliente actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de el cliente a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public ClienteDetailDTO updateCliente(@PathParam("id") Long id, ClienteDetailDTO cliente) throws BusinessLogicException, UnsupportedOperationException {
          cliente.setId(id);
        ClienteEntity entity = clienteLogic.getCliente(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /books/" + id + " no existe.", 404);
        }
        return new ClienteDetailDTO(clienteLogic.updateCliente(id, cliente.toEntity()));
    }
    
    /**
     * DELETE http://localhost:8080/huecota-web/api/clientes/{id}
     *
     * @param id corresponde al cliente a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de el cleitne a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCliente(@PathParam("id") Long id) throws BusinessLogicException {
         clienteLogic.deleteCliente(id);
    }
    
    @Path("{idBook: \\d+}/reviews")
    public Class<PuntoResource> getPuntoResource(@PathParam("idCliente") Long clienteId) {
        try{
          ClienteEntity entity = clienteLogic.getCliente(clienteId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /books/" + clienteId + "/reviews no existe.", 404);
        }
        return PuntoResource.class;  
        }
        catch(Exception e){
            return null;
        }
        
    }
}
