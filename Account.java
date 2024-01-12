public class Account {
    private int accNr;
    private int accType;
    private Customer accHolder;
    private double balance;

    public Account(){}
    public Account(String custName, int ssn, String addr,
                   int accNr, int accType, double balance){
        this.accHolder = new Customer(custName,ssn,addr);
        this.accNr = accNr;
        this.accType = accType;
        this.balance = balance;
    }
    public Account(Account other){
//        if (other == null){
//            System.out.println("Fatal Error");
//            System.exit(0);
//        }
        accHolder = other.accHolder;
        accNr = other.accNr;
        accType = other.accType;
        balance = other.balance;
    }


    public boolean accEquals(int accNr, int ssn ) {
        return (this.accNr == accNr || accHolder.ssnEquals(ssn) );
    }

    public Customer getAccHolder() {
        return accHolder;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccNr() {
        return accNr;
    }



    public void setAccHolder(Customer accHolder) {
        this.accHolder = accHolder;
    }
    public void setAccAddr(String addr){
        accHolder.setAddr(addr);
    }

    public void setAccNr(int accNr) {
        this.accNr = accNr;
    }

    public void setAccType(int accType) {
        this.accType = accType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getAccAddr(){
        return accHolder.getAddr();
    }
    public String toString(){
        if (accType == 1){
            return String.format("Account Number: %d%nChecking account%nBalance: $%.2f%n%n",
                    accNr,balance) + accHolder.toString();
        } else{
            return String.format("Account Number: %d%nSavings account%nBalance: $%.2f%n%n",
                    accNr,balance) + accHolder.toString();
        }

    }
    public String miniAccString(){
        return String.format("\t%d: $%.2f -%s", accNr, balance, accHolder.miniString());
    }
    public int getAccType() {
        return accType;
    }
}
