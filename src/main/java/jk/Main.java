package jk;

import jk.services.Store;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    final var store = new Store();

    try {
      final var rentalAgreement = store.checkout(
              args[0],
              LocalDate.parse(args[1]),
              Integer.parseInt(args[2]),
              Integer.parseInt(args[3])
      );

      System.out.println(rentalAgreement.format());
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
