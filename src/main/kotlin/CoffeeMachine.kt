package coffeemachine

import coffeemachine.Coffee.COFFEE_MACHINE

class CoffeeMachine {

    fun makeCoffee(coffee: String) {
        when {
            (COFFEE_MACHINE.waterCount - getCoffeeType(coffee).waterCount) < 0 -> {
                println("Sorry, not enough water")
                return
            }

            (COFFEE_MACHINE.milkCount - getCoffeeType(coffee).milkCount) < 0 -> {
                println("Sorry, not enough milk")
                return
            }

            (COFFEE_MACHINE.beansCount - getCoffeeType(coffee).beansCount) < 0 -> {
                println("Sorry, not enough beans")
                return
            }

            (COFFEE_MACHINE.disposalCupsCount - getCoffeeType(coffee).disposalCupsCount) < 0 -> {
                println("Sorry, not enough cups")
                return
            }

            else -> println("I have enough resources, making you ${coffee.lowercase()}!")
        }

        COFFEE_MACHINE.waterCount -= getCoffeeType(coffee).waterCount
        COFFEE_MACHINE.milkCount -= getCoffeeType(coffee).milkCount
        COFFEE_MACHINE.beansCount -= getCoffeeType(coffee).beansCount
        COFFEE_MACHINE.disposalCupsCount -= getCoffeeType(coffee).disposalCupsCount
        COFFEE_MACHINE.cost += getCoffeeType(coffee).cost

    }

    fun fillCoffeeMachine() {
        println("Write how many ml of water you want to add: ")
        COFFEE_MACHINE.waterCount += readln().toInt()

        println("Write how many ml of milk you want to add: ")
        COFFEE_MACHINE.milkCount += readln().toInt()

        println("Write how many grams of coffee beans you want to add:")
        COFFEE_MACHINE.beansCount += readln().toInt()

        println("Write how many disposable cups you want to add:")
        COFFEE_MACHINE.disposalCupsCount += readln().toInt()
    }

    fun takeMoney() {
        println("I gave you ${COFFEE_MACHINE.cost}")
        COFFEE_MACHINE.cost -= COFFEE_MACHINE.cost
    }

    fun print() {
        println(
            """
            
        The coffee machine has:
        ${COFFEE_MACHINE.waterCount} ml of water
        ${COFFEE_MACHINE.milkCount} ml of milk
        ${COFFEE_MACHINE.beansCount} g of coffee beans
        ${COFFEE_MACHINE.disposalCupsCount} disposable cups
        $${COFFEE_MACHINE.cost} of money
        
    """.trimIndent()
        )
    }
}

fun getCoffeeType(coffee: String) = Coffee.valueOf(coffee)

fun startApp() {
    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                when (readln()) {
                    "1" -> CoffeeMachine().makeCoffee("ESPRESSO")
                    "2" -> CoffeeMachine().makeCoffee("LATTE")
                    "3" -> CoffeeMachine().makeCoffee("CAPPUCCINO")
                    "back" -> continue
                }
            }

            "fill" -> CoffeeMachine().fillCoffeeMachine()

            "take" -> CoffeeMachine().takeMoney()

            "remaining" -> CoffeeMachine().print()

            "exit" -> return

            else -> println("Wrong choice!")
        }
    }
}