package org.hoangdm.order.exceptions;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> error
 ) {
}
