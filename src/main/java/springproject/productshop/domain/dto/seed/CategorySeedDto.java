package springproject.productshop.domain.dto.seed;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class CategorySeedDto implements Serializable {
    @Expose
    @Size(min = 3, max = 15, message = "Name should be between 3 and 15 characters")
    private String name;

    public CategorySeedDto() {
    }

}
