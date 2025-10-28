package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.BookService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListServlet", urlPatterns = {"/"})
public class BookListServlet  extends HttpServlet {
    private final BookService bookService;

    public BookListServlet(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String text = req.getParameter("text");
        String ratingStr = req.getParameter("rating");

        List<Book> books;
        if (text != null && ratingStr != null && !text.isEmpty() && !ratingStr.isEmpty()) {
            try {
                double rating = Double.parseDouble(ratingStr);
                books = bookService.searchBooks(text, rating);
            } catch (NumberFormatException e) {
                books = bookService.listAll();
            }
        } else {
            books = bookService.listAll();
        }

        req.setAttribute("books", books);
        req.getRequestDispatcher("/listBooks.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Ги земаме податоците од формата и ги пренесуваме кон /bookReservation
        String bookTitle = req.getParameter("bookTitle");
        String readerName = req.getParameter("readerName");
        String readerAddress = req.getParameter("readerAddress");
        String numCopies = req.getParameter("numCopies");

        // redirect кон bookReservation servlet
        resp.sendRedirect(String.format(
                "/bookReservation?bookTitle=%s&readerName=%s&readerAddress=%s&numCopies=%s",
                bookTitle, readerName, readerAddress, numCopies
        ));
    }
}

