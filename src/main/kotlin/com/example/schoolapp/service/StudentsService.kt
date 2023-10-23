package com.example.schoolapp.service

import com.example.schoolapp.model.Students
import com.example.schoolapp.repository.StudentsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class StudentsService {
    @Autowired
    lateinit var studentsRepository: StudentsRepository

    fun list ():List<Students>{
        return studentsRepository.findAll()
    }
    fun save(students: Students): Students{
        try{
            return studentsRepository.save(students)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }
    fun update(students: Students): Students{
        try {
            studentsRepository.findById(students.id)
                ?: throw Exception("ID no exists")

            return studentsRepository.save(students)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun updateName(students: Students): Students{
        try{
            val response = studentsRepository.findById(students.id)
                ?: throw Exception("ID no exists")
            response.apply {
                fullname=students.fullname //un atributo del modelo
            }
            return studentsRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}

