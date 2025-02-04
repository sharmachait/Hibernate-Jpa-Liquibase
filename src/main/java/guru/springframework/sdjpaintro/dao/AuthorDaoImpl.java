package guru.springframework.sdjpaintro.dao;

import java.sql.*;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import guru.springframework.sdjpaintro.domain.Author;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class AuthorDaoImpl implements AuthorDao {

  private final DataSource source;

  @Override
  public Author getById(Long id) {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;

    try {
      connection = source.getConnection();
      ps = connection.prepareStatement("select * from author where id = ?");
      ps.setLong(1, id);
      resultSet = ps.executeQuery();
      if (resultSet.next()) {
        Author author = new Author();
        author.setId(id);
        author.setFirstName(resultSet.getString("first_name"));
        author.setLastName(resultSet.getString("last_name"));
        return author;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (resultSet != null)
          resultSet.close();
        if(ps!=null)
          ps.close();
        if (connection != null)
          connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @Override
  public Author getByName(String firstName, String lastName) {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;

    try {
      connection = source.getConnection();
      ps = connection.prepareStatement("select * from author where first_name = ? and last_name = ?");
      ps.setString(1, firstName);
      ps.setString(2, lastName);
      resultSet = ps.executeQuery();
      if (resultSet.next()) {
        Author author = new Author();
        author.setId(resultSet.getLong("id"));
        author.setFirstName(resultSet.getString("first_name"));
        author.setLastName(resultSet.getString("last_name"));
        return author;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (resultSet != null)
          resultSet.close();
        if(ps!=null)
          ps.close();
        if (connection != null)
          connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @Override
  public Author saveAuthor(Author author) {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;

    try {
      connection = source.getConnection();
      ps = connection.prepareStatement("insert into author(first_name,last_name) values(?,?)");
      ps.setString(1, author.getFirstName());
      ps.setString(2, author.getLastName());
      ps.execute();
      return getByName(author.getFirstName(), author.getLastName());
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (resultSet != null)
          resultSet.close();
        if(ps!=null)
          ps.close();
        if (connection != null)
          connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @Override
  public Author updateAuthor(Author author) {
    author = getByName(author.getFirstName(), author.getLastName());
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;

    try {
      connection = source.getConnection();
      ps = connection.prepareStatement("update author set first_name = ?, last_name = ? where id = ?");
      ps.setString(1, author.getFirstName()+"__"+author.getLastName());
      ps.setString(2, author.getLastName());
      ps.setLong(3, author.getId());
      ps.execute();
      return getById(author.getId());
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (resultSet != null)
          resultSet.close();
        if(ps!=null)
          ps.close();
        if (connection != null)
          connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }
}
