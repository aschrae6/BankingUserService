package com.monopolycapstone.services;

import com.monopolycapstone.models.User;
import com.monopolycapstone.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(User update) {
        if (userRepo.existsById(update.getId())) {
            return userRepo.save(update);
        } else {
            return new User();
        }
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            userRepo.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
