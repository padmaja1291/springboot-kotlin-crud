package com.example.demo.model

import javax.persistence.*

@Entity
@Table(name = "employee")
class Employee(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val wwid : Long = 0,
        val email : String = "",
        val firstname : String = "",
        val lastname : String = ""){



}