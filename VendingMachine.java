/***********
 * Title: VendingMachine.java
 * Author: Kimberly Gaeta
 * Abstract: This  program is a vending machine that allows the user to pick
 * between options and buy items.
 * Date: 9/17/2023
 ***********/

import java.sql.SQLOutput;
import java.util.Scanner;
public class VendingMachine {

    private int name;
    private String location;
    private int water;
    private int waterSold;
    private int coffee;
    private int coffeeSold;
    private int chip;
    private int chipSold;
    private int choco;
    private int chocoSold;

    private double total;
    private double tax;
    private double totalEarnings;


    public VendingMachine() {
        name = 0;
        location = "UNKNOWN";
        water = 0;
        coffee = 0;
        chip = 0;
        choco = 0;
    }

    public VendingMachine(int name) {
        this.name = name;
        location = "UNKNOWN";
        water = 0;
        coffee = 0;
        chip = 0;
        choco = 0;
    }

    public VendingMachine(int name, String location) {
        this.name = name;
        this.location = location;
        water = 0;
        coffee = 0;
        chip = 0;
        choco = 0;
    }

    public boolean equals(VendingMachine other) {
        if ((this.water == other.water) && (this.coffee == other.coffee) &&
                (this.chip == other.chip) && (this.choco == other.choco)) {
            return true;
        }
        return false;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void reset(int water, int coffee, int chip, int choco) {
        this.water = water;
        this.coffee = coffee;
        this.chip = chip;
        this.choco = choco;
    }

    public void addItems(int water, int coffee, int chip, int choco) {
        this.water += water;
        this.coffee += coffee;
        this.chip += chip;
        this.choco += choco;
    }

    public String toString() {
        return String.format("Serial Number: %d%nLocation: %s%nContents:%n" +
                        "\tWater: %d%n\tCoffee: %d%n\tChips: %d%n\tChocolate: %d%n",
                name, location, water, coffee, chip, choco);
    }

    public void displayMenu() {
        System.out.println("\n===== Vending Maching =====");
        System.out.println(" 1. Water............$1.50");
        System.out.println(" 2. Coffee...........$2.00");
        System.out.println(" 3. Chips............$1.00");
        System.out.println(" 4. Chocolate........$2.50");
    }

    public boolean buyItem() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Select an item number: ");
        int item = kb.nextInt();
        System.out.println("How many do you want to buy?: ");
        int quantity = kb.nextInt();
        if (item == 1) {
            System.out.printf("You selected water. Quantity: %d%n", quantity);
            if (quantity > water) {
                System.out.println("Selection failed. We do not have enough water.");
                return false;
            }
            waterSold += quantity;
            water -= quantity;
            total += (quantity * 1.50);
            return true;
        } else if (item == 2) {
            System.out.printf("You selected coffee. Quantity: %d%n", quantity);
            if (quantity > coffee) {
                System.out.println("Selection failed. We do not have enough coffee.");
                return false;
            }
            coffeeSold += quantity;
            coffee -= quantity;
            total += (quantity * 2.00);
            return true;
        } else if (item == 3) {
            System.out.printf("You selected chips. Quantity: %d%n", quantity);
            if (quantity > chip) {
                System.out.println("Selection failed. We do not have enough chips.");
                return false;
            }
            chipSold += quantity;
            chip -= quantity;
            total += (quantity * 1.00);
            return true;
        } else if (item == 4) {
            System.out.printf("You selected chocolate. Quantity: %d%n", quantity);
            if (quantity > choco) {
                System.out.println("Selection failed. We do not have enough chocolate.");
                return false;
            }
            chocoSold += quantity;
            choco -= quantity;
            total += (quantity * 2.50);
            return true;
        }
        System.out.println("Selection failed. Invalid item number!");
        return false;
    }

    public boolean buyItem(int item, int quantity) {
        System.out.printf("Select an item number: %d%n", item);
        System.out.printf("How many do you want to buy?: %d%n", quantity);
        if (item == 1) {
            System.out.printf("You selected water. Quantity: %d%n", quantity);
            if (quantity > water) {
                System.out.println("Selection failed. We do not have enough water.");
                return false;
            }
            waterSold += quantity;
            water -= quantity;
            total += (quantity * 1.50);
            return true;
        } else if (item == 2) {
            System.out.printf("You selected coffee. Quantity: %d%n", quantity);
            if (quantity > coffee) {
                System.out.println("Selection failed. We do not have enough coffee.");
                return false;
            }
            coffeeSold += quantity;
            coffee -= quantity;
            total += (quantity * 2.00);
            return true;
        } else if (item == 3) {
            System.out.printf("You selected chips. Quantity: %d%n", quantity);
            if (quantity > chip) {
                System.out.println("Selection failed. We do not have enough chips.");
                return false;
            }
            chipSold += quantity;
            chip -= quantity;
            total += (quantity * 1.00);
            return true;
        } else if (item == 4) {
            System.out.printf("You selected chocolate. Quantity: %d%n", quantity);
            if (quantity > choco) {
                System.out.println("Selection failed. We do not have enough chocolate.");
                return false;
            }
            chocoSold += quantity;
            choco -= quantity;
            total += (quantity * 2.50);
            return true;
        }
        System.out.println("Selection failed. Invalid item number!");
        return false;
    }

    public void returned(int item, int quantity) {
        if (item == 1) {
            System.out.printf("You selected water. Quantity: %d%n", quantity);
            waterSold -= quantity;
            water += quantity;
            total -= (quantity * 1.50);
        } else if (item == 2) {
            System.out.printf("You selected coffee. Quantity: %d%n", quantity);
            coffeeSold -= quantity;
            coffee += quantity;
            total -= (quantity * 2.00);
        } else if (item == 3) {
            System.out.printf("You selected chips. Quantity: %d%n", quantity);
            chipSold -= quantity;
            chip += quantity;
            total -= (quantity * 1.00);
        } else if (item == 4) {
            System.out.printf("You selected chocolate. Quantity: %d%n", quantity);
            chocoSold -= quantity;
            choco += quantity;
            total -= (quantity * 2.50);
        }
    }

    public boolean payment() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter money amount: $");
        double input = kb.nextDouble();
        tax = total * 0.10;
        double tempTotal = tax + total;
        if (input == tempTotal) {
           total += tax;
            System.out.println("Sufficient money!");
            return true;
        } else if (input > tempTotal) {
            total += tax;
            input -= total;
            System.out.printf("Sufficient money! $%.2f returned.%n", input);
            return true;
        } else {
            System.out.printf("Insufficient money! $%.2f returned.%n", input);
            return false;
        }
    }

    public void displayReceipt() {
        if (waterSold != 0) {
            double wTotal = waterSold * 1.50;
            System.out.printf("Water: $1.50 x %d = $%.2f%n", waterSold, wTotal);
        }
        if (coffeeSold != 0) {
            double coTotal = coffeeSold * 2.00;
            System.out.printf("Coffee: $2.00 x %d = $%.2f%n", coffeeSold, coTotal);
        }
        if (chipSold != 0) {
            double chTotal = chipSold * 1.00;
            System.out.printf("Chips: $1.00 x %d = $%.2f%n", chipSold, chTotal);
        }
        if (chocoSold != 0) {
            double choTotal = chocoSold * 2.50;
            System.out.printf("Chocolate: $2.50 x %d = $%.2f%n", waterSold, choTotal);
        }
        System.out.print("Taxes (10.0%):");
        System.out.printf(" $%.2f%n", tax);
        System.out.printf("Total: $%.2f%n", total);
        totalEarnings += total;
        total = 0;
    }

    public void status() {
        System.out.printf("Serial Number: %d%nLocation: %s%n", name, location);
        System.out.printf("Sold Items: %n\tWater: %d%n\tCoffee: %d%n\tChips:" +
                " %d%n\tChocolate: %d%n", waterSold, coffeeSold, chipSold, chocoSold);
        System.out.printf("Current Contents: %n\tWater: %d%n\tCoffee: %d%n\tChips:" +
                " %d%n\tChocolate: %d%n", water, coffee, chip, choco);
        System.out.printf("Total Earnings: $%.2f%n", totalEarnings);
    }
}
