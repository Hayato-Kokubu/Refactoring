import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Customer {
  private String _name;
  private List<Rental> _rentals = new ArrayList<Rental>();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg){
    _rentals.add(arg);
  }

  public String getName() {
    return _name;
  }

  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    Iterator<Rental> rentals = _rentals.iterator();
    String result = "Rental Record for " + getName() + "\n";
    while (rentals.hasNext()) {
      double thisAmount = 0;
      Rental each = rentals.next();

      thisAmount = culcAmount(each);
      frequentRenterPoints = culcFrequentRenterPoints(each);

      //この貸し出しに関する数値の表示
      result += "\t" + each.getMovie().getTitle() + "\t" +
        String.valueOf(thisAmount) + "\n";
      totalAmount = thisAmount;
    }
    //フッタ部分の追加
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

    return result;
  }

  int culcFrequentRenterPoints(Rental each){
    int frequentRenterPoints = 0;
    //レンタルポイントを加算
    frequentRenterPoints++;
    //新作を二日以上借りた場合はボーナスポイント
    if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
      frequentRenterPoints ++;

    return frequentRenterPoints;
  }

  double culcAmount(Rental each){
    double thisAmount = 0;

    switch (each.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        thisAmount += 2;
        if (each.getDaysRented() > 2)
          thisAmount += (each.getDaysRented() - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        thisAmount += each.getDaysRented() * 3;
        break;
      case Movie.CHILDRENS:
        thisAmount += 1.5;
        if (each.getDaysRented() > 3)
          thisAmount += (each.getDaysRented() - 3) * 1.5;
        break;
    }

    return thisAmount;
  }
}
