package main.auth.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    private String username;
    @Size(min = 3)
    @NotNull
    private String password;
}
