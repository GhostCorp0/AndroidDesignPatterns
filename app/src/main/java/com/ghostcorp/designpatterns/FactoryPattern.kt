package com.ghostcorp.designpatterns

class FactoryPattern {
    // The Factory Pattern is a creational design pattern that provides an interface
    // for creating objects without specifying their concrete classes
    //Instead of directly instantiating objects using constructors, you delegate object creation
    //to a factory method.

   // What a factory does is it needs to decide and distinguish between similar types of objects
    // and then create desired one of that. we have different type of objects and on the basis of logic
    // we decide to create which object to create


    // Product Interface
    interface Notification {
        fun notifyUser()
    }

    // Concrete Products
    class EmailNotification : Notification {
        override fun notifyUser() {
            // Send email notification
        }
    }

    class SMSNotification : Notification {
        override fun notifyUser() {
            // Send SMS notification
        }
    }

    class PushNotification : Notification {
        override fun notifyUser() {
            // Send push notification
        }
    }

    // Factory
    class NotificationFactory {
        fun createNotification(type: String): Notification {
            return when (type) {
                "email" -> EmailNotification()
                "sms" -> SMSNotification()
                "push" -> PushNotification()
                else -> throw IllegalArgumentException("Unknown notification type")
            }
        }
    }

    // Usage
    val factory = NotificationFactory()
    val notification = factory.createNotification("email")
    notification.notifyUser()








}