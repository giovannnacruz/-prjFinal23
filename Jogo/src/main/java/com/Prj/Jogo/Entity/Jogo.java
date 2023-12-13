package com.Prj.Jogo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="tb_Jogo")
public class Jogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idjogo;

	private String nomejogo;
	
	private String generojogo;
	
	private String integrantes;
	
	private String squad;
	
	private String url;
	
	private String thumbnail;
	
	public Jogo() {
		
	}

	public Jogo(Long idjogo, String nomejogo, String generojogo, String integrantes ) {
		super();
		this.idjogo = idjogo;
		this.nomejogo = nomejogo; 
		this.generojogo = generojogo;
		this.integrantes = integrantes;
	}
	public Long getidjogo() {
		return idjogo;
	}

	public void setidjogo(Long idjogo) {
		this.idjogo = idjogo;
	}

	public String getnomejogo() {
		return nomejogo;
	}

	public void setnomejogo (String nomejogo)  {
		this.nomejogo = nomejogo;
	}	
	// aqui
	public String getgenerojogo() {
		return generojogo;
	}

	public void setgenerojogo(String generojogo) {
		this.generojogo = generojogo;
	}
	public String getintegrantes() {
		return integrantes;
	}

	public void setintegrantes(String integrantes) {
		this.integrantes = integrantes;
	}

	public String getSquad() {
		return squad;
	}

	public void setSquad(String squad) {
		this.squad = squad;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
}

