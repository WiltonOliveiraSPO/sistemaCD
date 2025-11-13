package com.seuapp.armazenamento.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categoria")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SIG_CATEG", length = 2)
    private String sigla; // char(2) → String

    @Column(name = "DES_CATEG", length = 30, nullable = false)
    private String descricao;

	public Object getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDescricao(Object descricao2) {
		// TODO Auto-generated method stub
		
	}
}