package com.jaas;

import org.springframework.security.authentication.jaas.AuthorityGranter;

import java.security.Principal;
import java.util.Collections;
import java.util.Set;

/**
 * Created by william on 17/3/17.
 */
public class RoleUserAuthorityGranter implements AuthorityGranter {

    public Set<String> grant(Principal principal) {
        return Collections.singleton("ROLE_USER");
    }
}
