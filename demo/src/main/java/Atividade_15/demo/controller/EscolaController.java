package Atividade_15.demo.controller;


import Atividade_15.demo.model.Aluno;
import Atividade_15.demo.model.Curso;
import Atividade_15.demo.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.ok(escolaService.criarAluno(aluno));
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> adicionarCurso(@RequestBody Curso curso) {
        return ResponseEntity.ok(escolaService.criarCurso(curso));
    }

    @PostMapping("/alunos/{alunoId}/cursos/{cursoId}")
    public ResponseEntity<Void> matricularAlunoEmCurso(
            @PathVariable Long alunoId,
            @PathVariable Long cursoId) {
        escolaService.matricularAlunoEmCurso(alunoId, cursoId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/alunos/{alunoId}/cursos/{cursoId}")
    public ResponseEntity<Void> removerAlunoDoCurso(
            @PathVariable Long alunoId,
            @PathVariable Long cursoId) {
        escolaService.removerAlunoDoCurso(alunoId, cursoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/alunos/{alunoId}/cursos")
    public ResponseEntity<List<Curso>> listarCursosDeAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(escolaService.listarCursosDeAluno(alunoId));
    }

    @GetMapping("/cursos/{cursoId}/alunos")
    public ResponseEntity<List<Aluno>> listarAlunosDeCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(escolaService.listarAlunosDeCurso(cursoId));
    }
}
