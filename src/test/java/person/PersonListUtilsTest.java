package person;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonListUtilsTest {

    @org.junit.jupiter.api.Test
    void shouldFilterBySexAndAgeDiapason() {
        // given
        List<Person> people = List.of(
                new Person("Вася", 16, Sex.MAN),
                new Person("Петя", 23, Sex.MAN),
                new Person("Олена", 42, Sex.WOMAN),
                new Person( "Іван Іванович", 69, Sex.MAN)
        );

        // when
        Sex sex = Sex.WOMAN;
        int ageFrom = 18;
        int ageTo = 60;

        // then
        assertThat(PersonListUtils.filterBySexAndAgeDiapason(people, sex, ageFrom, ageTo))
                .containsExactly(new Person("Олена", 42, Sex.WOMAN));
    }

    @org.junit.jupiter.api.Test
    void shouldFindAverageAge() {
        // given
        List<Person> people = List.of(
                new Person("Вася", 16, Sex.MAN),
                new Person("Петя", 23, Sex.MAN),
                new Person("Олена", 42, Sex.WOMAN),
                new Person( "Іван Іванович", 69, Sex.MAN)
        );

        // when
        Sex sex = Sex.MAN;

        // then
        assertThat(PersonListUtils.findAverageAge(people, sex))
                .isEqualTo(36D);
    }

    @org.junit.jupiter.api.Test
    void shouldCountAbleBodiedPeople() {
        // given
        List<Person> people;

        // when
        people = List.of(
                new Person("Вася", 16, Sex.MAN),
                new Person("Петя", 23, Sex.MAN),
                new Person("Олена", 42, Sex.WOMAN),
                new Person( "Іван Іванович", 69, Sex.MAN)
        );

        // then
        assertThat(PersonListUtils.countAbleBodiedPeople(people))
                .isEqualTo(2L);
    }
}