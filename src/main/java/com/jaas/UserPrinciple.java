package com.jaas;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * Created by william on 17/3/19.
 */
public class UserPrinciple implements Principal {
    @Override
    public boolean implies(Subject subject) {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

}
