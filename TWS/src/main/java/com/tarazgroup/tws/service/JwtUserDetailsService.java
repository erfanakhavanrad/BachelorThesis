package com.tarazgroup.tws.service;

import com.tarazgroup.tws.dao.UserPrincipal;
import com.tarazgroup.tws.model.pub.PubUser;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * custom implementation of {@link UserDetailsService}
 * to customize validation according to the Taraz DB
 * </p>
 *
 * @author salman majidi
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public UserDetails loadUserByUsername(String username) {
        Query query = entityManager.createQuery("select o from PubUser o where " +
                "o.androidUserPass = :webUserPass ")
                .setParameter("webUserPass", username);
        List<PubUser> pubUsers = query.getResultList();
        if (pubUsers.size() > 1)
            throw new InternalAuthenticationServiceException(" Developer validation failed :-{ ");
        PubUser pubUser = pubUsers.get(0);
        if (pubUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(pubUser.getUserID(), pubUser.getAndroidUserPass(), pubUser.getIsActive());
    }


    public UserDetails loadUserByUserID(BigDecimal userID) {
        Query query = entityManager.createQuery("select o from PubUser o where " +
                "o.userID = :userID ")
                .setParameter("userID", userID);
        List<PubUser> pubUsers = query.getResultList();
        if (pubUsers.size() > 1)
            throw new InternalAuthenticationServiceException(" Developer validation failed :-{ ");
        PubUser pubUser = pubUsers.get(0);
        if (pubUser == null) {
            throw new UsernameNotFoundException(pubUser.getAndroidUserPass());
        }
        return new UserPrincipal(pubUser.getUserID(), pubUser.getAndroidUserPass(), pubUser.getIsActive());
    }

}



