package springproject.productshop.domain.dto.seed;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductSeedDto implements Serializable {
    @Expose
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name should be at least 3 characters")
    private String name;

    @Expose
    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative number")
    private BigDecimal price;

//    @Expose
//    private User seller;
//
//    @Expose
//    private User buyer;

    public ProductSeedDto() {
    }

}
