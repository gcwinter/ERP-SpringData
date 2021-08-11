package br.com.gabriel.winter.ERP_ALURA.ORM;


import javax.persistence.*;

@Entity
@Table(name = "Product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productType;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
                this.productType = productType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
