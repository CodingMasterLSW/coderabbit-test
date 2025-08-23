import lombok.Getter;

/**
 * - 개행이 올바르지 않을 때, 지적을 해주는지 테스트
 * - 매개변수 final을 붙이지 않았을 때, 지적을 해주는지 테스트
 */
@Getter
public class TeamConvention {
    private final String a;
    private final String b;

    public TeamConvention(String a,  String b) {
        this.a = a;
        this.b = b;
    }
}
