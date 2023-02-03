import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class IDateSorterImpl implements IDateSorter {
    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
     * would sort to
     * (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        if (unsortedDates == null || unsortedDates.isEmpty()) {
            return new ArrayList<>();
        }
        Map<String, List<LocalDate>> collect = unsortedDates.stream()
                .collect(Collectors.groupingBy(value -> value.getMonth().toString()));
        List<LocalDate> rMonth = new ArrayList<>();
        List<LocalDate> anotherMonth = new ArrayList<>();

        for (Map.Entry<String, List<LocalDate>> map : collect.entrySet()) {
            if (map.getKey().contains("R")) {
                List<LocalDate> value = map.getValue();
                rMonth.addAll(value);
            } else {
                List<LocalDate> value = map.getValue();
                anotherMonth.addAll(value);
            }
        }
        List<LocalDate> sortedRMonth = rMonth.stream().sorted().collect(Collectors.toList());
        List<LocalDate> sortedAnotherMonth = anotherMonth.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<LocalDate> result = new ArrayList<>();
        result.addAll(sortedRMonth);
        result.addAll(sortedAnotherMonth);
        return result;
    }
}
