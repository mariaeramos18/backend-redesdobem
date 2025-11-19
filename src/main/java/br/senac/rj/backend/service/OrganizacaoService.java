package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.OrganizacaoDao;
import br.senac.rj.backend.entity.Organizacao;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Evento.
 */
public class OrganizacaoService {
    private final OrganizacaoDao dao = new OrganizacaoDao();

    public Response salvar(Organizacao doador) { 	/*Salvar e atualizar estão utilizando esse mesmo ngc*/
        Organizacao doadorSalvo = dao.salvar(doador);
        if (doadorSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar o doador.\"}")
            		.build();
        }
        return Response.ok(doadorSalvo).build();
    }

    public Response buscar(Long id) {
    	Organizacao EventoObtido = dao.buscarPorId(id);
        if (EventoObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Evento não encontrado.\"}")
            		.build();
        }
        return Response.ok(EventoObtido).build();
    }
}
