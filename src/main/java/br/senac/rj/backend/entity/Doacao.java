package br.senac.rj.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 * @author mariaeramos18
 * Entidade que representa a tabela doacao.
 */

@Entity
@Table(name = "doacao")
@Data
public class Doacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer doacao_id;

    @ManyToOne
    @JoinColumn(name = "doador_id")
    private Doador doador;

    @Column(length = 100, nullable = false)
    private String tipo_alimento;

    
//    @PrePersist
//    protected void onCreate() {
//        dataCadastro = LocalDateTime.now();
//        if (statusDoacao == null || statusDoacao.isEmpty()) {
//            statusDoacao = "PENDENTE";
//        }
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        dataAtualizacao = LocalDateTime.now();
//    }
}