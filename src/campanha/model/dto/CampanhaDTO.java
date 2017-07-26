package campanha.model.dto;

import java.util.Date;

public class CampanhaDTO {

	private Integer id;
	private String nomeCampanha;
	private Integer idTimeCoracao;
	private String inicio;
	private String fim;
	

	public CampanhaDTO(Integer id, String nomeCampanha, Integer idTimeCoracao, String inicio, String fim) {
		this.id = id;
		this.nomeCampanha = nomeCampanha;
		this.idTimeCoracao = idTimeCoracao;
		this.inicio = inicio;
		this.fim = fim;
	}


	public CampanhaDTO() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomeCampanha() {
		return nomeCampanha;
	}


	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}


	public Integer getIdTimeCoracao() {
		return idTimeCoracao;
	}


	public void setIdTimeCoracao(Integer idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}


	public String getInicio() {
		return inicio;
	}


	public void setInicio(String inicio) {
		this.inicio = inicio;
	}


	public String getFim() {
		return fim;
	}


	public void setFim(String fim) {
		this.fim = fim;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampanhaDTO other = (CampanhaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
