package com.example.demo.service

import com.example.demo.dao.EmployeeDao
import com.example.demo.model.CustomException
import com.example.demo.model.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

/**
 * This class handles all CRUD (create, Read, Update, Delete Operations) service
 * @author Padmaja Krishna Kumar
 * @version 1.0
 * @since 03 Feb 2021
 **/
@Service
class EmployeeService(@Autowired private val employeeDao : EmployeeDao,
                      @Autowired private val validateEmailClient :ValidateEmailClient) {

    fun getAllEmployees(): List<Employee> =
            employeeDao.findAll()

    fun getEmployeeByWwid(@PathVariable wwid : Long) : Employee? =
            employeeDao.findOneByWwid(wwid)

    fun hasMultipleLastname() : List<Employee> =
            employeeDao.hasMultipleLastName()

    fun saveEmployees(@RequestBody employee : Employee) :Employee  {
        if(isLetters(employee.firstname) && isLetters(employee.lastname)){
            if(validateEmailClient.validateEmail(employee.email).format_valid)
               return employeeDao.save(employee)
            else throw CustomException("Email is not valid")
        }
        else throw CustomException("Name cannot contains non alphabet characters")
    }

    fun updateEmployee(@PathVariable wwid : Long, @RequestBody employee : Employee): Employee {
        employeeDao.findOneByWwid(wwid).takeIf { e -> e != null }?.let {
             return employeeDao.save(Employee(wwid, employee.email, employee.firstname, employee.lastname))
        } ?: throw CustomException("Employee does not exist")

    }

    fun deleteEmployee(@PathVariable wwid : Long)  {
        try {
            employeeDao.deleteById(wwid)
        }catch(e : EmptyResultDataAccessException){
            throw CustomException("wwid does not exist")
        }
    }

    fun isLetters(str: String): Boolean {
        return str.all { it.isLetter() }
    }

}