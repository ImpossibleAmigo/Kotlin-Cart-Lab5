package org.example // Якщо цей рядок підсвітить червоним - видали його

// Клас товару
data class Product(
    val id: Int,
    val name: String,
    val price: Double
)

// Клас корзини
class Cart {
    private val items = mutableListOf<Product>()

    fun add(product: Product) {
        items.add(product)
        println("[+] Додано: ${product.name}")
    }

    fun calculateTotal(): Double {
        var sum = 0.0
        for (item in items) {
            sum += item.price
        }
        return sum
    }

    fun printReceipt() {
        println("\n--- ВАШ ЧЕК ---")
        items.forEach {
            println("${it.name} ...... ${it.price} грн")
        }
        println("----------------")
        println("РАЗОМ ДО СПЛАТИ: ${calculateTotal()} грн")
    }
}

// Запуск
fun main() {
    println("Магазин відкривається...")

    val myCart = Cart()

    myCart.add(Product(1, "Хліб", 24.50))
    myCart.add(Product(2, "Молоко", 38.00))
    myCart.add(Product(3, "Шоколадка", 45.00))

    myCart.printReceipt()
}