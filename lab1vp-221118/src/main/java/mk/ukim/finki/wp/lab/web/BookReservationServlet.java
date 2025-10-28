package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;

import java.io.IOException;

@WebServlet(name = "BookReservationListServlet", urlPatterns = {"/bookReservation"})
public class BookReservationServlet extends HttpServlet {
    private final BookReservationService reservationService;


    public BookReservationServlet(BookReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String bookTitle = req.getParameter("bookTitle");
        String readerName = req.getParameter("readerName");
        String readerAddress = req.getParameter("readerAddress");
        int numCopies = Integer.parseInt(req.getParameter("numCopies"));
        String clientIp = req.getRemoteAddr();

        BookReservation reservation = reservationService
                .placeReservation(bookTitle, readerName, readerAddress, numCopies);

        req.setAttribute("readerName", reservation.getReaderName());
        req.setAttribute("bookTitle", reservation.getBookTitle());
        req.setAttribute("numCopies", reservation.getNumberOfCopies());
        req.setAttribute("clientIp", clientIp);

        req.getRequestDispatcher("/reservationConfirmation.html").forward(req, resp);
    }
}
