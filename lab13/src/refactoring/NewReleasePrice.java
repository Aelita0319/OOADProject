package refactoring;

public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        double thisAmount = 0;
        thisAmount += daysRented * 3;
        return thisAmount;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented){
        if (daysRented>1)
            return 2;
        else return 1;
    }
}