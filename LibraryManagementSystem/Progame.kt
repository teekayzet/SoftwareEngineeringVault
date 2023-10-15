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
    
library.addBook(1, "To Kill a Mockingbird", "Harper Lee")
library.addBook(2, "Pride and Prejudice", "Jane Austen")
library.addBook(3, "1984", "George Orwell")
library.addBook(4, "The Great Gatsby", "F. Scott Fitzgerald")
library.addBook(5, "The Catcher in the Rye", "J.D. Salinger")
library.addBook(6, "Moby Dick", "Herman Melville")
library.addBook(7, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling")
library.addBook(8, "The Lord of the Rings", "J.R.R. Tolkien")
library.addBook(9, "The Hobbit", "J.R.R. Tolkien")
library.addBook(10, "To the Lighthouse", "Virginia Woolf")
library.addBook(11, "The Odyssey", "Homer")
library.addBook(12, "War and Peace", "Leo Tolstoy")
library.addBook(13, "Crime and Punishment", "Fyodor Dostoevsky")
library.addBook(14, "Jane Eyre", "Charlotte Bronte")
library.addBook(15, "The Hobbit", "J.R.R. Tolkien")
library.addBook(16, "The Da Vinci Code", "Dan Brown")
library.addBook(17, "The Alchemist", "Paulo Coelho")
library.addBook(18, "The Picture of Dorian Gray", "Oscar Wilde")
library.addBook(19, "Gone with the Wind", "Margaret Mitchell")
library.addBook(20, "Brave New World", "Aldous Huxley")

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
