import java.time.ZonedDateTime;

/**
 * @author yx start
 * @create 2020/4/8,18:49
 */
public class TestZone {
    public static void main(String[] args) {
        // 默认时区
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
