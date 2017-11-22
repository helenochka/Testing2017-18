public class Fixed_payment extends Employee{
    Fixed_payment(String full_name_, long id_, double money_){
        super(full_name_, id_,money_);
    }
    @Override
    public double salary() {
        return money;
    }
}
