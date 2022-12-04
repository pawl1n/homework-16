package person;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Вася", 16, Sex.MAN),
                new Person("Петя", 23, Sex.MAN),
                new Person("Олена", 42, Sex.WOMAN),
                new Person( "Іван Іванович", 69, Sex.MAN)
        );

        System.out.println("people = " + people);
        System.out.println();

        // Вибрати жінок від 18 до 60 років
        System.out.println("Вибрати жінок від 18 до 60 років");
        List<Person> filteredWomen = PersonListUtils.filterBySexAndAgeDiapason(people, Sex.WOMAN, 18, 60);
        System.out.println("filteredWomen = " + filteredWomen);
        System.out.println();

        // Знайти середній вік серед чоловіків
        System.out.println("Знайти середній вік серед чоловіків");
        double avg = PersonListUtils.findAverageAge(people, Sex.MAN);
        System.out.println("avg = " + avg);
        System.out.println();

        // Знайти кількість працездатних людей (Тобто від 18 років і
        // враховуючи що жінки виходять на пенсію у 55 років, а чоловік у 60)
        System.out.println("Знайти кількість працездатних людей (Тобто від 18 років і" +
                "враховуючи що жінки виходять на пенсію у 55 років, а чоловік у 60)");
        long count = PersonListUtils.countAbleBodiedPeople(people);
        System.out.println("count = " + count);
    }
}