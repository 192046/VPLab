package mk.finki.ukim.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.wp.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "delete-authors-servlet", urlPatterns = "/nigga")
public class DeleteAuthorsServlet extends HttpServlet {
    private final BookService bookService;

    public DeleteAuthorsServlet(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
        String isbn = req.getSession().getAttribute("isbn").toString();
        bookService.deleteAuthorsForBook(bookService.findBookByIsbn(isbn));
        resp.sendRedirect("/bookDetails?isbn=" + isbn);
    }
}
