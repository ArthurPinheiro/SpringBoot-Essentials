package br.com.devdojo.endpoint;

import br.com.devdojo.error.ResourceNotFoundException;
import br.com.devdojo.model.Student;
import br.com.devdojo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController // Já vem com o responseBody. Ou seja, já devolve o json como resultado, no corpo da requisição
@RequestMapping("v1")
public class StudentEndpoint {

    private final StudentRepository dao;

    public StudentEndpoint(){this(null);}

    @Autowired
    private StudentEndpoint(StudentRepository dao){
        this.dao = dao;
    }

    @GetMapping(path = "protected/students")
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(dao.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "protected/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
        verifyIfStudentExists(id);
        Student student = dao.findOne(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping(path = "protected/students/findByName/{name}")
    public ResponseEntity<?> findStudentsByName(@PathVariable String name){
        dao.findByNameIgnoreCaseContaining(name);
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @PostMapping(path = "admin/students")
    public ResponseEntity<?> save(@Valid @RequestBody Student student){
        dao.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping(path = "admin/students")
    public ResponseEntity<?> update(@RequestBody Student student){
        verifyIfStudentExists(student.getId());
        dao.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping(path = "admin/students/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        verifyIfStudentExists(id);
        dao.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfStudentExists(Long id){
        if(dao.findOne(id) == null){
            throw new ResourceNotFoundException("Student not found for ID: " + id);
        }
    }
}
