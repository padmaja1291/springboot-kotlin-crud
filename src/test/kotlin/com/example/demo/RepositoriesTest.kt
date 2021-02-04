package com.example.demo

import com.example.demo.dao.EmployeeDao
import com.example.demo.model.Employee
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.assertj.core.api.Assertions.assertThat
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
/**
 * Test for userRepository findOneByWwid
 * @author Padmaja Krishna Kumar
 * @version 1.0
 * @since 03 Feb 2021
 **/
@DataJpaTest
class RepositoriesTest @Autowired constructor(
        val userRepository: EmployeeDao) {

    @Test
    fun `When findOneByWwid then return Employee`() {

        val employee = Employee(1,"test@test.com","firsttest","secondtest")
        userRepository.save(employee)
        println("loaded employee $employee")
        val found = userRepository.findOneByWwid(employee.wwid)
        println("found employee $found")
        assertThat(found?.email).isEqualTo(employee.email)
        assertThat(found?.firstname).isEqualTo(employee.firstname)
        assertThat(found?.lastname).isEqualTo(employee.lastname)
    }

}