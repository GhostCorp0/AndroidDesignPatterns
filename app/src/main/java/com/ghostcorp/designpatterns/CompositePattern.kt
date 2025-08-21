package com.ghostcorp.designpatterns

class CompositePattern {

    // Composite Pattern is a structural design pattern that allows you to compose objects into tree
    // structures to represent part - whole - hierarchies.It enables clients to treat individual objects
    // and composition of objects uniformly through a common interface.

   /* The Composite Pattern involves these key components:

    Component - Common interface/abstract class defining operations for both leaf and composite objects

    Leaf - Individual objects that implement the component interface directly (no children)

    Composite - Container objects that hold child components and delegate operations to them

    Client - Interacts with all objects through the component interface*/


    // Component Interface
    interface FileSystemComponent {
        fun showDetails()
        fun getSize(): Int
    }

    // Leaf - Individual File
    class File(private val name: String, private val size: Int) : FileSystemComponent {
        override fun showDetails() {
            println("File: $name ($size KB)")
        }

        override fun getSize(): Int = size
    }

    // Composite - Directory
    class Directory(private val name: String) : FileSystemComponent {
        private val components = mutableListOf<FileSystemComponent>()

        fun add(component: FileSystemComponent) {
            components.add(component)
        }

        fun remove(component: FileSystemComponent) {
            components.remove(component)
        }

        override fun showDetails() {
            println("Directory: $name")
            components.forEach { it.showDetails() }
        }

        override fun getSize(): Int {
            return components.sumOf { it.getSize() }
        }
    }

    // Usage
    val rootDir = Directory("root")
    val file1 = File("document.txt", 10)
    val file2 = File("image.jpg", 50)

    val subDir = Directory("photos")
    val file3 = File("vacation.png", 30)

    subDir.add(file3)
    rootDir.add(file1)
    rootDir.add(file2)
    rootDir.add(subDir)

    rootDir.showDetails()  // Shows entire tree structure
    println("Total Size: ${rootDir.getSize()} KB")  // 90 KB




}