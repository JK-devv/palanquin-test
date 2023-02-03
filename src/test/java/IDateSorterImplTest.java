import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IDateSorterImplTest {
    private final IDateSorterImpl sorter = new IDateSorterImpl();

    @Test
    void sortDates_Ok() {
        List<LocalDate> input = new ArrayList<>();
        input.add(LocalDate.of(2005, 7, 1));
        input.add(LocalDate.of(2005, 1, 2));
        input.add(LocalDate.of(2005, 1, 1));
        input.add(LocalDate.of(2005, 5, 3));

        List<LocalDate> expected = new ArrayList<>();
        expected.add(LocalDate.of(2005, 1, 1));
        expected.add(LocalDate.of(2005, 1, 2));
        expected.add(LocalDate.of(2005, 7, 1));
        expected.add(LocalDate.of(2005, 5, 3));


        Collection<LocalDate> actual = sorter.sortDates(input);

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void sortDates_WithCoupleOfDifferentRMonth_Ok() {
        List<LocalDate> input = new ArrayList<>();
        input.add(LocalDate.of(2005, 7, 1));
        input.add(LocalDate.of(2005, 1, 2));
        input.add(LocalDate.of(2005, 10, 2));
        input.add(LocalDate.of(2005, 1, 1));
        input.add(LocalDate.of(2005, 5, 3));

        List<LocalDate> expected = new ArrayList<>();
        expected.add(LocalDate.of(2005, 1, 1));
        expected.add(LocalDate.of(2005, 1, 2));
        expected.add(LocalDate.of(2005, 10, 2));
        expected.add(LocalDate.of(2005, 7, 1));
        expected.add(LocalDate.of(2005, 5, 3));

        Collection<LocalDate> actual = sorter.sortDates(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sortDates_DifferentDates_Ok() {
        List<LocalDate> input = new ArrayList<>();
        input.add(LocalDate.of(2005, 7, 1));
        input.add(LocalDate.of(2005, 1, 2));
        input.add(LocalDate.of(2004, 10, 2));
        input.add(LocalDate.of(2005, 1, 1));
        input.add(LocalDate.of(2005, 5, 3));
        input.add(LocalDate.of(2006, 5, 5));

        List<LocalDate> expected = new ArrayList<>();
        expected.add(LocalDate.of(2004, 10, 2));
        expected.add(LocalDate.of(2005, 1, 1));
        expected.add(LocalDate.of(2005, 1, 2));
        expected.add(LocalDate.of(2006, 5, 5));
        expected.add(LocalDate.of(2005, 7, 1));
        expected.add(LocalDate.of(2005, 5, 3));

        Collection<LocalDate> actual = sorter.sortDates(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sortDates_WithNullData_NotOk() {
        Collection<LocalDate> actual = sorter.sortDates(null);
        assertTrue(actual.isEmpty());
    }
}