package com.example.demo.model

/**
 * This class handles  Custom Exception.
 * @author Padmaja Krishna Kumar
 * @version 1.0
 * @since 03 Feb 2021
 */
class CustomException: Exception{
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(cause: Throwable) : super(cause)

}