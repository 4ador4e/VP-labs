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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookTitle = req.getParameter("bookTitle");
        String readerName = req.getParameter("readerName");
        String readerAddress = req.getParameter("readerAddress");
        int numCopies = Integer.parseInt(req.getParameter("numCopies"));

        BookReservation reservation =
                reservationService.placeReservation(bookTitle, readerName, readerAddress, numCopies);

        String clientIp = req.getRemoteAddr();

        req.setAttribute("reservation", reservation);
        req.setAttribute("clientIp", clientIp);
        req.getRequestDispatcher("src/main/resources/templates/reservationConfirmation.html").forward(req, resp);
    }
}
