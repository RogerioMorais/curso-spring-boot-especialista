package io.github.cursodsousa.sbootkeycloak;

import io.github.cursodsousa.sbootkeycloak.model.Curso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @GetMapping("java")
    public ResponseEntity<Curso> cursoJava(){
        return ResponseEntity.ok(new Curso(UUID.randomUUID(), "Java"));
    }

    @GetMapping("spring-boot")
    public ResponseEntity<Curso> cursoSpringBoot(){
        return ResponseEntity.ok(new Curso(UUID.randomUUID(), "Spring Boot"));
    }

    @GetMapping("exclusivos")
    public ResponseEntity<List<Curso>> cursosExclusivos(){
        Curso angular = new Curso(UUID.randomUUID(), "Angular");
        Curso react = new Curso(UUID.randomUUID(), "React");
        Curso view = new Curso(UUID.randomUUID(), "View");

        return ResponseEntity.ok(List.of(angular, react, view));
    }

    @GetMapping("abertos")
    public ResponseEntity<List<Curso>> cursosAbertos(){
        Curso logica = new Curso(UUID.randomUUID(), "Lógica de Programação");
        Curso sql = new Curso(UUID.randomUUID(), "SQL");

        return ResponseEntity.ok(List.of(logica, sql));
    }

}
