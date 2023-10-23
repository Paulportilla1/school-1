package com.example.schoolapp.repository

import com.example.schoolapp.model.Students
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentsRepository : JpaRepository<Students, Long?> {

    fun findById (id: Long?): Students?


}