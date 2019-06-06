package com.alten.entity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    private static final String ADDRESS = "usa";
    private static final String NAME_1 = "name-1";
    private static final String NAME_2 = "name-2";
    private static final String ADDRESS_2 = "uk";

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void givenDifferentEmptyObjectWhenEqualsThenReturnTrue() {
        // Arrange
        User user = new User();
        User user2 = new User();

        // Act
        boolean actual = user.equals(user2);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void givenDifferentObjectWhenEqualsThenReturnTrue() {
        // Arrange
        User user = new User();
        user.setAddress(ADDRESS);
        user.setName(NAME_1);
        User user2 = new User();
        user2.setAddress(ADDRESS);
        user2.setName(NAME_1);

        // Act
        boolean actual = user.equals(user2);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void givenDifferentObjectAndValueWhenEqualsThenReturnFalse() {
        // Arrange
        User user = new User();
        user.setAddress(ADDRESS);
        user.setName(NAME_1);
        User user2 = new User();
        user2.setAddress(ADDRESS_2);
        user2.setName(NAME_2);

        // Act
        boolean actual = user.equals(user2);

        // Assert
        assertFalse(actual);
    }

    @Test
    public void givenSameEmptyObjectWhenEqualsThenReturnTrue() {
        // Arrange
        User user = new User();

        // Act
        boolean actual = user.equals(user);

        // Assert
        collector.checkThat(actual, equalTo(true));
        collector.checkThat(user.hashCode(), equalTo(user.hashCode()));
    }
}
