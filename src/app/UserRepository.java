package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    // Додати користувача
    public void addUser(User user) {
        users.add(user);
    }

    // Пошук користувача за id
    public Optional<User> findUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    // Пошук користувача за email
    public Optional<User> findUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    // Отримати список всіх користувачів
    public Optional<List<User>> findAllUsers() {
        return users.isEmpty() ? Optional.empty() : Optional.of(users);
    }
}