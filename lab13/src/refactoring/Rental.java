package refactoring;

class Rental {
    final Movie movie = new Movie("movie_title", Movie.REGULAR);

    private int _daysRented;
    public Rental(String title, int priceCode, DateRange dateRange) {
        movie.setTitle(title);
        movie.setPriceCode(priceCode);
        _daysRented = (int)((dateRange.getEnd().getTime() - dateRange.getStart().getTime()) / (1000 * 60 * 60 * 24));
    }
    public int getDaysRented() {
        return _daysRented;
    }

    public String getTitle() {
        return movie.getTitle();
    }
    
    public int getPriceCode() {
        return movie.getPriceCode();
    }

    public double getCharge() {
        return movie.getCharge(_daysRented);
    }

    public int getFrequentRenterPoints(){
        return movie.getFrequentRenterPoints(_daysRented);
    }
}
