package com.example.demo.controller

import com.example.demo.model.CustomException
import com.example.demo.model.Employee
import com.example.demo.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


/**
 * This class handles all the rest api requests (create, Read, Update, Delete Operations)
 * @author Padmaja Krishna Kumar
 * @version 1.0
 * @since 03 Feb 2021
 **/
@RestController
class EmployeeController(@Autowired private val employeeService : EmployeeService) {

    //gets all employees
    @GetMapping("/employees")
    fun getAllEmployees() : ResponseEntity<List<Employee>> =
            ResponseEntity.status(HttpStatus.OK)
                    .body(employeeService.getAllEmployees())


    //gets the requested employee
    @GetMapping("employees/{wwid}")
    fun getEmployeeByWwid(@PathVariable wwid : Long) : Employee =
            employeeService.getEmployeeByWwid(wwid) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND,
                    "This employee does not exist")

    //gets employees with multiple last name
    @GetMapping("employees/hasMultipleLastname")
    fun hasMultipleLastname() : ResponseEntity<List<Employee>> {
        val e : List<Employee> = employeeService.hasMultipleLastname()
        if(e.isEmpty())
            throw ResponseStatusException(HttpStatus.NOT_FOUND,
                "Employee with multiple last name not exist")
        else
            return ResponseEntity.status(HttpStatus.OK)
                    .body(e)
    }

    //creates a new employee
    @PostMapping("/employees")
    fun saveEmployees(@RequestBody employee : Employee) : ResponseEntity<Employee>   {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(employeeService.saveEmployees(employee))
        }catch (e : CustomException){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Input is not in valid format")
        }

    }

    //updates an existing employee
    @PutMapping("/employees/{wwid}")
    fun updateEmployee(@PathVariable wwid : Long, @RequestBody employee : Employee): ResponseEntity<Employee> {
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(employeeService.updateEmployee(wwid,employee))

        }catch (e : CustomException){
            if(e.message.equals("Employee does not exist"))
                throw ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Employee Not Found")
            else
                throw ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Input is not in valid format")
        }

    }

    // deletes an existing employee
    @DeleteMapping("/employees/{wwid}")
    fun deleteEmployee(@PathVariable wwid : Long) : ResponseEntity<Any>{
        try {
            employeeService.deleteEmployee(wwid)
        }
        catch (e: Exception) {
            // can handle it by adding to logger
        }
            return ResponseEntity.noContent().build()

    }
}