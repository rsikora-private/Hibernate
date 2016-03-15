package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import org.hibernate.annotations.Parameter;

/**
 * Created by robertsikora on 15.03.2016.
 */
@Entity
@Table(name="author_ext")
public class AuthorExt {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id", nullable=false)

    @OneToOne
    @PrimaryKeyJoinColumn
    private Author author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public Author getAuthor() {
   //     return author;
   // }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long authorId) {
        this.id = authorId;
    }

}
