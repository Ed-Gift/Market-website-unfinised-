@Entity
public class Withdrawal {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;

    private boolean approved;

    @ManyToOne
    private User seller;
}