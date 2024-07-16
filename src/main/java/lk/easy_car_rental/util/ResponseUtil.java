package lk.easy_car_rental.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Gathsara
 * created : 10/25/2023 -- 8:38 PM
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseUtil {
    private String state;
    private String message;
    private Object data;
}
