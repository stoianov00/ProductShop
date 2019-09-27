package springproject.productshop.domain.dto.export;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class SoldProductDto implements Serializable {
    @Expose
    @SerializedName(value = "sellerFullName")
    private String seller;

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    @SerializedName(value = "buyerFullName")
    private String buyer;

    public SoldProductDto() {
    }

    public SoldProductDto(String seller, String name, BigDecimal price, String buyer) {
        this.seller = seller;
        this.name = name;
        this.price = price;
        this.buyer = buyer;
    }
}
