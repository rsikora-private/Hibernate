package model;


import javax.persistence.*;

/**
 * Created by robertsikora on 18.10.15.
 */
@Entity
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

   /* @ElementCollection
    @CollectionTable(
            name="PHONE",
            joinColumns=@JoinColumn(name="OWNER_ID")
    )
    @Column(name="PHONE_NUMBER")
    private List<String> phones = new ArrayList<>(); */

    //@OneToOne(mappedBy = "author", optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    @OneToOne(mappedBy="author", fetch=FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private AuthorExt authorExt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
*/
    public AuthorExt getAuthorExt() {
        return authorExt;
    }

    public void setAuthorExt(AuthorExt authorExt) {
        this.authorExt = authorExt;
    }
}
