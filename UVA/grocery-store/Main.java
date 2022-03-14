public class Main {
    public static void main(String[] args) {
        int largestPrice = (int) (2 * Math.pow(10, 9));

        for (int price1 = 1; price1 <= 2000; price1++) {
            if (Math.pow(price1, 4) > largestPrice) {
                break;
            }

            for (int price2 = price1; price2 <= 2000 - price1; price2++) {
                if (price1 * Math.pow(price2, 3) > largestPrice) {
                    break;
                }

                for (int price3 = price2; price3 <= 2000 - price1 - price2; price3++) {
                    if (price1 * price2 * Math.pow(price3, 2) > largestPrice) {
                        break;
                    }

                    int priceCollapse = price1 * price2 * price3;
                    int constant = 1000000;

                    if (priceCollapse == constant) {
                        continue;
                    }

                    int priceSumConstant = price1 + price2 + price3;

                    int constantSum = constant * priceSumConstant;
                    int collapseEquation = priceCollapse - constant;

                    // This must be 0 since, then we would have fractional cents in the solution
                    if (constantSum % collapseEquation != 0) {
                        continue;
                    }

                    int price4 = constantSum / collapseEquation;

                    // Price 3 must not exceed Price 4 since that would break the assignment row
                    if (price3 > price4) {
                        continue;
                    }

                    // Every price summed must not exceed 20 euros
                    if (priceSumConstant + price4 > 2000) {
                        continue;
                    }

                    // The fully collapsed prices must not exceed the largest price limit
                    if (priceCollapse * price4 > largestPrice) {
                        continue;
                    }

                    // Somebody posted this printing solution and I thought it was the most simple and brilliant way to display it.
                    System.out.printf("%d.%02d %d.%02d %d.%02d %d.%02d\n",
                            price1 / 100, price1 % 100, price2 / 100, price2 % 100, price3 / 100, price3 % 100, price4 / 100, price4 % 100);
                }
            }
        }
    }
}