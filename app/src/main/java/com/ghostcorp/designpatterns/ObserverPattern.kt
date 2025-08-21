package com.ghostcorp.designpatterns

class ObserverPattern {

//    The Observer Pattern is a behavioral design pattern that defines a one-to-many
//    dependency between objects. When one object (the subject) changes state, all its
//    dependents (observers) are automatically notified and updated.

//    How It Works
//    The Observer Pattern involves these key components:
//
//    Subject (Observable) - Maintains a list of observers and provides methods to register/unregister them
//
//    Observer - Interface defining the update() method that observers must implement
//
//    ConcreteSubject - Specific implementation that holds actual state and notifies observers when it changes
//
//    ConcreteObserver - Implements the observer interface and reacts to notifications

    // Observer Interface
    interface Observer {
        fun update(temperature: Float, humidity: Float, pressure: Float)
    }

    // Subject Interface
    interface Subject {
        fun registerObserver(observer: Observer)
        fun removeObserver(observer: Observer)
        fun notifyObservers()
    }

    // ConcreteSubject - Weather Station
    class WeatherStation : Subject {
        private val observers = mutableListOf<Observer>()
        private var temperature: Float = 0f
        private var humidity: Float = 0f
        private var pressure: Float = 0f

        override fun registerObserver(observer: Observer) {
            observers.add(observer)
        }

        override fun removeObserver(observer: Observer) {
            observers.remove(observer)
        }

        override fun notifyObservers() {
            observers.forEach { it.update(temperature, humidity, pressure) }
        }

        fun setWeatherData(temperature: Float, humidity: Float, pressure: Float) {
            this.temperature = temperature
            this.humidity = humidity
            this.pressure = pressure
            notifyObservers()  // Automatically notify all observers
        }
    }

    // ConcreteObserver - Phone App
    class PhoneWeatherApp : Observer {
        override fun update(temperature: Float, humidity: Float, pressure: Float) {
            println("Phone App: Temperature ${temperature}°C, Humidity ${humidity}%, Pressure ${pressure}hPa")
        }
    }

    // ConcreteObserver - TV Display
    class TVWeatherDisplay : Observer {
        override fun update(temperature: Float, humidity: Float, pressure: Float) {
            println("TV Display: Current weather - ${temperature}°C, ${humidity}% humidity")
        }
    }

    // Usage
    val weatherStation = WeatherStation()
    val phoneApp = PhoneWeatherApp()
    val tvDisplay = TVWeatherDisplay()

// Register observers
    weatherStation.registerObserver(phoneApp)
    weatherStation.registerObserver(tvDisplay)

// Weather changes - all observers get notified automatically
    weatherStation.setWeatherData(25.5f, 60f, 1013.2f)
// Output:
// Phone App: Temperature 25.5°C, Humidity 60%, Pressure 1013.2hPa
// TV Display: Current weather - 25.5°C, 60% humidity






}