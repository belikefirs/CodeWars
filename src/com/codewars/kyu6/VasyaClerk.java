package com.codewars.kyu6;

import java.util.ArrayList;
import java.util.List;

public class VasyaClerk {
    public static String tickets(int[] peopleInLine) {
        List<Bill> oneHundred = new ArrayList<>();
        List<Bill> fifty = new ArrayList<>();
        List<Bill> twentyFive = new ArrayList<>();

        for (int people : peopleInLine) {
            if (people == Bill.TWENTY_FIVE.getMoneyValue()) {
                twentyFive.add(Bill.TWENTY_FIVE);
                continue;
            }
            if (people == Bill.FIFTY.getMoneyValue()) {
                if (twentyFive.size() >= 1) {
                    twentyFive.remove(twentyFive.size() - 1);
                    fifty.add(Bill.FIFTY);
                    continue;
                }
                return "NO";
            }
            if (people == Bill.ONE_HUNDRED.getMoneyValue()) {
                if (twentyFive.size() >= 1 && fifty.size() >= 1) {
                    twentyFive.remove(twentyFive.size() - 1);
                    fifty.remove(fifty.size() - 1);
                    oneHundred.add(Bill.ONE_HUNDRED);
                    continue;
                } else if (twentyFive.size() >= 3) {
                    twentyFive.remove(twentyFive.size() - 1);
                    twentyFive.remove(twentyFive.size() - 1);
                    twentyFive.remove(twentyFive.size() - 1);
                    oneHundred.add(Bill.ONE_HUNDRED);
                    continue;
                }
                return "NO";
            }
        }
        return "YES";
    }

    enum Bill {
        ONE_HUNDRED(100),
        FIFTY(50),
        TWENTY_FIVE(25);

        Bill(final Integer moneyValue) {
            this.moneyValue = moneyValue;
        }

        private Integer moneyValue;

        public Integer getMoneyValue() {
            return moneyValue;
        }
    }

    public static void main(String[] args) {
        System.out.println(tickets(new int[]{25, 25, 50}));
        System.out.println(tickets(new int[]{25, 100}));
        System.out.println(tickets(new int[]{25, 25, 50, 50, 100}));
    }
}
