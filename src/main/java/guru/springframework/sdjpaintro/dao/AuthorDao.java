package guru.springframework.sdjpaintro.dao;

import guru.springframework.sdjpaintro.domain.Author;

public interface AuthorDao {
  Author getById(Long id);
  void deleteById(Long id);
  Author getByName(String firstName, String lastName);
  Author saveAuthor(Author author);
  Author updateAuthor(Author author);
}
