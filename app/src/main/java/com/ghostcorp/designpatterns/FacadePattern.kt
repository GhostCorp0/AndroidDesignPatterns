package com.ghostcorp.designpatterns

class FacadePattern {

    // Facade pattern is a structural design pattern that provides a simplified,unified interfaces to a
    // complex subsystem. It acts as a "front facing interface" that hides the complexity of multiple
    // interdependent classes behind a single easy to use API

    // Also retrofit api calling is a good example

    // Complex Subsystem Classes
    class DatabaseConnection {
        fun connect() { println("Database connected") }
        fun disconnect() { println("Database disconnected") }
    }

    class Logger {
        fun log(message: String) { println("Log: $message") }
    }

    class EmailService {
        fun sendEmail(to: String, message: String) {
            println("Email sent to $to: $message")
        }
    }

    class ValidationService {
        fun validateUser(email: String): Boolean {
            return email.contains("@")
        }
    }

    // Facade - Simple Interface
    class UserRegistrationFacade {
        private val database = DatabaseConnection()
        private val logger = Logger()
        private val emailService = EmailService()
        private val validator = ValidationService()

        fun registerUser(email: String, password: String) {
            // Hide complex operations behind simple method
            database.connect()

            if (validator.validateUser(email)) {
                // Save user logic here...
                logger.log("User $email registered successfully")
                emailService.sendEmail(email, "Welcome! Registration complete.")
            } else {
                logger.log("Invalid email: $email")
            }

            database.disconnect()
        }
    }

    // Client Usage
    val userService = UserRegistrationFacade()
    userService.registerUser("john@example.com", "password123")




}