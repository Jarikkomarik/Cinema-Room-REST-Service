package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    private int row;
    private int column;
    private boolean isTaken;
    private int price;
    private String token;

    public Seat(int row, int column, String token) {
        this.row = row;
        this.column = column;
        if (row < 5) {
            price = 10;
        } else {
            price = 8;
        }
        this.token = token;
    }

    @JsonIgnore
    public String getToken() {
        return token;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @JsonIgnore
    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", column=" + column +
                ", isTaken=" + isTaken +
                ", price=" + price +
                '}';
    }
}
