// Book class
data class Book(
    val bookId: Int,
    val title: String,
    val author: String,
    var isAvailable: Boolean = true, // Indicates if the book is available for borrowing
    var borrowerId: Int? = null      // ID of the student who borrowed the book
)

// Library class
class Library {
    private val books = mutableListOf<Book>()

    // Add a book to the library
    fun addBook(bookId: Int, title: String, author: String) {
        val book = Book(bookId, title, author)
        books.add(book)
    }

    // Borrow a book from the library
    fun borrowBook(bookId: Int, studentId: Int) {
        val book = books.find { it.bookId == bookId }
        if (book != null) {
            if (book.isAvailable) {
                book.isAvailable = false
                book.borrowerId = studentId
                println("Book '${book.title}' borrowed successfully.")
            } else {
                println("Book '${book.title}' is currently not available.")
            }
        } else {
            println("Invalid Book ID.")
        }
    }

    // Return a borrowed book to the library
    fun returnBook(bookId: Int) {
        val book = books.find { it.bookId == bookId }
        if (book != null) {
            if (!book.isAvailable) {
                book.isAvailable = true
                book.borrowerId = null
                println("Book '${book.title}' returned successfully.")
            } else {
                println("Book '${book.title}' is already available.")
            }
        } else {
            println("Invalid Book ID.")
        }
    }

    // Print the available books in the library
    fun printBooks() {
        println("Available Books:")
        books.filter { it.isAvailable }.forEach { book ->
            println("ID: ${book.bookId} | Title: ${book.title} | Author: ${book.author}")
        }
    }
}

// Librarian class
data class Librarian(val username: String, val password: String)

fun main() {
    val library = Library()
    library.addBook(1, "Book 1", "Author 1")
    library.addBook(2, "Book 2", "Author 2")
    library.addBook(3, "Book 3", "Author 3")

    val librarian = Librarian("admin", "password")

    // Librarian login
    var loggedIn = false
    while (!loggedIn) {
        print("Enter username: ")
        val username = readLine() ?: ""
        print("Enter password: ")
        val password = readLine() ?: ""
        loggedIn = librarian.username == username && librarian.password == password
        if (!loggedIn) {
            println("Invalid credentials. Please try again.")
        }
    }

    // Librarian actions
    var action = ""
    while (action != "exit") {
        println("\nLibrarian Menu:")
        println("1. Borrow Book")
        println("2. Return Book")
        println("3. View Available Books")
        println("Type 'exit' to quit.")
        print("Enter your choice: ")
        action = readLine() ?: ""

        when (action) {
            "1" -> {
                print("Enter the Book ID: ")
                val bookId = readLine()?.toIntOrNull() ?: 0
                print("Enter the Student ID: ")
                val studentId = readLine()?.toIntOrNull() ?: 0
                library.borrowBook(bookId, studentId)
            }
            "2" -> {
                print("Enter the Book ID: ")
                val bookId = readLine()?.toIntOrNull() ?: 0
                library.returnBook(bookId)
            }
            "3" -> {
                library.printBooks()
            }
            "exit" -> println("Exiting.")
            else -> println("Invalid choice. Please try again.")
        }
    }
}
