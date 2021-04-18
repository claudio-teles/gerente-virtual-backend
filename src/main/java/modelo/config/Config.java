package main.java.modelo.config;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.enumeracao.Setor;

@NoArgsConstructor
@Data
@Entity
public class Config implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 55480322036293070L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConfig;
	@Column(nullable = false)
	private Setor setor;

}
