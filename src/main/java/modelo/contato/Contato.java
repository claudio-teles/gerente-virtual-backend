package main.java.modelo.contato;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Contato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3509906099478636259L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idContato;
	private String celular;
	private String telefone;
	private String email;
	private String site;

}
