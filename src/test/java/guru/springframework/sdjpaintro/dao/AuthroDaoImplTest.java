package guru.springframework.sdjpaintro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.sdjpaintro.domain.Author;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthroDaoImplTest {
  @Autowired
  private AuthorDao authorDaoImpl;

  @Test
  void testGetAuthor() {

    Author author = authorDaoImpl.getById(1L);

    assertNotNull(author);

  }
}
