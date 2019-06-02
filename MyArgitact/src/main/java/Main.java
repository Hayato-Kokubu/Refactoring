public class Main {
  public static void main(String[] args) {

    Customer c1 = new Customer("c1");
    c1.addRental( new Rental( new Movie("m1", Movie.REGULAR), 1));
    c1.addRental( new Rental( new Movie("m2", Movie.CHILDRENS), 3));
    c1.addRental( new Rental( new Movie("m3", Movie.NEW_RELEASE), 2));
    c1.addRental( new Rental( new Movie("m4", Movie.REGULAR), 5));

    System.out.println(c1.statement());

  }
}
