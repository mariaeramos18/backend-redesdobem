package br.senac.rj.backend.controller;

import br.senac.rj.backend.entity.Doacao;
import br.senac.rj.backend.service.DoacaoService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/doacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoacaoController {
    
    private final DoacaoService service = new DoacaoService();

    @POST
    @Path("/salvar")
    public Response salvar(Doacao d) {
        return service.salvar(d);
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        return service.buscar(id);
    }

    @GET
    @Path("/listar")
    public Response listarTodas() {
        return service.listarTodas();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        return service.deletar(id);
    }

    @GET
    @Path("/doador/{doadorId}")
    public Response buscarPorDoador(@PathParam("doadorId") Long doadorId) {
        return service.buscarPorDoador(doadorId);
    }

    @GET
    @Path("/status/{status}")
    public Response buscarPorStatus(@PathParam("status") String status) {
        return service.buscarPorStatus(status);
    }
}