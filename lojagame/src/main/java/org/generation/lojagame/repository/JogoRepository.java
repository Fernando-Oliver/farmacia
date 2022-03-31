package org.generation.lojagame.repository;

import java.util.List;

import org.generation.lojagame.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long>{
	
	public List<Jogo> findAllByNomeContainingIgnoreCase (String jogo);

}
