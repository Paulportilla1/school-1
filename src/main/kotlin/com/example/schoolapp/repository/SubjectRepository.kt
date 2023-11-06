package com.example.schoolapp.repository

import com.example.schoolapp.model.Subject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubjectRepository : JpaRepository<Subject, Long?> {

    fun findById (id: Long?): Subject?


}