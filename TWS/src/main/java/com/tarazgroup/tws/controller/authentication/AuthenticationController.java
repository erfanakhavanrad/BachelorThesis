package com.tarazgroup.tws.controller.authentication;


import com.tarazgroup.tws.dao.UserPrincipal;
import com.tarazgroup.tws.model.authentication.AuthenticationRequest;
import com.tarazgroup.tws.model.authentication.AuthenticationResponse;
import com.tarazgroup.tws.service.JwtUserDetailsService;
import com.tarazgroup.tws.util.exception.TUnAuthorizedException;
import com.tarazgroup.tws.util.exception.TktInvalidTokenException;
import com.tarazgroup.tws.util.security.JWTTokenUtil;
import io.jsonwebtoken.impl.DefaultClaims;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * <p>
 * the following Controller is the only EndPoint which does not require token_string
 * </p>
 *
 * @author alireza_bayat
 * @since 2.0.0
 */

@RequestMapping("authenticate")
@RestController
@Tag(name = "Authentication", description = "First of all you should login by prepared username and password")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JWTTokenUtil jwtTokenUtil;

    private final JwtUserDetailsService userDetailsService;


    @PersistenceContext
    EntityManager entityManager;

    @Value("${jwt.expirationDateInMs}")
    private int expirationDateInMs;

    @Value("${jwt.refreshExpirationDateInMs}")
    private int refreshExpirationDateInMs;

    @Value("${SystemID}")
    private BigDecimal systemID;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
                                    JWTTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    /**
     * <p>
     * according to the username and password, will generate and pass token to
     * the user
     * </p>
     * <p>
     * authentication process will be on "username + $$$$ + password"
     * after validation was granted there will be an insert in logLogins table
     * </p>
     */
    @Operation(
            summary = "Generate token",
            description = "<code>Authenticate</code> user and <code>Generate</code> <i><b>token</b></i>." +
                    "<br/><br/>" +
                    "use generated <i><b>token</b></i> for <code>Authorization</code> by clicking <code>Authorize</code> button at the top of the page."

    )
    @PostMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//                try {
//            TimeUnit.SECONDS.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int g = 1/0;
        String hashedUserNameAndPassword = md5Generator(authenticationRequest.getUsername() + "$$$$" + authenticationRequest.getPassword());
        authenticate(hashedUserNameAndPassword, hashedUserNameAndPassword);
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(hashedUserNameAndPassword);

        UserPrincipal userPrincipal = (UserPrincipal) userDetails;
        StoredProcedureQuery storedProcedureQuery =
                entityManager
                        .createNamedStoredProcedureQuery("LogInsLogins")
                        .setParameter("UserID", userPrincipal.getUserID())
                        .setParameter("WindowsLoginName", "")
                        .setParameter("ComputerName", "SPRING_BOOT_API")
                        .setParameter("WindowsVersion", "SPRING_BOOT_API")
                        .setParameter("IsActive", userPrincipal.isEnabled())
                        .setParameter("LoginTimeStr", "")
                        .setParameter("SystemID", systemID)
                        .setParameter("IpNumber", "SPRING_BOOT_API")
                        .setParameter("DeviceType", 3)
                        .setParameter("JAX_RS_Token", "token")
                        .setParameter("JAX_RS_Token_Expire_Time", BigDecimal.valueOf(expirationDateInMs));

        storedProcedureQuery.execute();
        if (new BigDecimal(storedProcedureQuery.getOutputParameterValue("Result").toString()).intValue() != 0 && (new BigDecimal(storedProcedureQuery.getOutputParameterValue("Result").toString()).intValue() == -460) || (new BigDecimal(storedProcedureQuery.getOutputParameterValue("Result").toString()).intValue() == -466)) {
            System.out.println(storedProcedureQuery.getOutputParameterValue("ErrMsg").toString());
            String errorMessage = storedProcedureQuery.getOutputParameterValue("ErrMsg").toString();
            throw new TktInvalidTokenException(errorMessage);
        } else if (new BigDecimal(storedProcedureQuery.getOutputParameterValue("Result").toString()).intValue() != 0) {
            throw new TUnAuthorizedException(storedProcedureQuery.getOutputParameterValue("ErrMsg").toString());
        }
        BigDecimal newID = new BigDecimal(storedProcedureQuery.getOutputParameterValue("New" + "ID").toString());
//        if (tResult.getResult().intValue() != 0)
//            return ResponseEntity.ok(tResult.toString());
        final String token = jwtTokenUtil.generateToken(userPrincipal.getUserID(), newID, userPrincipal.getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(token, expirationDateInMs));
    }

    //Original createAuthenticationToken
    /*

       public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//                try {
//            TimeUnit.SECONDS.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int g = 1/0;
        String hashedUserNameAndPassword = md5Generator(authenticationRequest.getUsername() + "$$$$" + authenticationRequest.getPassword());
        authenticate(hashedUserNameAndPassword, hashedUserNameAndPassword);
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(hashedUserNameAndPassword);

        UserPrincipal userPrincipal = (UserPrincipal) userDetails;
        StoredProcedureQuery storedProcedureQuery =
                entityManager
                        .createNamedStoredProcedureQuery("LogInsLogins")
                        .setParameter("UserID", userPrincipal.getUserID())
                        .setParameter("WindowsLoginName", "")
                        .setParameter("ComputerName", "SPRING_BOOT_API")
                        .setParameter("WindowsVersion", "SPRING_BOOT_API")
                        .setParameter("IsActive", userPrincipal.isEnabled())
                        .setParameter("LoginTimeStr", "")
                        .setParameter("SystemID", systemID)
                        .setParameter("IpNumber", "SPRING_BOOT_API")
                        .setParameter("DeviceType", 3)
                        .setParameter("JAX_RS_Token", "token")
                        .setParameter("JAX_RS_Token_Expire_Time", BigDecimal.valueOf(expirationDateInMs));

        storedProcedureQuery.execute();
        if (new BigDecimal(storedProcedureQuery.getOutputParameterValue("Result").toString()).intValue() != 0)
            throw new TUnAuthorizedException(storedProcedureQuery.getOutputParameterValue("ErrMsg").toString());
        BigDecimal newID = new BigDecimal(storedProcedureQuery.getOutputParameterValue("New" + "ID").toString());
//        if (tResult.getResult().intValue() != 0)
//            return ResponseEntity.ok(tResult.toString());
        final String token = jwtTokenUtil.generateToken(userPrincipal.getUserID(), newID, userPrincipal.getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(token, expirationDateInMs));
    }

     */

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @Operation(
            summary = "Refresh token",
            description = "<code>Refresh</code> <i><b>token</b></i>." +
                    "<br/><br/>" +
                    "use refreshed <i><b>token</b></i> for <code>Authorization</code> by clicking <code>Authorize</code> button at the top of the page." +
                    "<br/><br/>" +
                    "if previous <i><b>token</b></i> is <code>Expired</code> , no need <code>Generate</code> <i><b>token</b></i> again . just call refresh token.",
            security = @SecurityRequirement(name = "bearerAuth")

    )
    @GetMapping(value = "/refreshtoken", produces = "application/json;charset=utf-8")
    public ResponseEntity<AuthenticationResponse> refreshtoken(
            HttpServletRequest request
    ) {
//        try {
//            TimeUnit.SECONDS.sleep(6);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        DefaultClaims defaultClaims = (DefaultClaims) request.getAttribute("claims");
        if (defaultClaims == null) {//این توکن هنوز اکسپایر نشده و خودش ریترن می شود
            String authentication = request.getHeader("Authorization");
            String token = authentication.substring(7);
            return ResponseEntity.ok(new AuthenticationResponse(token, refreshExpirationDateInMs));
        }
        String refreshedToken = jwtTokenUtil.doGenerateRefreshToken(defaultClaims);
        return ResponseEntity.ok(new AuthenticationResponse(refreshedToken, refreshExpirationDateInMs));
    }

    /**
     * <p>
     * md5 generator
     * </p>
     */
    private String md5Generator(String webUserPass) throws NoSuchAlgorithmException {
        MessageDigest m;
        m = MessageDigest.getInstance("MD5");
        byte[] data = webUserPass.getBytes(StandardCharsets.UTF_8);
        m.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, m.digest());
        return String.format("%1$032X", i);
    }

}


