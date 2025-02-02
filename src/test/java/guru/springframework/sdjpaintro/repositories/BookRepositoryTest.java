package guru.springframework.sdjpaintro.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookRepositoryTest {
  @Autowired
  BookRepository bookRepository;

  @Test
  void testDB() {
    long countBefore = bookRepository.count();
    assertNotEquals(0, countBefore);
  }
}
