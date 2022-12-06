package coffeemachine

class CoffeeMachine {

    fun makeCoffee(coffee: String) {
        when {
            Coffee.COFFEE_MACHINE.waterCount - Coffee.valueOf(coffee).waterCount < 0 -> {
                println("Sorry, not enough water")
                return
            }

            Coffee.COFFEE_MACHINE.milkCount - Coffee.valueOf(coffee).milkCount < 0 -> {
                println("Sorry, not enough milk")
                return
            }

            Coffee.COFFEE_MACHINE.beansCount - Coffee.valueOf(coffee).beansCount < 0 -> {
                println("Sorry, not enough beans")
                return
            }

            Coffee.COFFEE_MACHINE.disposalCupsCount - Coffee.valueOf(coffee).disposalCupsCount < 0 -> {
                println("Sorry, not enough cups")
                return
            }

            else -> println("I have enough resources, making you ${coffee.lowercase()}!")
        }

        Coffee.COFFEE_MACHINE.waterCount -= Coffee.valueOf(coffee).waterCount
        Coffee.COFFEE_MACHINE.milkCount -= Coffee.valueOf(coffee).milkCount
        Coffee.COFFEE_MACHINE.beansCount -= Coffee.valueOf(coffee).beansCount
        Coffee.COFFEE_MACHINE.disposalCupsCount -= Coffee.valueOf(coffee).disposalCupsCount
        Coffee.COFFEE_MACHINE.cost += Coffee.valueOf(coffee).cost

    }

    fun fillCoffeeMachine() {
        println("Write how many ml of water you want to add: ")
        Coffee.COFFEE_MACHINE.waterCount += readln().toInt()

        println("Write how many ml of milk you want to add: ")
        Coffee.COFFEE_MACHINE.milkCount += readln().toInt()

        println("Write how many grams of coffee beans you want to add:")
        Coffee.COFFEE_MACHINE.beansCount += readln().toInt()

        println("Write how many disposable cups you want to add:")
        Coffee.COFFEE_MACHINE.disposalCupsCount += readln().toInt()
    }

    fun takeMoney() {
        println("I gave you ${Coffee.COFFEE_MACHINE.cost}")
        Coffee.COFFEE_MACHINE.cost -= Coffee.COFFEE_MACHINE.cost
    }

    fun print() {
        println(
            """
            
        The coffee machine has:
        ${Coffee.COFFEE_MACHINE.waterCount} ml of water
        ${Coffee.COFFEE_MACHINE.milkCount} ml of milk
        ${Coffee.COFFEE_MACHINE.beansCount} g of coffee beans
        ${Coffee.COFFEE_MACHINE.disposalCupsCount} disposable cups
        $${Coffee.COFFEE_MACHINE.cost} of money
        
    """.trimIndent()
        )
    }
}

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