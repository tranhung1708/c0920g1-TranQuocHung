package vn.codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class OrderBook {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Library library;

    public OrderBook() {
    }

    public OrderBook(long id, Library library) {
        this.id = id;
        this.library = library;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
