package com.example.schoolapp.controller

import com.example.schoolapp.model.Students
import com.example.schoolapp.model.Subject
import com.example.schoolapp.service.SubjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/Subject")   //endpoint
class SubjectController {
    @Autowired
    lateinit var subjectService: SubjectService

    @GetMapping
    fun list ():List <Subject>{
        return subjectService.list()

    }
    @PostMapping
    fun save (@RequestBody subject: Subject):ResponseEntity<Subject>{
        return ResponseEntity(subjectService.save(subject), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody subject: Subject):ResponseEntity<Subject>{
        return ResponseEntity(subjectService.update(subject), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody subject: Subject):ResponseEntity<Subject>{
        return ResponseEntity(subjectService.updateName(subject), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(subjectService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return subjectService.delete(id)
    }
}