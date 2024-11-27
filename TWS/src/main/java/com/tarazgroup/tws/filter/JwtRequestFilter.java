package com.tarazgroup.tws.filter;

import com.tarazgroup.tws.service.JwtUserDetailsService;
import com.tarazgroup.tws.util.security.JWTTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;


/**
 * <p> this class will call before any endpoints and validates token_string of the given {@link HttpServletRequest}</p>
 *
 * @author alireza_bayat
 * @see OncePerRequestFilter
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {


    final private JwtUserDetailsService userDetailsService;

    final private JWTTokenUtil jwtUtil;

    @Autowired
    public JwtRequestFilter(JwtUserDetailsService userDetailsService, JWTTokenUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }


    /**
     * <p>
     * validates each {@link HttpServletRequest} by it's token_string
     * will continue the chain after validation
     * </p>
     *
     * @throws ExpiredJwtException
     * @throws org.springframework.security.authentication.InternalAuthenticationServiceException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try {
            final String authorizationHeader = request.getHeader("Authorization");
            String userID = null;
            String jwt = null;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                userID = jwtUtil.getUserIDFromToken(jwt);
            }

            if (userID != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUserID(new BigDecimal(userID));
                if (jwtUtil.validateToken(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }

        } catch (ExpiredJwtException e) {
            String requestURL = request.getRequestURL().toString();
            if (requestURL.contains("refreshtoken")) {
                allowForRefreshToken(e, request);
            } else
                request.setAttribute("exception", e);
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,Accept,X-Requested-With,Authorization");
            response.setHeader("Access-Control-Expose-Headers", "meta");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json; charset=utf-8");

            // کد زیر اگر اعمال شود خطا می دهد
//            JSONArray jsonArrayErrors=new JSONArray();
//            JSONObject jsonObjectEng=new JSONObject();
//            jsonObjectEng.put("name" ,"eng");
//            jsonObjectEng.put("value" ,"The following token is expired!");
//            JSONObject jsonObjectPer=new JSONObject();
//            jsonObjectPer.put("name" ,"per");
//            jsonObjectPer.put("value" ,"توکن منقضی شده است!");
//            jsonArrayErrors.add(jsonObjectEng);
//            jsonArrayErrors.add(jsonObjectPer);
//            JSONObject jsonObject=new JSONObject();
//            jsonObject.put("error" ,"Unauthorized");
//            jsonObject.put("message" ,null);
//            jsonObject.put("path" ,request.getServletPath());
//            jsonObject.put("status" ,401);
//            jsonObject.put("errors" ,jsonArrayErrors);
//            response.getWriter().write(jsonObject.toJSONString());
//            response.getWriter().flush();
//            response.getWriter().close();
            //****************************************************************
        }
        chain.doFilter(request, response);
    }

    private void allowForRefreshToken(ExpiredJwtException ex, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                null, null, null);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        request.setAttribute("claims", ex.getClaims());
    }
}
