package com.miracle.eva.service.util;

import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class RangeResult {
    @Positive(message = "offset should be positive or equal to 0")
    private final int offset;
    @Positive(message = "limit should be positive or equal to 0")
    private final int limit;
}
