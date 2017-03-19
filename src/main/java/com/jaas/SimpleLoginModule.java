package com.jaas;

/**
 * Created by william on 17/3/17.
 */

import com.william.mapper.UserMapper;
import com.william.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.security.Principal;
import java.sql.*;
import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;


public class SimpleLoginModule implements LoginModule {
    private String password;
    private String user;
    private Subject subject;



    public boolean abort() throws LoginException {
        return true;
    }

    public boolean commit() throws LoginException {
        return true;
    }

    public void initialize(Subject subject,
                           CallbackHandler callbackHandler, Map sharedState, Map options) {
        this.subject = subject;

        try {
            TextInputCallback textCallback = new TextInputCallback(
                    "prompt");
            NameCallback nameCallback = new NameCallback("prompt");
            PasswordCallback passwordCallback = new PasswordCallback("prompt",
                    false);

            callbackHandler.handle(new Callback[] {
                    textCallback, nameCallback, passwordCallback
            });

            password = new String(passwordCallback.getPassword());
            user = nameCallback.getName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login() throws LoginException {
        //System.out.print(userMapper.selectByPrimaryKey(2).getPhone());
        DriverManagerDataSource ds = SpringContextUtil.getBean("dataSource");
        try{
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM  users WHERE phone="+user);
            if(!result.next())
            {
                throw  new LoginException("Authentication fail");
            }

            if(result.getString("password").equals(password))
            {
                throw  new LoginException("Authentication fail");
            }
        }
        catch (SQLException e)
        {
            LoginException le = new LoginException("sql");
            le.initCause(e);
            le.printStackTrace();
            throw  le;
        }


        subject.getPrincipals().add(new Principal() {
            public String getName() {
                return user;
            }
        });
//
//        subject.getPrincipals().add(new Principal() {
//            public String getName() {
//                return "NULL_PRINCIPAL";
//            }
//        });

        return true;
    }

    public boolean logout() throws LoginException {
        return true;
    }
}
