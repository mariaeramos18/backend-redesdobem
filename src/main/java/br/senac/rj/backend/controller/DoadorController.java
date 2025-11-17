package br.senac.rj.backend.controller;

import br.senac.rj.backend.entity.Doador;
import br.senac.rj.backend.service.DoadorService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que é um controller REST (recurso JAX-RS) da sua aplicação, responsável por expor endpoints HTTP relacionados à entidade Evento.
 */
@Path("/doador")					/*TROCAR PELO NOME DA CLASSE UTILIZAR O CTRL+F COM CASE SENSITIVE*/
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoadorController {						
    private final DoadorService service = new DoadorService();

    @POST
    @Path("/salvar")		/*Salvar e atualizar estão utilizando esse mesmo ngc*/
    public Response salvar(Doador a) {
        return service.salvar(a);
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        return service.buscar(id);
    }
}
