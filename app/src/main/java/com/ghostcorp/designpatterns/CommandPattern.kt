package com.ghostcorp.designpatterns

class CommandPattern {

//    The Command Pattern is a behavioral design pattern that encapsulates a request as a
//    stand-alone object containing all information needed to perform an action. It turns
//    method calls into objects that can be passed around, stored, queued, and executed at
//    different times.

//    How It Works
//    The Command Pattern involves four key components:
//
//    Command Interface - Defines the execute() method that all commands must implement
//
//    Concrete Commands - Specific command classes that encapsulate actions and their parameters
//
//    Receiver - The object that performs the actual work when the command is executed
//
//    Invoker - Triggers command execution without knowing implementation details
//
//    Client - Creates command objects and configures them with receivers


    // Command Interface
    interface Command {
        fun execute()
        fun undo()
    }

    // Receiver - knows how to perform operations
    class Light {
        private var isOn = false

        fun turnOn() {
            isOn = true
            println("Light is ON")
        }

        fun turnOff() {
            isOn = false
            println("Light is OFF")
        }
    }

    // Concrete Commands
    class LightOnCommand(private val light: Light) : Command {
        override fun execute() {
            light.turnOn()
        }

        override fun undo() {
            light.turnOff()
        }
    }

    class LightOffCommand(private val light: Light) : Command {
        override fun execute() {
            light.turnOff()
        }

        override fun undo() {
            light.turnOn()
        }
    }

    // Invoker - triggers commands
    class RemoteControl {
        private var command: Command? = null
        private var lastCommand: Command? = null

        fun setCommand(command: Command) {
            this.command = command
        }

        fun pressButton() {
            command?.execute()
            lastCommand = command
        }

        fun pressUndo() {
            lastCommand?.undo()
        }
    }

    // Client Usage
    val light = Light()
    val lightOn = LightOnCommand(light)
    val lightOff = LightOffCommand(light)

    val remote = RemoteControl()
    remote.setCommand(lightOn)
    remote.pressButton()  // Light is ON

    remote.setCommand(lightOff)
    remote.pressButton()  // Light is OFF

    remote.pressUndo()    // Light is ON (undo last command)



}