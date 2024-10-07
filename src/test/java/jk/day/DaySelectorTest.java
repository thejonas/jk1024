package jk.day;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

public class DaySelectorTest {
  private static final LocalDate monday = LocalDate.of(2010, 2, 1);
  private static final List<LocalDate> week = IntStream.range(0, 7)
                                                       .mapToObj(monday::plusDays)
                                                       .toList();
  protected static final List<LocalDate> weekendDays = week.subList(5, 7);
  protected static final List<LocalDate> weekdayDays = week.subList(0, 5);
}
