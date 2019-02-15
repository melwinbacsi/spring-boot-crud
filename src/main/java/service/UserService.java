package service;

import com.baeldung.crud.entities.User;
import com.baeldung.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User showAll();
}
