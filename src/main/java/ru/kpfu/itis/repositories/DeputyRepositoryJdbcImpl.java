package ru.kpfu.itis.repositories;


import ru.kpfu.itis.models.Deputy;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

import static ru.kpfu.itis.queries.DeputyQueries.*;
import static ru.kpfu.itis.queries.UserQueries.SQL_INSERT;

public class DeputyRepositoryJdbcImpl implements DeputyRepository {

    private final DataSource dataSource;
    private final SimpleJdbcTemplate template;

    private final RowMapper<Deputy> deputyRowMapper = row -> Deputy.builder()
            .id(row.getLong("id"))
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .age(row.getInt("age"))
            .vote(row.getInt("vote"))
            .photo(row.getString("photo"))
            .title(row.getString("title"))
            .build();

    public DeputyRepositoryJdbcImpl(DataSource dataSource, SimpleJdbcTemplate template) {
        this.dataSource = dataSource;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void save(Deputy entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

            int i = 1;
            preparedStatement.setString(i++, entity.getFirst_name());
            preparedStatement.setString(i++, entity.getLast_name());
            preparedStatement.setInt(i++, entity.getAge());
            preparedStatement.setInt(i++, entity.getVote());
            preparedStatement.setString(i++, entity.getPhoto());
            preparedStatement.setString(i++, entity.getTitle());

            preparedStatement.executeUpdate();

            // setting the ID value generated by the database
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                resultSet.next();
                Long id = resultSet.getLong(1);
                entity.setId(id);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(Deputy entity) {
        template.query(SQL_UPDATE_BY_ID, deputyRowMapper, entity.getFirst_name(), entity.getLast_name(),
                entity.getAge(), entity.getVote(), entity.getPhoto(), entity.getTitle());
    }

    @Override
    public void delete(Deputy entity) {

    }

    @Override
    public Optional<Deputy> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Deputy> findAll() {
        return null;
    }

    @Override
    public Optional<Deputy> findByName(String last_name) {
        return Optional.empty();
    }
}
