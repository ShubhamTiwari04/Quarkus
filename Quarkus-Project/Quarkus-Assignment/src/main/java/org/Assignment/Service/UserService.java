package org.Assignment.Service;

import org.Assignment.Entity.User;

import java.util.List;

public interface UserService {

    public List<User> fetchAllData();

    public void saveData(User user);

    public void deleteUser(Long id);

    public User updateUserDetails(Long id, User user);

    public User findUserById(Long id);
}
