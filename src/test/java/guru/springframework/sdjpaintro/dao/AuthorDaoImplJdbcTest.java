package guru.springframework.sdjpaintro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.sdjpaintro.domain.Author;

import org.junit.jupiter.api.*;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthorDaoImplJdbcTest {
  @Autowired
  private AuthorDao authorDaoImpl;

  @Test
  void testGetAuthor() {

    Author author = authorDaoImpl.getById(1L);

    assertNotNull(author);

  }
  @Test
  void testGetAuthorByName() {

    Author author = authorDaoImpl.getByName("Stephen", "King");

    assertNotNull(author);

  }
  @Test
  void testSaveAuthor() {

    Author author = new Author();
    author.setFirstName("unique");
    author.setLastName("name");
    author = authorDaoImpl.saveAuthor(author);

    assertNotNull(author.getId());

  }
  @Test
  void testUpdateAuthor() {

    Author author = new Author();
    author.setFirstName("unique");
    author.setLastName("name");
    author = authorDaoImpl.updateAuthor(author);

    assertNotNull(author.getId());
    assertEquals("uniquestephen", author.getFirstName());

  }

  @Test
  void testDeleteById() {
    Author author = authorDaoImpl.getByName("Stephen", "King");
    authorDaoImpl.deleteById(author.getId());
    assertThrows(EmptyResultDataAccessException.class, () -> authorDaoImpl.getById(author.getId()));

  }
}
