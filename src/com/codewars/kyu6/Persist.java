package com.codewars.kyu6;

class Persist {
  public static int persistence(long n) {
    String numberStr;
    int count = 0;

    while (n > 9) {
      numberStr = String.valueOf(n);
      String[] split = numberStr.split("");
      n = 0;

      for (int i = 0; i < split.length; i++) {
        if (i == 0)
          n = Long.valueOf(split[i]);
        else
          n *= Long.valueOf(split[i]);
      }
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(persistence(4));
  }
}