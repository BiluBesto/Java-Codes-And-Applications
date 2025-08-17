import java.util.Scanner;
import java.util.Arrays;

class Working {
    String prodPrice[][]; // [product][0] = name, [product][1] = price
    double priceTotal[];  // total price for each customer
    int quantity[];       // quantity per product
    int customerId[];     // IDs of customers
    String transDetails[][]; // products bought by each customer
    int ct, n, c; // ct: product count, n: total products, c: total customers

    void putInStock(Scanner s) {
        System.out.println("Enter the no of unique products:");
        while ((n = s.nextInt()) <= 0) {
            System.out.println("Enter valid number!");
        }

        prodPrice = new String[n][2];
        quantity = new int[n];
        s.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.println("Enter name of product " + (i + 1) + ":");
                String name = s.nextLine();
                boolean conflict = false;

                for (int j = 0; j < i; j++) {
                    if (name.equalsIgnoreCase(prodPrice[j][0])) {
                        System.out.println("Enter different product name!");
                        conflict = true;
                        break;
                    }
                }

                if (!conflict) {
                    prodPrice[i][0] = name;
                    break;
                }
            }

            while (true) {
                System.out.println("Enter price:");
                String price = s.nextLine();
                try {
                    Double.parseDouble(price);
                    prodPrice[i][1] = price;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Enter valid numeric value!");
                }
            }

            while (true) {
                System.out.println("Enter quantity:");
                int q = s.nextInt();
                if (q > 0) {
                    quantity[i] = q;
                    s.nextLine(); // consume newline
                    break;
                } else {
                    System.out.println("Enter valid quantity (>0)!");
                }
            }
        }
    }

    void buyItems(Scanner s, int j) {
        s.nextLine(); // consume newline
        for (int k = 0; k < transDetails[j].length; k++) {
            System.out.println("Enter the name of product " + (k + 1) + ":");
            String temp = s.nextLine();
            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (temp.equalsIgnoreCase(prodPrice[i][0])) {
                    found = true;
                    if (quantity[i] != 0) {
                        int tp = Integer.parseInt(prodPrice[i][1]);
                        priceTotal[j] += tp;
                        quantity[i]--;
                        transDetails[j][k] = temp;
                        System.out.println(temp + " added to cart.");
                    } else {
                        System.out.println("Product is out of stock.");
                        k--; // ask again
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("No such product!");
                k--; // ask again
            }
        }
    }

    void dispIndiv(int cid) {
        int index = -1;
        for (int i = 0; i < c; i++) {
            if (customerId[i] == cid) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Customer ID not found.");
            return;
        }

        System.out.println("Customer ID: " + customerId[index]);
        System.out.println("No of products bought: " + transDetails[index].length);
        System.out.println("Products:");
        for (String prod : transDetails[index]) {
            System.out.println(" - " + prod);
        }
        System.out.println("Total price paid: " + priceTotal[index]);
    }

    void dispTotal() {
        System.out.println("Total no of customers: " + c);
        double totalPrice = 0;
        int totalItems = 0;

        for (int i = 0; i < c; i++) {
            totalPrice += priceTotal[i];
            totalItems += transDetails[i].length;
        }

        System.out.println("Total price: " + totalPrice);
        System.out.println("Total items bought: " + totalItems);
    }

    void addToStock(Scanner s) {
        s.nextLine();
        System.out.println("Enter name of product:");
        String temp = s.nextLine();
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (temp.equalsIgnoreCase(prodPrice[i][0])) {
                flag = true;
                System.out.println("Enter quantity to add:");
                int t = s.nextInt();
                quantity[i] += t;
                System.out.println("New quantity of " + temp + " is " + quantity[i]);
                break;
            }
        }

        if (!flag) {
            System.out.println("Product not found in stock.");
        }
    }

    void customerAdd(Scanner s) {
        System.out.println("Enter total no of customers:");
        while ((c = s.nextInt()) <= 0) {
            System.out.println("Enter valid number!");
        }

        customerId = new int[c];
        transDetails = new String[c][];
        priceTotal = new double[c];

        for (int i = 0; i < c; i++) {
            System.out.println("Customer " + (i + 1) + ":");
            System.out.print("Enter Customer ID: ");
            customerId[i] = s.nextInt();

            System.out.print("Enter no of unique products to buy: ");
            int k = s.nextInt();
            transDetails[i] = new String[k];

            buyItems(s, i);
        }
    }
}
public class transactions {
    public static void main(String[] args) {
        Working obj = new Working();
        Scanner s = new Scanner(System.in);
        int ch;

        System.out.println("---Number = Operation---");
        System.out.println("1 = Stock Items");
        System.out.println("2 = Add Customers and Purchase Items");
        System.out.println("3 = Display Individual Customer Details");
        System.out.println("4 = Display Total Summary");
        System.out.println("5 = Add to Existing Stock");
        System.out.println("6 = Exit");

        while (true) {
            System.out.println("\nEnter a number:");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    obj.putInStock(s);
                    break;
                case 2:
                    obj.customerAdd(s);
                    break;
                case 3:
                    System.out.print("Enter Customer ID to display: ");
                    int cid = s.nextInt();
                    obj.dispIndiv(cid);
                    break;
                case 4:
                    obj.dispTotal();
                    break;
                case 5:
                    obj.addToStock(s);
                    break;
                case 6:
                    System.out.println("Program End!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid number (1-6)!");
            }
        }
    }
}