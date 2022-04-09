package miu.edu.demo.service;

import miu.edu.demo.domain.LoginRequest;
import miu.edu.demo.domain.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
}
