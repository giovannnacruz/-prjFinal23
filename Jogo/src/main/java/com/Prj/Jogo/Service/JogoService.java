package com.Prj.Jogo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prj.Jogo.Entity.Jogo;
import com.Prj.Jogo.Repository.JogoRepository;



@Service
public class JogoService {
	private final JogoRepository jogoRepository;

	@Autowired
	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}

	public Jogo getJogoById(Long idjogo) {
		return jogoRepository.findById(idjogo).orElse(null);
	}

	public List<Jogo> getAllJogo() {
		return jogoRepository.findAll();
	}

	public void deletejogo(Long idjogo) {
		jogoRepository.deleteById(idjogo);
	}

	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}
	
	    }
