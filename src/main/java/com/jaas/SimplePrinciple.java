package com.jaas;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * Created by william on 17/3/18.
 */
public class SimplePrinciple  implements Principal{
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
    
}
