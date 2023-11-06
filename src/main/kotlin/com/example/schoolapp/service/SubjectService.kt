package com.example.schoolapp.service

import com.example.schoolapp.model.Subject
import com.example.schoolapp.repository.StudentsRepository
import com.example.schoolapp.repository.SubjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SubjectService {
    @Autowired
    lateinit var subjectRepository: SubjectRepository

    @Autowired
    lateinit var studentsRepository: StudentsRepository

    fun list(): List<Subject> {
        return subjectRepository.findAll()
    }

    fun save(subject: Subject): Subject {
        try {
            subject.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            studentsRepository.findById(subject.studentsid)
                ?: throw Exception("Id del Student no encontrado")
            return subjectRepository.save(subject)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }


    fun update(subject: Subject): Subject {
        try {
            subjectRepository.findById(subject.id)
                ?: throw Exception("ID no existe")

            return subjectRepository.save(subject)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(subject: Subject): Subject {
        try {
            val response = subjectRepository.findById(subject.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nombre  = subject.nombre // un atributo del modelo
            }
            return subjectRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun delete(id: Long?): Boolean {
        try {
            val response = subjectRepository.findById(id)
                ?: throw Exception("ID no existe")
            subjectRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun listById (id:Long?):Subject?{
        return subjectRepository.findById(id)
    }
}
