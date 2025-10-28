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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.listAll();
        req.setAttribute("books", books);
        req.getRequestDispatcher("listBooks.html").forward(req,resp);
    }
}

