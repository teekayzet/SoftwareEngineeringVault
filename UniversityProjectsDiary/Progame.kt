data class Book(val bookId: Int, var title: String, var isBorrowed: Boolean = false)

class Library {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun removeBook(bookId: Int) {
        books.removeIf { it.bookId == bookId }
    }

    fun borrowBook(bookId: Int): Boolean {
        val book = books.find { it.bookId == bookId && !it.isBorrowed }
        return if (book != null) {
            book.isBorrowed = true
            true
        } else false
    }

    fun returnBook(bookId: Int) {
        val book = books.find { it.bookId == bookId && it.isBorrowed }
        book?.isBorrowed = false
    }

    fun listAvailableBooks() {
        val availableBooks = books.filter { !it.isBorrowed }
        for (book in availableBooks) {
            println("${book.bookId} - ${book.title}")
        }
    }

    fun isBookAvailable(bookId: Int): Boolean {
        val book = books.find { it.bookId == bookId }
        return book?.isBorrowed == false
    }
}

fun main() {
    val library = Library()

    loop@ while (true) {
        println("\nOptions:\n1. Add Book\n2. Remove Book\n3. Borrow Book\n4. Return Book\n5. List Available Books\n6. Check Book Availability\n7. Exit")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Enter Book ID: ")
                val id = readLine()!!.toInt()
                println("Enter Book Title: ")
                val title = readLine()!!
                library.addBook(Book(id, title))
                println("Book added.")
            }
            2 -> {
                println("Enter Book ID to remove: ")
                val id = readLine()!!.toInt()
                library.removeBook(id)
                println("Book removed.")
            }
            3 -> {
                println("Enter Book ID to borrow: ")
                val id = readLine()!!.toInt()
                if (library.borrowBook(id)) {
                    println("Book borrowed.")
                } else {
                    println("Book unavailable or already borrowed.")
                }
            }
            4 -> {
                println("Enter Book ID to return: ")
                val id = readLine()!!.toInt()
                library.returnBook(id)
                println("Book returned.")
            }
            5 -> {
                println("Available books:")
                library.listAvailableBooks()
            }
            6 -> {
                println("Enter Book ID to check availability: ")
                val id = readLine()!!.toInt()
                if (library.isBookAvailable(id)) {
                    println("Book is available.")
                } else {
                    println("Book is currently borrowed.")
                }
            }
            7 -> {
                println("Exiting...")
                break@loop
            }
            else -> println("Invalid choice!")
        }
    }
}