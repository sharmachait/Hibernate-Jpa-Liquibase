package guru.springframework.sdjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.sdjpaintro.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
