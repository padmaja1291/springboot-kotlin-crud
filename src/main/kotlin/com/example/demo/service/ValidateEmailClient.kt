package com.example.demo.service

import com.example.demo.model.EmailValidation
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
/**
 * Spring Cloud OpenFeign client for accessing apilayer open source email validation api
 * @author Padmaja Krishna Kumar
 * @version 1.0
 * @since 03 Feb 2021
 */
@FeignClient(value = "ValidateFeign", url = "http://apilayer.net")
interface ValidateEmailClient {
    @GetMapping("/api/check")
    fun validateEmail(@RequestParam(value = "email") email : String,
                      @RequestParam(value = "smtp") smtp : Int = 0,
                      @RequestParam(value = "format") format : Int = 0,
                      @RequestParam(value = "access_key") access_key : String = "b1dbeff9f8919516891df7cdcf25484b")
                             : EmailValidation
}