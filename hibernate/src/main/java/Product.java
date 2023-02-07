import javax.persistence.*;

@Entity
public class Product {
    public Product() {}
    public Product(String productName, int unitsOnStock) {
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String productName;
    public int unitsOnStock;

    @ManyToOne
    private Supplier supplier;

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}