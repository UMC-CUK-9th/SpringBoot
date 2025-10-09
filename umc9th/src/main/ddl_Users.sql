CREATE TABLE users
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    user_name         VARCHAR(5)            NOT NULL,
    nickname          VARCHAR(10)           NOT NULL,
    user_password     VARCHAR(15)           NOT NULL,
    email             VARCHAR(25)           NOT NULL,
    user_status       VARCHAR(255)          NOT NULL,
    user_point        BIGINT                NULL,
    inactive_date     datetime              NULL,
    user_phone_number VARCHAR(15)           NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);