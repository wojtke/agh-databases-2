import javax.persistence.*;
import java.util.Set;

@Entity
public class Supplier {
    public Supplier() { }

    public Supplier(String CompanyName, String Street, String City) {
        this.CompanyName = CompanyName;
        this.Street = Street;
        this.City = City;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String CompanyName;
    public String Street;
    public String City;

    @OneToMany
    public Set<Product> Products;

}
