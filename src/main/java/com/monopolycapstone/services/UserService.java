package com.monopolycapstone.services;

import com.monopolycapstone.models.User;

public interface UserService {
    public User addUser(User u);
    public User getUser(int id);

    public User updateUser(User update);

    public boolean deleteUser(int id);

}
