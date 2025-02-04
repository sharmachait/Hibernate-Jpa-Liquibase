package guru.springframework.sdjpaintro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.sdjpaintro.domain.Author;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthorDaoImplTest {
  @Autowired
  private AuthorDao authorDaoImpl;

  @Test
  void testGetAuthor() {

    Author author = authorDaoImpl.getById(1L);

    assertNotNull(author);

  }
  @Test
  void testGetAuthorByName() {

    Author author = authorDaoImpl.getByName("john", "greene");

    assertNotNull(author);

  }
  @Test
  void testSaveAuthor() {

    Author author = new Author();
    author.setFirstName("john2");
    author.setLastName("greene2");
    author = authorDaoImpl.saveAuthor(author);

    assertNotNull(author.getId());

  }
  @Test
  void testUpdateAuthor() {

    Author author = new Author();
    author.setFirstName("john");
    author.setLastName("greene2");
    author = authorDaoImpl.updateAuthor(author);

    assertNotNull(author.getId());
    assertEquals("john__greene2", author.getFirstName());

  }
}
