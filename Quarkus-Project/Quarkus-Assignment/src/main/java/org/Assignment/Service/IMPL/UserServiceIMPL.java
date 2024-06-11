package org.Assignment.Service.IMPL;

import org.Assignment.Entity.User;
import org.Assignment.Exception.ResourceNotFoundException;
import org.Assignment.Repository.UserRepository;
import org.Assignment.Service.UserService;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserServiceIMPL implements UserService {

    private final UserRepository repo;

    @Inject
    public UserServiceIMPL(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<User> fetchAllData() {
        return repo.listAll();
    }

    @Transactional
    @Override
    public void saveData(User user) {
        repo.persist(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = repo.findById(id);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        repo.deleteById(id);
    }

    @Transactional
    @Override
    public User updateUserDetails(Long id, User user) {
        User existingUser = repo.findById(id);
        if (existingUser == null) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        existingUser.setUserName(user.getUserName());
        existingUser.setUserEmail(user.getUserEmail());
        existingUser.setUserCity(user.getUserCity());
        existingUser.setUserMobile(user.getUserMobile());
        repo.persist(existingUser);
        return existingUser;
    }

    @Override
    public User findUserById(Long id) {
        User byId = repo.findById(id);
        if (byId==null){
            throw new ResourceNotFoundException("User not found id: "+id);
        }
        else {
            return byId;
        }
    }
}
