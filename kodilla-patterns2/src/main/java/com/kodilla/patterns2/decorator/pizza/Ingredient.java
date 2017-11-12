package com.kodilla.patterns2.decorator.pizza;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


/**
 * Represents Ingredient.
 */
@Getter
public class Ingredient {
  private String name;

  public Ingredient(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return name;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Ingredient that = (Ingredient) o;

    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
