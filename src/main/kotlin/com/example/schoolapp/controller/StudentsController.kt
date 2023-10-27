package com.example.schoolapp.controller

import com.example.schoolapp.model.Students
import com.example.schoolapp.service.StudentsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/Students")   //endpoint
class StudentsController {
    @Autowired
    lateinit var studentsService: StudentsService

    @GetMapping
    fun list ():List <Students>{
        return studentsService.list()

    }
    @PostMapping
    fun save (@RequestBody students: Students):ResponseEntity<Students>{
        return ResponseEntity(studentsService.save(students), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody students: Students):ResponseEntity<Students>{
        return ResponseEntity(studentsService.update(students), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody students: Students):ResponseEntity<Students>{
        return ResponseEntity( studentsService.updateName(students), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(studentsService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return studentsService.delete(id)
    }
}
