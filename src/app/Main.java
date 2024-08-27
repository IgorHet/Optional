package app;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        // Додавання користувачів
        userRepository.addUser(new User(1, "John Doe", "john@example.com"));
        userRepository.addUser(new User(2, "Jane Smith", "jane@example.com"));

        // Пошук користувача за id
        int searchId = 1;
        Optional<User> userById = userRepository.findUserById(searchId);
        userById.ifPresentOrElse(
                user -> System.out.println("User found by ID: " + user),
                () -> System.out.println("No user found with ID: " + searchId)
        );

        // Пошук користувача за email
        String searchEmail = "jane@example.com";
        Optional<User> userByEmail = userRepository.findUserByEmail(searchEmail);
        userByEmail.ifPresentOrElse(
                user -> System.out.println("User found by Email: " + user),
                () -> System.out.println("No user found with Email: " + searchEmail)
        );

        // Отримання списку всіх користувачів
        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(
                users -> System.out.println("Total number of users: " + users.size()),
                () -> System.out.println("No users found.")
        );
    }
}