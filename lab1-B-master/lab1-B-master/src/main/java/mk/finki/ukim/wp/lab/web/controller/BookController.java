package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.service.BookService;
import mk.finki.ukim.wp.lab.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookStoreService bookStoreService;

    public BookController(BookService bookService, BookStoreService bookStoreService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Book> books = this.bookService.listBooks();
        model.addAttribute("books", books);

        return "listBooks";
    }

    @PostMapping
    public String postBooksPage(@RequestParam String book) {
//        return "redirect:/author?isbn=" + book;
        return "redirect:/author?isbn=" + book;
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam int year,
                           @RequestParam Long bookStore) {
        this.bookService.save(title, isbn, genre, year, bookStore);

        return "redirect:/books";
    }

    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam Integer year,
                           @RequestParam Long bookStore) {
        Book book = bookService.findById(bookId);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setGenre(genre);
        book.setYear(year);
        List<BookStore> bss = bookStoreService.findAll();
        BookStore bs = bookStoreService.findById(bookStore);
        book.setBookStore(bookStoreService.findById(bookStore));

        return "redirect:/books";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model) {
        if (this.bookService.findById(id) != null) {
            Book book = this.bookService.findById(id);
            List<BookStore> bookStores = this.bookStoreService.findAll();
            model.addAttribute("book", book);
            model.addAttribute("bookstores", bookStores);

            return "add-book";
        }
        return "redirect:/books?error=ProductNotFound";
    }

    @GetMapping("/add-form")
    public String getAddBookPage(Model model) {
        List<BookStore> bs = bookStoreService.findAll();
        model.addAttribute("bookstores", bs);

        return "add-book";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        this.bookService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/details")
    public String details(@RequestParam String isbn, @RequestParam(required = false) String authId, Model model) {
        Book book = bookService.findBookByIsbn(isbn);
        model.addAttribute("book", book);
//        springTemplateEngine.process("bookDetails.html", context, resp.getWriter());
        return "bookDetails";
    }
}
