package miu.edu.demo.service.impl;

import miu.edu.demo.domain.LoginRequest;
import miu.edu.demo.domain.LoginResponse;
import miu.edu.demo.security.JwtTokenManager;
import miu.edu.demo.security.JwtUserDetailsService;
import miu.edu.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenManager jwtTokenManager;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUserName());
        String accessToken = jwtTokenManager.generateJwtToken(userDetails);
//        String refreshToken = jwtTokenManager.generateRefreshToken(loginRequest.getEmail());
        LoginResponse newResponse = new LoginResponse(accessToken);
        return newResponse;
    }
}
