import model.Author;
import model.AuthorExt;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by robertsikora on 16.09.15.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(model.Book.class);
            configuration.addAnnotatedClass(AuthorExt.class);
            configuration.addAnnotatedClass(Author.class);
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {

        Session session = getSession();
        long id;
        try {
            session.beginTransaction();
            id = newAuthor(session, 1);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        session = getSession();
        final Author author = (Author)session.get(Author.class, id);
        session.flush();


    }

    private static Long newAuthor(Session session, int i){

        try {
           // Author author1 = new Author();
          //  author1.setName("aut" + i);
         //   session.save(author1);

            AuthorExt authorExt = new AuthorExt();
            authorExt.setName("detail");

            Author author = new Author();
            author.setName("aut" + i);
            author.setAuthorExt(authorExt);
            authorExt.setAuthor(author);

            return (Long)session.save(author);
        } finally {

        }

    }

    private static void newBook(){
        final Session session = getSession();
        try {

            model.Book book = new model.Book();
          //  book.setId(pk);
            book.setName("name1");

            Author author = new Author();
            author.setName("Brzechwa");

            book.setAuthor(author);

            session.save(book);
            session.flush();
        } finally {
            session.close();
        }
    }
}
