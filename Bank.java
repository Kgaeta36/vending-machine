public class Bank {
    private String bankName;
    private Account[] accounts;
    private int numAccounts;


    public Bank(){}
    public Bank (String bankName){
        this.bankName = bankName;
        accounts = new Account[5];
        numAccounts = 0;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public int getNumAccounts() {
        return numAccounts;
    }

    public void setNumAccounts(int numAccounts) {
        this.numAccounts = numAccounts;
    }
    public double getAccBal(int accNr) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccNr() == accNr) {
                return accounts[i].getBalance();
            }
        }
        return 0.0;
    }
    public String getAccAddr(int accNr){
        for (int i = 0; i < numAccounts; i++) {
            if(accounts[i].getAccNr() == accNr){
                return accounts[i].getAccAddr();
            }
        }
        return "Invalid Account Number!";
    }

    public  boolean openAcc(String custName, String addr, int ssn,
                            int accNr, int accType, double balance) {
        if (numAccounts >= 5){
        return false;
        }
        for (int i = 0; i < numAccounts; i++) {
            if(accounts[i].accEquals(accNr,ssn)){
                return false;
            }
        }
        accounts[numAccounts] = new Account(custName, ssn , addr, accNr,accType,balance);
        numAccounts++;
        return true;
    }
    public boolean closeAcc(int accNr){
        for (int i = 0; i < numAccounts; i++) {
            if(accNr == accounts[i].getAccNr()){
                for (int j = i; j < numAccounts ; j++) {
                    accounts[j] = accounts[j+1];
                }
                numAccounts--;
                return true;
            }
        }
        return false;
    }

    public double sumAccBal(){
        double sum = 0.0;
        for (int i = 0; i < numAccounts; i++) {
            sum += accounts[i].getBalance();
        }
        return sum;
    }

    public boolean updateBal(int accNr, double amount){
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccNr() == accNr) {
                accounts[i].setBalance(amount);
                return true;
            }
        }
        return false;
    }
    public boolean accInfo(int accNr){
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccNr() == accNr) {
                System.out.println(accounts[i].toString());
                return true;
            }
        }
        return false;
    }
    public void bankInfo(){
        System.out.printf("Bank Name: %s%nNumber of Accounts: %d%n",bankName, numAccounts);
        for (int i = 0; i < numAccounts; i++) {
            System.out.print(accounts[i].miniAccString());
        }
        System.out.printf("Bank Total Balance: $%.2f%n", sumAccBal());
    }
    public boolean updateAddr(int accNr, String addr){
        for (int i = 0; i < numAccounts; i++) {
            if(accounts[i].getAccNr() == accNr){
                accounts[i].setAccAddr(addr);
                return true;
            }
        }
        return false;
    }
}
