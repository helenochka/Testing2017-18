public class Hourly_payment extends Employee {
    Hourly_payment(String full_name_, long id_, double money_){
        super(full_name_, id_, money_);
    }
    @Override
    public double salary(){
        return 20.8 * 8 * money;
    }
}
