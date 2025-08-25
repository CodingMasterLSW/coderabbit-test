import lombok.Getter;

@Getter
public class LottoResponseDto {

    private String value;

    public LottoResponseDto(final String value) {
        this.value = value;
    }
}
