Library Management System

A Java-based Library Management System designed to streamline the management of library records, transactions, and user interactions. This system offers functionalities for managing books, issuing and returning books, and handling user data. The project is structured with a focus on simplicity, ease of use, and efficient operation.
Features

    Library Operations:
        Calculate fines for overdue books.
        Check book availability.
        Track overdue returns.
        Issue and return books.

    User Management:
        Admin functionalities to add, view, and delete librarians.
        Librarian functionalities to add, view, and delete books.
        Manage user data with persistent storage using CSV files.

    File Handling:
        Store and manage user data reliably using file handling techniques to ensure data persistence.

    Command-Line Interface:
        A straightforward interface to add, delete, modify, and display employee records, making it easy to use and manage data.

How It Works

    Login: Admin or Librarian logs in to access the system.
    Book Management: Admin or Librarian can add, view, or delete books.
    Issue and Return: Librarian can issue books to users and manage their returns.
    User Data Management: The system loads and saves user data to a CSV file to maintain persistent records.
    Logout: After operations, the Admin or Librarian logs out, and user data is saved.

Usage

To run the Library Management System:
1. Compile the Java files:
   javac LibraryManagementSystem.java

2. Run the application:
   java LibraryManagementSystem
