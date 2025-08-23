# 네이밍, 스타일 가이드

-  기본적으로 Google Code Style Guide를 따른다.
-  검증 혹은 boolean 반환 메서드는 긍정문을 사용한다.
- dto라는 네이밍은 너무 포괄적이므로, 아래와 같이 목적을 정확하게 하자.
    - ~request, ~response

# Java Code Style
- 기본적으로 Google Code Style을 따른다.
- 변경사항
    - Tab Size : 4
    - Indent : 4
    - Continuation indent : 8

# 코드 컨벤션

- 클래스와 선언부 필드 사이는 개행한다.
- `@Valid`를 통한 입력값 검증을 진행한다.
    - `@NotBlank`, `@NotNull` 을 사용한다.
- Enum의 값을 정의할 때, 후행 쉼표를 사용한다.
- Lombok 라이브러리를 사용하되, 그 범위를 제한한다.
    - `@Getter`, `@NoArgsConstructor`, `@RequiredArgsConstructor`, `@Builder`**(필드값 4개 이상 시 사용가능)**
- 어노테이션이 여럿 있는 경우, 중요한 것을 가장 상단에 배치한다.
    - Lombok의 어노테이션을 가장 아래에 배치한다.

# 클래스, 변수 및 메서드 관리

- dto는 record로 생성한다.
- 메서드의 순서는 `public`을 위에 두되, `private`의 경우 사용하는 메서드 아래에 둔다.
- 필드 변수는 `static final` → `final` → `instance variable` 순서로 정의한다.
- 메서드 매개변수, 지역 변수에는 `final`을 사용한다.
    - 초기화되지 않은 상태로 변수를 선언하지 말자.

# 엔티티

- `@Table`과 `@Column` 으로 테이블명, 컬럼명을 기본적을 명시하지 않되, 필요에 따라 논의 후 적용한다.
    - 예약어인 경우 복수형 또는 동의어를 찾아 작성한다 (예: `order` → `orders`)
- `@Column` 어노테이션의 `nullable` 은 false인 경우 표기한다.
- `@Embeddable` 내부에는 `@Embedded`을 사용하지 않는다.

# 로깅

- 로그 레벨은 아래와 같이 관리한다. 추가로 필요하다면 자유롭게 로깅한다.
    - info: 외부 API 응답 / 요청은 남긴다.
    - warn: 내일 아침에 데일리에서 확인해도 무방한 사항
    - error: 자다가도 일어나서 확인해야 하는 사항 → 외부 API 타임아웃, DB 저장 실패 등

# 서비스 & 컨트롤러 구조 및 관리

- `@RestController`에서 `@RequestMapping`을 최상단에 사용하지 않는다.
    - 사용하지 않는 경우, 코드 중복이 늘어나지만 각각의 메서드를 따로 관리할 수 있다.
- 클래스 최상단에 `@Transactional(readOnly = true)`을 작성한다.

# 오류 및 예외 처리

- 커스텀 예외
    - 자바가 정의한 표준 예외를 그대로 사용하면, 우리가 원치 않는 스택 트레이스까지 모두 찍힌다.
    - 예외에 따른 다른 행동으로 처리하고 싶을 때
- 예외 처리 전략
    - ErrorCode(HttpStatus, message, errorCode)
    - 전역 예외 핸들러
    - 전역 커스텀 예외 클래스
    - 도메인 예외 핸들러
    - 도메인 커스텀 예외 클래스(클래스 내부 필드에 ErrorCode 선언)

  Flow
    - 전역 예외 핸들러 → 전역 커스텀 예외 클래스 Handle
    - 도메인 예외 핸들러 → 도메인 커스텀 예외 클래스 Handler
    - 메세지는 enum을 사용해 {code, message, statusCode} 로 관리한다