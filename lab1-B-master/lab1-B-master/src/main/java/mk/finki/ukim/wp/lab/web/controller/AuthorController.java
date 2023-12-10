package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.service.AuthorService;
import mk.finki.ukim.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping
    public String authorGet(@RequestParam(value = "isbn", required = false) String isbn, Model model) {
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("authors", authorService.listAuthors());
//        String isbn = req.getParameter("isbn");
//        req.getSession().setAttribute("isbn", isbn);
//        context.setVariable("isbn", isbn);
//        springTemplateEngine.process("authorsList.html", context, resp.getWriter());
        model.addAttribute("authors", authorService.listAuthors());
        model.addAttribute("isbn", isbn);

        return "authorsList";
    }

    @PostMapping
    public String authorPost(@RequestParam("authId") String authId, @RequestParam("isbn") String isbn) {
//        String authId = req.getParameter("authId");
//        String isbn = req.getSession().getAttribute("isbn").toString();

//        String isbn = model.getAttribute("isbn").toString();
        bookService.addAuthorToBook(Long.parseLong(authId), isbn);
        System.out.println(authId);
        System.out.println(isbn);
//        return "redirect:/bookDetails?isbn=";
        return "redirect:/books/details?isbn=" + isbn + "&authId=" + authId;
    }

    @GetMapping("/delete")
    public String deleteAuthors(@RequestParam String isbn) {
        bookService.deleteAuthorsForBook(bookService.findBookByIsbn(isbn));
        return "redirect:/books/details?isbn=" + isbn;
    }

}
