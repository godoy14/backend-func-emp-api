package com.func.cont.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Desempenho {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String titulo;
	
	@NotBlank
	@Column(nullable = false)
	private String data;
	
	@NotBlank
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne
	// @JoinColumn(nullable = false)
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

}
