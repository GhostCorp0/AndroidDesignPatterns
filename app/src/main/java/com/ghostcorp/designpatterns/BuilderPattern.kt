package com.ghostcorp.designpatterns

class Hamburger private constructor(
    val cheese: Boolean,
    val lettuce: Boolean,
    val onions:Boolean
) {

    // The builder pattern is a creational design pattern that constructs complex objects step by step.
    //Instead of using large constructors with many parameters.It provides a fluent,readable way to
    //build objects by setting only the properties you need.

    class Builder {
        private var cheese:Boolean = true
        private var lettuce:Boolean = true
        private var onions:Boolean = false

        fun cheese(value:Boolean) = apply { cheese = value }

        fun lettuce(value:Boolean) = apply { lettuce = value}

        fun onions(value:Boolean) = apply { onions = value }

        fun build() = Hamburger(cheese,lettuce,onions)
    }

    // to use it

    val hamburger = Hamburger.Builder()
        .cheese(true)
        .lettuce(false)
        .onions(true)
        .build()


}