package Atividade_15.demo.repository;

import Atividade_15.demo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByEmail(String email); // Para busca por e-mail
}
