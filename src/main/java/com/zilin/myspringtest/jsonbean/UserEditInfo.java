package com.zilin.myspringtest.jsonbean;

import com.zilin.myspringtest.util.RegisterVaild;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEditInfo {
    @Min(value = 10000, groups = {edit.class}, message = "User information is incorrect")
    private int userId;
    @NotBlank(message = "Username cam't be null", groups = {register.class})
    @Pattern(regexp = "^(?=.*[A-Za-z])[A-Za-z0-9]{8,16}$", message = "Username format is incorrect", groups = {register.class, edit.class})
    private String userName;
    @NotBlank(message = "Password can't be null", groups = {register.class})
    @RegisterVaild(message = "Password format is incorrect", groups = {register.class, edit.class})
    private String userPassword;
    @NotBlank(message = "Repassword can't be null", groups = {register.class})
    private String userPassword2;
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message = "Email format is incorrect", groups = {register.class, edit.class})
    private String userMail;
    @Pattern(regexp = "^((?!\\s).){4,20}$", message = "Nickname format is incorrect", groups = {register.class, edit.class})
    private String nickName;

    public interface register{}
    public interface edit{}
}
