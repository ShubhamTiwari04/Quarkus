package org.Assignment.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.Assignment.Entity.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}
