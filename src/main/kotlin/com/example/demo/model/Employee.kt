package com.example.demo.model

import javax.persistence.*
/**
 * Model Class for Employee
 * @author Padmaja Krishna Kumar
 * @version 1.0
 * @since 03 Feb 2021
 */
@Entity
@Table(name = "employee")
class Employee(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val wwid : Long = 0,
        val email : String = "",
        val firstname : String = "",
        val lastname : String = ""){



}