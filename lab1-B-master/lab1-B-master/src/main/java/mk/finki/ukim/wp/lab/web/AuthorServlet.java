package mk.finki.ukim.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.wp.lab.service.AuthorService;
import mk.finki.ukim.wp.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "author-servlet", urlPatterns = "/author/nigg")
public class AuthorServlet extends HttpServlet {
    private final AuthorService authorService;
    private final BookService bookService;
    private final SpringTemplateEngine springTemplateEngine;

    public AuthorServlet(AuthorService authorService, SpringTemplateEngine springTemplateEngine, BookService bookService) {
        this.authorService = authorService;
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        context.setVariable("authors", authorService.listAuthors());
        String isbn = req.getParameter("isbn");
        req.getSession().setAttribute("isbn", isbn);
        context.setVariable("isbn", isbn);
        springTemplateEngine.process("authorsList.html", context, resp.getWriter());
    }
    //TODO POST

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        String authId = req.getParameter("authId");
        String isbn = req.getSession().getAttribute("isbn").toString();
        bookService.addAuthorToBook(Long.parseLong(authId), isbn);
        resp.sendRedirect("/bookDetails?isbn=" + isbn + "&authId=" + authId);
    }
}
