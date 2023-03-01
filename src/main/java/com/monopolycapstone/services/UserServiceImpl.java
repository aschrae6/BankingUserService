package com.monopolycapstone.services;

import com.monopolycapstone.models.User;
import com.monopolycapstone.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User addUser(User u) {
        return userRepo.save(u);
    }

    @Override
    public User getUser(int id) {
        Optional<User> userOptional = userRepo.findById(id);
        return userOptional.orElseGet(User::new);
    }

    @Override
    public User updateUser(User update) {
        return userRepo.save(update);
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            userRepo.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
