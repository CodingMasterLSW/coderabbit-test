CREATE TABLE feedback
(
    id          BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    created_at  DATETIME(6) NOT NULL,
    modified_at DATETIME(6) NOT NULL,
    content     VARCHAR(255),
    is_secret   TINYINT(1) NOT NULL,
    place_id    BIGINT,
    status      VARCHAR(50),
    image_url   VARCHAR(255),
    user_name   VARCHAR(255),
    like_count  INT DEFAULT 0
);