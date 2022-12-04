package person;

import java.util.IntSummaryStatistics;
import java.util.List;

public class PersonListUtils {
    private PersonListUtils() {}

    public static List<Person> filterBySexAndAgeDiapason(List<Person> people, Sex sex, int ageFrom, int ageTo) {
        return people.stream()
                .filter(person -> person.getSex() == sex &&
                        person.getAge() >= ageFrom &&
                        person.getAge() < ageTo
                )
                .toList();
    }

    public static double findAverageAge(List<Person> people, Sex sex) {
        IntSummaryStatistics stats = people.stream()
                .filter(person -> person.getSex() == sex)
                .mapToInt(Person::getAge)
                .summaryStatistics();

        return stats.getAverage();
    }

    public static long countAbleBodiedPeople(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() >= 18)
                .filter(person -> switch (person.getSex()) {
                    case MAN -> person.getAge() < 60;
                    case WOMAN -> person.getAge() < 55;
                    default -> false;
                }
                ).count();
    }
}
