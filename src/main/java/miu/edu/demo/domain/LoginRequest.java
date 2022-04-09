package miu.edu.demo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String userName;
    private String password;
}
