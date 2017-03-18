package com.william.utils;


import com.william.mapper.UserMapper;
import com.william.model.User;
import com.william.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by william on 17/3/2.
 */
@Component
public class JwtUtils {


    static final String CLAIM_KEY_ID = "uid";
    static final String CLAIM_KEY_EXPIRE = "expired_in";

    @Value("${jwt.secret}")
    private String secret;


    @Value("${jwt.expiration}")
    private Long expiration;

    @Autowired
    private UserMapper userMapper;

    /**
     * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
     * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
     *
     * @param token the JWT token to parse
     * @return the User object extracted from specified token or null if a token is invalid.
     */
    public User parseToken(String token) {
//        JWT jwt = JWT.decode(token);
//        Long expired_in = jwt.getClaim(CLAIM_KEY_EXPIRE).asDate().getTime();
//        if(expired_in < System.currentTimeMillis())
//        {
//            return null;
//        }
//        int id = jwt.getClaim(CLAIM_KEY_ID).asInt();
//        UserExample ue = new UserExample();
//        ue.createCriteria().andIdEqualTo(id);
//        return userMapper.selectByPrimaryKey(id);
        return null;
    }

    /**
     * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
     * User object. Tokens validity is infinite.
     *
     * @param u the user for which the token will be generated
     * @return the JWT token
     */
    public String generateToken(User u) {
//        try
//        {
//            return JWT.create()
//                    .withClaim(CLAIM_KEY_ID,u.getId())
//                    .withClaim(CLAIM_KEY_EXPIRE,new Date(System.currentTimeMillis() + expiration*1000))
//                    .sign(Algorithm.HMAC256(secret));
//        }
//        catch (UnsupportedEncodingException e)
//        {
//            return "";
//        }
        return "";
    }
}
