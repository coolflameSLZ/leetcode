package util;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArrayUtil {

    public static String arrayToString(int[] nums) {

        return Arrays.stream(nums).mapToObj(Objects::toString).collect(Collectors.joining(","));
    }
}
