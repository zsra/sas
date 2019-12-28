package hu.zsra.enaplo.service.user;

import hu.zsra.enaplo.exception.UserManagementException;
import hu.zsra.enaplo.model.user.Parent;
import hu.zsra.enaplo.repository.user.ParentRepository;
import hu.zsra.enaplo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ParentRepository parentRepository;

    public String signIn(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, parentRepository.findByUsername(username).getRole());
        } catch (AuthenticationException e) {
            throw new UserManagementException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public Parent create(Parent parent) {
        return parentRepository.save(parent);
    }

    public void delete(String username) {
        parentRepository.deleteByUsername(username);
    }

    public Parent getParentByUsername(String username) {
        Parent parent = parentRepository.findByUsername(username);
        if(parent == null) {
            throw new UserManagementException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return parent;
    }

    public Parent update(String username, Parent parent) {
        Parent oldParent = getParentByUsername(username);

        oldParent.setPassword(parent.getPassword());
        oldParent.setDateOfBirth(parent.getDateOfBirth());
        oldParent.setEmail(parent.getEmail());
        oldParent.setFirstName(parent.getFirstName());
        oldParent.setMiddleName(parent.getMiddleName());
        oldParent.setLastName(parent.getLastName());
        oldParent.setPhone(parent.getPhone());

        return parentRepository.save(oldParent);
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, parentRepository.findByUsername(username).getRole());
    }
}
