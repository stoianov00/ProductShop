package springproject.productshop.domain.dto.seed;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class UserSeedDto implements Serializable {
    @Expose
    private String firstName;

    @Expose
    @NotNull(message = "Last Name cannot be null")
    @Size(min = 3, message = "Last Name should be at least 3 characters")
    private String lastName;

    @Expose
    @Min(value = 0, message = "Age cannot be negative number")
    private Integer age;

    public UserSeedDto() {
    }

    public UserSeedDto(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
