package upec.episen.eco.service.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.exceptions.UserNotFoundException;
import upec.episen.eco.models.User.User;
import upec.episen.eco.repository.User.IUser;

@Service
public class UserService {

    @Autowired
    private IUser iuser;

    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = iuser.findById(id);
        if(!user.isPresent()) {
            throw new UserNotFoundException(id);
        }
        return user.get();
    }
}
