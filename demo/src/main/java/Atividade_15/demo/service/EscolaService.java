package Atividade_15.demo.service;

import Atividade_15.demo.model.Aluno;
import Atividade_15.demo.model.Curso;
import Atividade_15.demo.repository.AlunoRepository;
import Atividade_15.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public void matricularAlunoEmCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        aluno.getCursos().add(curso);
        alunoRepository.save(aluno);
    }

    @Transactional
    public void removerAlunoDoCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        aluno.getCursos().remove(curso);
        alunoRepository.save(aluno);
    }

    public List<Curso> listarCursosDeAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        return List.copyOf(aluno.getCursos());
    }

    public List<Aluno> listarAlunosDeCurso(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        return List.copyOf(curso.getAlunos());
    }
}
