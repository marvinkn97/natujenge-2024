package dev.marvin.service;

import dev.marvin.model.User;

public interface UserService {
    User create(String username, String password);
}
