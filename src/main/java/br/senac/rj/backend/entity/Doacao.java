package br.senac.rj.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "DOACAO")
@Data
public class Doacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DoacaoID")
    private Long doacaoId;

    @Column(name = "DoadorID", nullable = false)
    private Long doadorId;

    @Column(name = "DataCadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "DataAtualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "StatusDoacao", length = 50)
    private String statusDoacao;

    @Column(name = "Observacoes", columnDefinition = "TEXT")
    private String observacoes;

    @Column(name = "QuantidadeAvaliada")
    private Double quantidadeAvaliada;

    @Column(name = "UnidadeMedida", length = 20)
    private String unidadeMedida;

    @Column(name = "CondicoesArmazenamento", columnDefinition = "TEXT")
    private String condicoesArmazenamento;

    @Column(name = "MotivoCancelamento", columnDefinition = "TEXT")
    private String motivoCancelamento;

    @Column(name = "DataEntrega")
    private LocalDateTime dataEntrega;

    @Column(name = "LocalEntregaColeta", columnDefinition = "TEXT")
    private String localEntregaColeta;

    @PrePersist
    protected void onCreate() {
        dataCadastro = LocalDateTime.now();
        if (statusDoacao == null || statusDoacao.isEmpty()) {
            statusDoacao = "PENDENTE";
        }
    }

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }
}