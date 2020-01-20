package mb.te.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Created By shenxi On 2020/1/20 13:49
 */
@Getter
@Setter
public class AppAuthUser {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String clientId;

    @Override
    public String toString() {
        return "{username=" + username + ", password=" + password + ", clientId=" + clientId + "}";
    }
}
