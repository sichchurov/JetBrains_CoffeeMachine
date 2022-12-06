package coffeemachine

enum class Coffee(
    var waterCount: Int,
    var milkCount: Int,
    var beansCount: Int,
    var disposalCupsCount: Int,
    var cost: Int
) {

    COFFEE_MACHINE(waterCount = 400, milkCount = 540, beansCount = 120, disposalCupsCount = 9, cost = 550),
    ESPRESSO(waterCount = 250, milkCount = 0, beansCount = 16, disposalCupsCount = 1, cost = 4),
    LATTE(waterCount = 350, milkCount = 75, beansCount = 20, disposalCupsCount = 1, cost = 7),
    CAPPUCCINO(waterCount = 200, milkCount = 100, beansCount = 12, disposalCupsCount = 1, cost = 6);
}