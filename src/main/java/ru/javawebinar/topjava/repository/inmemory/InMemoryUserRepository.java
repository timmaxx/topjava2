package ru.javawebinar.topjava.repository.inmemory;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
// public class InMemoryUserRepository implements UserRepository
public class InMemoryUserRepository extends InMemoryBaseRepository<User> implements UserRepository {
    public static final int USER_ID = 1;
    public static final int ADMIN_ID = 2;

    @Override
    public List<User> getAll() {
        log.info("getAll");
/*
        return usersMap.values().stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getEmail))
                .collect(Collectors.toList());
*/
        return getCollection().stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);
/*
        return usersMap.values().stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
*/
        return getCollection().stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
    }
}