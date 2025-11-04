package com.college.StudentData.controller;
import com.college.StudentData.nodel.Student;
import com.college.StudentData.repo.StudentRepository;
import com.college.StudentData.util.AppLogger;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {


@Autowired
private StudentRepository repo;


@GetMapping
public List<Student> getAll() {
return repo.findAll();
}


@PostMapping
public ResponseEntity<String> add(@Valid @RequestBody Student student) {
repo.save(student);
AppLogger.getInstance().log("New student added: " + student.getName());
return ResponseEntity.ok("Student added");
}


@PutMapping("/{id}")
public ResponseEntity<String> update(@PathVariable int id, @Valid @RequestBody Student student) {
if (!repo.existsById(id)) return ResponseEntity.notFound().build();
student.setId(id);
repo.save(student);
return ResponseEntity.ok("Student updated");
}


@DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable int id) {
if (!repo.existsById(id)) return ResponseEntity.notFound().build();
repo.deleteById(id);
return ResponseEntity.ok("Student deleted");
}
}