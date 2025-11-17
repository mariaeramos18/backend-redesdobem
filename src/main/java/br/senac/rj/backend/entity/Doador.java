package br.senac.rj.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 * @author reinaldo.jose
 * Entidade que representa a tabela doador.
 */
@Entity
@Table(name = "doador")
@Data
public class Doador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doador_id;

    @Column(length = 150, nullable = false)
    private String nome;
    
//    @Column(length = 20, nullable = false)
//    private String cpf_cnpj;
//    
//    @Column(length = 100, nullable = false)
//    private String cidade;
//    
//    @Column(nullable = false)
//    private Integer total_doacoes;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
