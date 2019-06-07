public class Main {
  public static void main(String[] args) {

    System.out.println("### 動作確認 ###");
    Customer c1 = new Customer("c1");
    c1.addRental( new Rental( new Movie("m1", Movie.REGULAR), 1));
    c1.addRental( new Rental( new Movie("m2", Movie.CHILDRENS), 3));
    c1.addRental( new Rental( new Movie("m3", Movie.NEW_RELEASE), 2));
    c1.addRental( new Rental( new Movie("m4", Movie.REGULAR), 5));

    System.out.println(c1.statement());

    System.out.println("### culcAmountテスト ###");

    System.out.println("### 一般向け: 2日以内 ###");
    Rental testRental1 = new Rental(new Movie("m1", Movie.REGULAR), 2);
    if( c1.culcAmount(testRental1) != 2.0) System.out.println("一般向け: 2日以内  NG") ;

    System.out.println("### 一般向け: 3日以降 ###");
    Rental testRental2 = new Rental(new Movie("m1", Movie.REGULAR), 3);
    if( c1.culcAmount(testRental2) != 3.5) System.out.println("一般向け: 3日以降  NG") ;


    System.out.println("### 新作 ###");
    Rental testRental3 = new Rental(new Movie("m1", Movie.NEW_RELEASE), 5);
    if( c1.culcAmount(testRental3) != 15.0) System.out.println("新作  NG") ;


    System.out.println("### 子供向け: 3日以内 ###");
    Rental testRental4 = new Rental(new Movie("m1", Movie.CHILDRENS), 3);
    if( c1.culcAmount(testRental4) != 1.5) System.out.println("子供向け: 3日以内  NG") ;


    System.out.println("### 子供向け: 4日以降 ###");
    Rental testRental5 = new Rental(new Movie("m1", Movie.CHILDRENS), 4);
    if( c1.culcAmount(testRental5) != 3.0) System.out.println("子供向け: 4日以降  NG") ;


    System.out.println("### culcFrequentRenterPointsテスト ###");

    System.out.println("### 映画種に関わらず1ポイント付加 ###");
    Rental testRental6 = new Rental(new Movie("m1", Movie.REGULAR), 1);
    if( c1.culcFrequentRenterPoints(testRental6) != 1) System.out.println("映画種に関わらず1ポイント付加 NG") ;

    System.out.println("### 新作2日以上でさらに1ポイント付加###");
    Rental testRental7 = new Rental(new Movie("m1", Movie.NEW_RELEASE), 2);
    if( c1.culcFrequentRenterPoints(testRental7) != 2) System.out.println("新作2日以上でさらに1ポイント付加 NG") ;

    System.out.println("### 新作1日では1追加でポイント付加はなし###");
    Rental testRental8 = new Rental(new Movie("m1", Movie.NEW_RELEASE), 1);
    if( c1.culcFrequentRenterPoints(testRental8) != 1) System.out.println("新作1日では1追加でポイント付加はなし NG") ;

  }
}
