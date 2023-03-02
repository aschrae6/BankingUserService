package com.monopolycapstone.services;

import com.monopolycapstone.models.User;

import java.util.List;

public interface UserService {
    public User addUser(User u);
    public User getUser(int id);
    public List<User> getAllUsers();

    public User updateUser(User update);

    public boolean deleteUser(int id);

}
