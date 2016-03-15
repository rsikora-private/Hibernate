package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by robertsikora on 16.09.15.
 */
@Entity
@Table(name="book")
public class Book {

    @EmbeddedId
    private
    PK id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

@Embeddable
class PK implements Serializable {

    public PK(){

    }
    public PK(Integer i, String t){
        this.id=i;
        this.title = t;
    }

    Integer id;
    String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PK pk = (PK) o;
        return Objects.equals(id, pk.id) &&
                Objects.equals(title, pk.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("model.PK{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
