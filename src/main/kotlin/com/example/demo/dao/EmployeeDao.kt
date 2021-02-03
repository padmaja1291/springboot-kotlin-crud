package com.example.demo.dao

import com.example.demo.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EmployeeDao : JpaRepository<Employee, Long> {
    fun findOneByWwid(id: Long): Employee?

    @Query("SELECT e FROM Employee e WHERE e.lastname LIKE '% %'")
    fun hasMultipleLastName(): List<Employee>

}