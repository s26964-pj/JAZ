package com.example.customvalidator.player.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PlayersPositionValidator implements ConstraintValidator<Dictionary, String> {

    private String tableName;

    @Autowired
    @Qualifier("dictionaryDataSource")
    private DataSource dataSource;

    @Override
    public void initialize(Dictionary dictionary) {
        this.tableName = dictionary.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        String query = "SELECT COUNT(*) FROM " + tableName + " WHERE value = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, value);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error during validation", e);
        }

        return false;
    }
}
