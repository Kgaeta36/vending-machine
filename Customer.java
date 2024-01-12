public class Customer {
    private String custName;
    private int ssn;
    private String addr;

    public Customer(){
    }
    public Customer(String custName, int ssn, String addr){
        this.custName = custName;
        this.ssn = ssn;
        this.addr = addr;
    }
    public boolean ssnEquals(int ssn){
        return (this.ssn == ssn);
    }
    public int getSsn() {
        return ssn;
    }

    public String getAddr() {
        return addr;
    }

    public String getCustName() {
        return custName;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    public String toString(){
        return String.format("Customer: %s%n%s%nSSN: %d%n", custName, addr, ssn);
    }
    public String miniString(){
        return String.format(" %s: %d%n", custName,ssn);
    }
}

