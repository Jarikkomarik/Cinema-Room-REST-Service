package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class CinemaRoom {

    private int total_rows;
    private int total_columns;
    private int total_income = 0;
    private int number_of_available_seats;
    private List<Seat> available_seats = new LinkedList<>();
    private Map<String, Seat> ticketMap = new ConcurrentHashMap<>();


    public CinemaRoom(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        number_of_available_seats = total_rows * total_columns;

        for (int i = 1; i <= total_rows; i++) {
            for (int y = 1; y <= total_columns; y++) {
                String uuid = UUID.randomUUID().toString();
                while (ticketMap.containsKey(uuid) == true) {
                    uuid = UUID.randomUUID().toString();
                }
                Seat temp = new Seat(i, y, uuid);
                ticketMap.put(uuid, temp);
                available_seats.add(temp);
            }
        }
        available_seats = Collections.synchronizedList(available_seats);

    }

    @JsonIgnore
    public Map<String, Seat> getTicketMap() {
        return ticketMap;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    @JsonIgnore
    public int getTotal_income() {
        return total_income;
    }

    public void setTotal_income(int total_income) {
        this.total_income = total_income;
    }
    @JsonIgnore
    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public void setNumber_of_available_seats(int number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }
}
