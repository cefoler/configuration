package com.cefoler.configuration.core.util.type;

import com.cefoler.configuration.core.util.Streams;
import com.cefoler.configuration.core.util.Primitives;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Locale;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@Getter
@ToString
public enum TimeType {

  NANOSECONDS("N", "NS", "NN", "NA", "NANOSECOND", "NANOSECONDS") {
    @Override
    public double toNanoseconds(final double time) {
      return time;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time / 1000.0;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time / 1000000.0;
    }

    @Override
    public double toSeconds(final double time) {
      return time / 1000000000.0;
    }

    @Override
    public double toMinutes(final double time) {
      return time / 60000000000.0;
    }

    @Override
    public double toHours(final double time) {
      return time / 3600000000000.0;
    }

    @Override
    public double toDays(final double time) {
      return time / 86400000000000.0;
    }

    @Override
    public double toWeeks(final double time) {
      return time / 604800000000000.0;
    }

    @Override
    public double toMonths(final double time) {
      return time / 2628002880000000.0;
    }

    @Override
    public double toYears(final double time) {
      return time / 31536034560000000.0;
    }

    @Override
    public double toDecades(final double time) {
      return time / 315360345600000000.0;
    }

    @Override
    public double toCenturies(final double time) {
      return time / 3153603456000000000.0;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toNanoseconds(time);
    }
  },
  MICROSECONDS("US", "MC", "MICROSECOND", "MICROSECONDS") {
    @Override
    public double toNanoseconds(final double time) {
      return time * 1000.0;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time / 1000.0;
    }

    @Override
    public double toSeconds(final double time) {
      return time / 1000000.0;
    }

    @Override
    public double toMinutes(final double time) {
      return time / 60000000.0;
    }

    @Override
    public double toHours(final double time) {
      return time / 3600000000.0;
    }

    @Override
    public double toDays(final double time) {
      return time / 86400000000.0;
    }

    @Override
    public double toWeeks(final double time) {
      return time / 604800000000.0;
    }

    @Override
    public double toMonths(final double time) {
      return time / 2628002880000.0;
    }

    @Override
    public double toYears(final double time) {
      return time / 31536034560000.0;
    }

    @Override
    public double toDecades(final double time) {
      return time / 315360345600000.0;
    }

    @Override
    public double toCenturies(final double time) {
      return time / 3153603456000000.0;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toMicroseconds(time);
    }
  },
  MILLISECONDS("MS", "ML", "MILLISECOND", "MILLISECONDS") {
    @Override
    public double toNanoseconds(final double time) {
      return time * 1000000.0;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time * 1000.0;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time;
    }

    @Override
    public double toSeconds(final double time) {
      return time / 1000.0;
    }

    @Override
    public double toMinutes(final double time) {
      return time / 60000.0;
    }

    @Override
    public double toHours(final double time) {
      return time / 3600000.0;
    }

    @Override
    public double toDays(final double time) {
      return time / 86400000.0;
    }

    @Override
    public double toWeeks(final double time) {
      return time / 604800000.0;
    }

    @Override
    public double toMonths(final double time) {
      return time / 2628002880.0;
    }

    @Override
    public double toYears(final double time) {
      return time / 31536034560.0;
    }

    @Override
    public double toDecades(final double time) {
      return time / 315360345600.0;
    }

    @Override
    public double toCenturies(final double time) {
      return time / 3153603456000.0;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toMilliseconds(time);
    }
  },
  SECONDS("S", "SC", "SE", "SECOND", "SECONDS") {
    @Override
    public double toNanoseconds(final double time) {
      return time * 1000000000.0;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time * 1000000.0;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time * 1000.0;
    }

    @Override
    public double toSeconds(final double time) {
      return time;
    }

    @Override
    public double toMinutes(final double time) {
      return time / 60.0;
    }

    @Override
    public double toHours(final double time) {
      return time / 3600.0;
    }

    @Override
    public double toDays(final double time) {
      return time / 86400.0;
    }

    @Override
    public double toWeeks(final double time) {
      return time / 604800.0;
    }

    @Override
    public double toMonths(final double time) {
      return time / 2628002.88;
    }

    @Override
    public double toYears(final double time) {
      return time / 31536034.56;
    }

    @Override
    public double toDecades(final double time) {
      return time / 315360345.6;
    }

    @Override
    public double toCenturies(final double time) {
      return time / 3153603456.0;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toSeconds(time);
    }
  },
  MINUTES("M", "MM", "MN", "MI", "MINUTE", "MINUTES") {
    @Override
    public double toNanoseconds(final double time) {
      return time * 60000000000.0;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time * 60000000.0;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time * 60000.0;
    }

    @Override
    public double toSeconds(final double time) {
      return time * 60.0;
    }

    @Override
    public double toMinutes(final double time) {
      return time;
    }

    @Override
    public double toHours(final double time) {
      return time / 60.0;
    }

    @Override
    public double toDays(final double time) {
      return time / 1440.0;
    }

    @Override
    public double toWeeks(final double time) {
      return time / 10080.0;
    }

    @Override
    public double toMonths(final double time) {
      return time / 43800.048;
    }

    @Override
    public double toYears(final double time) {
      return time / 525600.576;
    }

    @Override
    public double toDecades(final double time) {
      return time / 5256005.76;
    }

    @Override
    public double toCenturies(final double time) {
      return time / 52560057.6;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toMinutes(time);
    }
  },
  HOURS("H", "HR", "HO", "HOUR", "HOURS") {
    @Override
    public double toNanoseconds(final double time) {
      return time * 3600000000000.0;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time * 3600000000.0;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time * 3600000.0;
    }

    @Override
    public double toSeconds(final double time) {
      return time * 3600.0;
    }

    @Override
    public double toMinutes(final double time) {
      return time * 60.0;
    }

    @Override
    public double toHours(final double time) {
      return time;
    }

    @Override
    public double toDays(final double time) {
      return time / 24.0;
    }

    @Override
    public double toWeeks(final double time) {
      return time / 168.0;
    }

    @Override
    public double toMonths(final double time) {
      return time / 730.0008;
    }

    @Override
    public double toYears(final double time) {
      return time / 8760.0096;
    }

    @Override
    public double toDecades(final double time) {
      return time / 87600.096;
    }

    @Override
    public double toCenturies(final double time) {
      return time / 876000.96;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toHours(time);
    }
  },
  DAYS("D", "DY", "DA", "DAY", "DAYS") {
    @Override
    public double toNanoseconds(final double time) {
      return time * 86400000000000.0;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time * 86400000000.0;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time * 86400000.0;
    }

    @Override
    public double toSeconds(final double time) {
      return time * 86400.0;
    }

    @Override
    public double toMinutes(final double time) {
      return time * 1440.0;
    }

    @Override
    public double toHours(final double time) {
      return time * 24.0;
    }

    @Override
    public double toDays(final double time) {
      return time;
    }

    @Override
    public double toWeeks(final double time) {
      return time / 7.0;
    }

    @Override
    public double toMonths(final double time) {
      return time / 30.4167;
    }

    @Override
    public double toYears(final double time) {
      return time / 365.0004;
    }

    @Override
    public double toDecades(final double time) {
      return time / 3650.004;
    }

    @Override
    public double toCenturies(final double time) {
      return time / 36500.04;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toDays(time);
    }
  },
  WEEKS("W", "WK", "WE", "WEEK", "WEEKS") {
    @Override
    public double toNanoseconds(final double time) {
      return time * 604800000000000.0;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time * 604800000000.0;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time * 604800000.0;
    }

    @Override
    public double toSeconds(final double time) {
      return time * 604800.0;
    }

    @Override
    public double toMinutes(final double time) {
      return time * 10080.0;
    }

    @Override
    public double toHours(final double time) {
      return time * 168.0;
    }

    @Override
    public double toDays(final double time) {
      return time * 7.0;
    }

    @Override
    public double toWeeks(final double time) {
      return time;
    }

    @Override
    public double toMonths(final double time) {
      return time / 4.345242857142857;
    }

    @Override
    public double toYears(final double time) {
      return time / 52.14291428571428;
    }

    @Override
    public double toDecades(final double time) {
      return time / 521.4291428571429;
    }

    @Override
    public double toCenturies(final double time) {
      return time / 5214.291428571429;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toWeeks(time);
    }
  },
  MONTHS("MT", "MO", "MONTH", "MONTHS") {
    @Override
    public double toNanoseconds(final double time) {
      return time * 2628002880000000.0;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time * 2628002880000.0;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time * 2628002880.0;
    }

    @Override
    public double toSeconds(final double time) {
      return time * 2628002.88;
    }

    @Override
    public double toMinutes(final double time) {
      return time * 43800.048;
    }

    @Override
    public double toHours(final double time) {
      return time * 730.0008;
    }

    @Override
    public double toDays(final double time) {
      return time * 30.4167;
    }

    @Override
    public double toWeeks(final double time) {
      return time * 4.345242857142857;
    }

    @Override
    public double toMonths(final double time) {
      return time;
    }

    @Override
    public double toYears(final double time) {
      return time / 12.0;
    }

    @Override
    public double toDecades(final double time) {
      return time / 120.0;
    }

    @Override
    public double toCenturies(final double time) {
      return time / 1200.0;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toMonths(time);
    }
  },
  YEARS("Y", "YR", "YE", "YEAR", "YEARS") {
    @Override
    public double toNanoseconds(final double time) {
      return time * 31536034560000000.0;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time * 31536034560000.0;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time * 31536034560.0;
    }

    @Override
    public double toSeconds(final double time) {
      return time * 31536034.56;
    }

    @Override
    public double toMinutes(final double time) {
      return time * 525600.576;
    }

    @Override
    public double toHours(final double time) {
      return time * 8760.0096;
    }

    @Override
    public double toDays(final double time) {
      return time * 365.0004;
    }

    @Override
    public double toWeeks(final double time) {
      return time * 52.14291428571428;
    }

    @Override
    public double toMonths(final double time) {
      return time * 12.0;
    }

    @Override
    public double toYears(final double time) {
      return time;
    }

    @Override
    public double toDecades(final double time) {
      return time / 10.0;
    }

    @Override
    public double toCenturies(final double time) {
      return time / 100.0;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toYears(time);
    }
  },
  DECADES("DE", "DC", "DECADE", "DECADES") {
    @Override
    public double toNanoseconds(final double time) {
      return time * 315360345600000000.0;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time * 315360345600000.0;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time * 315360345600.0;
    }

    @Override
    public double toSeconds(final double time) {
      return time * 315360345.6;
    }

    @Override
    public double toMinutes(final double time) {
      return time * 5256005.76;
    }

    @Override
    public double toHours(final double time) {
      return time * 87600.096;
    }

    @Override
    public double toDays(final double time) {
      return time * 3650.004;
    }

    @Override
    public double toWeeks(final double time) {
      return time * 521.4291428571429;
    }

    @Override
    public double toMonths(final double time) {
      return time * 120.0;
    }

    @Override
    public double toYears(final double time) {
      return time * 10.0;
    }

    @Override
    public double toDecades(final double time) {
      return time;
    }

    @Override
    public double toCenturies(final double time) {
      return time / 10.0;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toCenturies(time);
    }
  },
  CENTURIES("C", "CT", "CE", "CENTURY", "CENTURIES") {
    @Override
    public double toNanoseconds(final double time) {
      return time * 3153603456000000000.0;
    }

    @Override
    public double toMicroseconds(final double time) {
      return time * 3153603456000000.0;
    }

    @Override
    public double toMilliseconds(final double time) {
      return time * 3153603456000.0;
    }

    @Override
    public double toSeconds(final double time) {
      return time * 3153603456.0;
    }

    @Override
    public double toMinutes(final double time) {
      return time * 52560057.6;
    }

    @Override
    public double toHours(final double time) {
      return time * 876000.96;
    }

    @Override
    public double toDays(final double time) {
      return time * 36500.04;
    }

    @Override
    public double toWeeks(final double time) {
      return time * 5214.291428571429;
    }

    @Override
    public double toMonths(final double time) {
      return time * 1200.0;
    }

    @Override
    public double toYears(final double time) {
      return time * 100.0;
    }

    @Override
    public double toDecades(final double time) {
      return time * 10.0;
    }

    @Override
    public double toCenturies(final double time) {
      return time;
    }

    @Override
    public double convert(final double time, final TimeType type) {
      return type.toCenturies(time);
    }
  };

  private final List<String> names;

  TimeType(final String... names) {
    this.names = ImmutableList.copyOf(names);
  }

  public abstract double toNanoseconds(final double time);

  public long toNanoseconds(final long time) {
    final double converted = time;
    final double result = toNanoseconds(converted);

    return Primitives.toLong(result);
  }

  public Number toNanoseconds(final Number time) {
    final double converted = time.doubleValue();
    return toNanoseconds(converted);
  }

  public abstract double toMicroseconds(final double time);

  public long toMicroseconds(final long time) {
    final double converted = time;
    final double result = toMicroseconds(converted);

    return Primitives.toLong(result);
  }

  public Number toMicroseconds(final Number time) {
    final double converted = time.doubleValue();
    return toMicroseconds(converted);
  }

  public abstract double toMilliseconds(final double time);

  public long toMilliseconds(final long time) {
    final double converted = time;
    final double result = toMilliseconds(converted);

    return Primitives.toLong(result);
  }

  public Number toMilliseconds(final Number time) {
    final double converted = time.doubleValue();
    return toMilliseconds(converted);
  }

  public abstract double toSeconds(final double time);

  public long toSeconds(final long time) {
    final double converted = time;
    final double result = toSeconds(converted);

    return Primitives.toLong(result);
  }

  public Number toSeconds(final Number time) {
    final double converted = time.doubleValue();
    return toSeconds(converted);
  }

  public abstract double toMinutes(final double time);

  public long toMinutes(final long time) {
    final double converted = time;
    final double result = toMinutes(converted);

    return Primitives.toLong(result);
  }

  public Number toMinutes(final Number time) {
    final double converted = time.doubleValue();
    return toMinutes(converted);
  }

  public abstract double toHours(final double time);

  public long toHours(final long time) {
    final double converted = time;
    final double result = toHours(converted);

    return Primitives.toLong(result);
  }

  public Number toHours(final Number time) {
    final double converted = time.doubleValue();
    return toHours(converted);
  }

  public abstract double toDays(final double time);

  public long toDays(final long time) {
    final double converted = time;
    final double result = toDays(converted);

    return Primitives.toLong(result);
  }

  public Number toDays(final Number time) {
    final double converted = time.doubleValue();
    return toDays(converted);
  }

  public abstract double toWeeks(final double time);

  public long toWeeks(final long time) {
    final double converted = time;
    final double result = toWeeks(converted);

    return Primitives.toLong(result);
  }

  public Number toWeeks(final Number time) {
    final double converted = time.doubleValue();
    return toWeeks(converted);
  }

  public abstract double toMonths(final double time);

  public long toMonths(final long time) {
    final double converted = time;
    final double result = toMonths(converted);

    return Primitives.toLong(result);
  }

  public Number toMonths(final Number time) {
    final double converted = time.doubleValue();
    return toMonths(converted);
  }

  public abstract double toYears(final double time);

  public long toYears(final long time) {
    final double converted = time;
    final double result = toYears(converted);

    return Primitives.toLong(result);
  }

  public Number toYears(final Number time) {
    final double converted = time.doubleValue();
    return toYears(converted);
  }

  public abstract double toDecades(final double time);

  public long toDecades(final long time) {
    final double converted = time;
    final double result = toDecades(converted);

    return Primitives.toLong(result);
  }

  public Number toDecades(final Number time) {
    final double converted = time.doubleValue();
    return toDecades(converted);
  }

  public abstract double toCenturies(final double time);

  public long toCenturies(final long time) {
    final double converted = time;
    final double result = toCenturies(converted);

    return Primitives.toLong(result);
  }

  public Number toCenturies(final Number time) {
    final double converted = time.doubleValue();
    return toCenturies(converted);
  }

  public abstract double convert(final double time, final TimeType type);

  public long convert(final long time, final TimeType type) {
    final double converted = time;
    final double result = convert(converted, type);

    return Primitives.toLong(result);
  }

  public Number convert(final Number time, final TimeType type) {
    final double converted = time.doubleValue();
    return convert(converted, type);
  }

  public static TimeType getTime(final String time) {
    final String converted = time.toUpperCase(Locale.ROOT);
    final TimeType[] values = values();

    return Streams.toStream(values)
        .filter(type -> type.getNames().contains(converted))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid time: " + time));
  }

  public static TimeType getTime(final String time, @Nullable final TimeType orElse) {
    final String converted = time.toUpperCase(Locale.ROOT);
    final TimeType[] values = values();

    return Streams.toStream(values)
        .filter(type -> type.getNames().contains(converted))
        .findFirst()
        .orElse(orElse);
  }

}