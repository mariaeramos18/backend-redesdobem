package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.DoacaoDao;
import br.senac.rj.backend.entity.Doacao;
import jakarta.ws.rs.core.Response;

public class DoacaoService {
    
    private final DoacaoDao dao = new DoacaoDao();

    public Response salvar(Doacao d) {
        Doacao doacaoSalva = dao.salvar(d);
        if (doacaoSalva == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"erro\":\"Não foi possível salvar a doação.\"}")
                    .build();
        }
        return Response.ok(doacaoSalva).build();
    }
    
    public Response buscar(Long id) {
        Doacao doacaoObtida = dao.buscarPorId(id);
        if (doacaoObtida == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"erro\":\"Doação não encontrada.\"}")
                    .build();
        }
        return Response.ok(doacaoObtida).build();
    }

	public Response listarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	public Response deletar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response buscarPorDoador(Long doadorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response buscarPorStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}


}