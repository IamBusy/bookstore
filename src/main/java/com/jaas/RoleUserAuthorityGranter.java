package com.jaas;

import com.william.model.Group;
import com.william.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.AuthorityGranter;

import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by william on 17/3/17.
 */
public class RoleUserAuthorityGranter implements AuthorityGranter {

    @Autowired
    private UserRepository userRepository;

    public Set<String> grant(Principal principal) {
        String phone = principal.getName();

        List<Group>  groups = userRepository.getGroups(phone);

        Set<String> authoritys = new HashSet<>();


        groups.forEach((group)->{
            if(group.getName().equals("admin"))
            {
                authoritys.add("ROLE_ADMIN");
            }
            else if(group.getName().equals("user"))
            {
                authoritys.add("ROLE_USER");
            }
        });

        return  authoritys;
        //return Collections.singleton("ROLE_USER");
    }
}
