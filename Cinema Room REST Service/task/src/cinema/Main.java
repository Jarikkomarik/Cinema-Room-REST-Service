package cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}

@RestController
class SeatsHandler {
    public static final int TOTAL_ROWS = 9;
    public static final int TOTAL_COLUMNS = 9;
    CinemaRoom cinemaRoom = new CinemaRoom(TOTAL_ROWS, TOTAL_COLUMNS);

    @GetMapping("/seats")
    private CinemaRoom returnSeats() {
        return cinemaRoom;
    }


    @PostMapping("/purchase")
    private ResponseEntity purchaseTickets(@RequestBody Map<String, Integer> ticketOrder) {
        int row = ticketOrder.get("row");
        int column = ticketOrder.get("column");

        if (row < 1 || row > TOTAL_ROWS || column < 1 || column > TOTAL_COLUMNS) {
            return new ResponseEntity(Map.of("error", "The number of a row or a column is out of bounds!")
                    , HttpStatus.valueOf(400));
        }

        Seat seat = getSeatByRowAndColumn(row, column);


        if (seat.isTaken() == false) {
            seat.setTaken(true);

            cinemaRoom.setTotal_income(cinemaRoom.getTotal_income() + seat.getPrice());     //adjusting stats
            cinemaRoom.setNumber_of_available_seats(cinemaRoom.getNumber_of_available_seats() - 1);

            Map<String, Object> purchaseResult = new LinkedHashMap<>();
            purchaseResult.put("token", seat.getToken());
            purchaseResult.put("ticket", seat);
            return new ResponseEntity(purchaseResult, HttpStatus.OK);
        } else {
            return new ResponseEntity(Map.of("error", "The ticket has been already purchased!")
                    , HttpStatus.valueOf(400));

        }

    }

    @PostMapping("/return")
    private ResponseEntity returnTicket(@RequestBody Map<String, String> requestBody) {
        String token = requestBody.get("token");

        if (cinemaRoom.getTicketMap().containsKey(token)) {
            Seat seat = cinemaRoom.getTicketMap().get(token);
            seat.setTaken(false);

            cinemaRoom.setTotal_income(cinemaRoom.getTotal_income() - seat.getPrice());     //adjusting stats
            cinemaRoom.setNumber_of_available_seats(cinemaRoom.getNumber_of_available_seats() + 1);

            return new ResponseEntity(Map.of("returned_ticket", seat), HttpStatus.OK);
        } else {
            return new ResponseEntity(Map.of("error", "Wrong token!"), HttpStatus.valueOf(400));
        }
    }

    @PostMapping("/stats")
    private ResponseEntity returnStats(@RequestParam(required = false) String password) {
        if (password == null) {
            return new ResponseEntity(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
        }

        if (password.equals("super_secret")) {
            Map<String, Integer> statsResult = new LinkedHashMap<>();
            statsResult.put("current_income", cinemaRoom.getTotal_income());
            statsResult.put("number_of_available_seats", cinemaRoom.getNumber_of_available_seats());
            statsResult.put("number_of_purchased_tickets", getNumberOfPurchasedSeats());
            return new ResponseEntity(statsResult, HttpStatus.OK);
        }

        return new ResponseEntity(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);

    }


    private Seat getSeatByRowAndColumn(int row, int column) {
        int seatIndex = (row - 1) * 9 + (column - 1);
        return cinemaRoom.getAvailable_seats().get(seatIndex);
    }

    private int getNumberOfPurchasedSeats() {
        return (cinemaRoom.getTotal_rows() * cinemaRoom.getTotal_columns()) - cinemaRoom.getNumber_of_available_seats();
    }
}

