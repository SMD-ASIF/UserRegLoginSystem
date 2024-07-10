# UserAccountManager

## Overview
UserAccountManager is a Java Swing-based application designed to handle user account management, including registration and login functionalities. This project demonstrates secure user authentication, comprehensive data validation, and persistent storage using serialization.

## Features
- **User Registration**: Users can register with a unique username and a verified email address.
- **Login System**: Secure login mechanism for registered users.
- **Data Persistence**: User credentials are stored securely using serialization.

## Technologies Used
- **Java**: Core programming language for backend logic.
- **Swing**: Java library used for creating the graphical user interface (GUI).
- **Serialization**: Technique used for saving and loading user data.

## Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/SMD-ASIF/UserAccountManager.git
    ```
2. Open the project in your preferred Java IDE (such as IntelliJ IDEA or Eclipse).
3. Compile and run the `App` class to start the application.

## Usage
1. **Create Account**: Enter a unique username, first name, last name, email, and password to create a new account. All fields are required and validated.
2. **Login**: Enter your registered username and password to log in. Upon successful login, a welcome message will be displayed.

## Validation Rules
- **Username**: Must be unique, contain no special characters, and be 10 characters or fewer.
- **Password**: Must be 8 characters long, containing no special characters.
- **Email**: Must be in a valid email format and unique.

## Future Enhancements
- **Password Encryption**: Adding encryption to store passwords securely.
- **Database Integration**: Replacing serialization with a database for better scalability and data management.
- **User Profile Management**: Allowing users to manage and update their profiles.

## Learning Highlights
- Deepened understanding of GUI development in Java using Swing.
- Gained experience in implementing secure authentication systems.
- Learned to handle file I/O operations for persistent data storage.
