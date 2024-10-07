package jk.day;

import java.time.LocalDate;
import java.util.Optional;

public interface DayTypeSelector {
  Optional<DayType> selected(final LocalDate date);
}
