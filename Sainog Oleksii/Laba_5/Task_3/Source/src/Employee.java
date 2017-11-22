public abstract class Employee {
    public String full_name;
    public long id;
    public double money;
    public abstract double salary();
    Employee(String full_name_, long id_, double money_){
        full_name = full_name_;
        id = id_;
        money = money_;
    }

    @Override
    public String toString() {
        return full_name + " " + id + " " + String.format("%.2f", salary());
    }

    public int compareTo(Employee e1){
        int dis_val = Double.compare(this.salary(),e1.salary());
        if(dis_val!=0){
            return - dis_val;
        }
        else return this.full_name.compareToIgnoreCase(e1.full_name);
    }
}
