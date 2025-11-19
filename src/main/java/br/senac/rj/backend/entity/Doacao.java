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

    @Column(length = 100, nullable = false)
    private String tipo_alimento;

    @Column(nullable = false)
    private Integer quantidade;
    
    @Column(nullable = false)
    private String unidade;
    
//    @Column(columnDefinition = "DATETIME")
//    private byte data_cadastro;   
    
    @ManyToOne
    @JoinColumn(name = "doador_id")
    private Doador doador;
}