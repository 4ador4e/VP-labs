package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookListController {

    private final BookService bookService;

    public BookListController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.listAll());
        return "listBooks"; // ова ќе го бара во templates/listBooks.html
    }
}
