DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    idx         INT          NOT NULL AUTO_INCREMENT,
    id          VARCHAR(255) NOT NULL,
    pw          VARCHAR(255) NOT NULL,
    delete_yn   VARCHAR(1)   NOT NULL DEFAULT 'N',
    create_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP    NULL ON UPDATE CURRENT_TIMESTAMP,
    delete_date TIMESTAMP    NULL,
    PRIMARY KEY (idx),
    UNIQUE (id)
);

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
    idx         INT          NOT NULL AUTO_INCREMENT,
    user_idx    INT          NOT NULL,
    role        VARCHAR(255) NOT NULL,
    create_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (idx),
    FOREIGN KEY (user_idx) REFERENCES `user` (idx),
    CONSTRAINT check_role CHECK (role IN ('ADMIN', 'USER'))
);

DROP TABLE IF EXISTS `todo`;
CREATE TABLE `todo`
(
    idx         INT          NOT NULL AUTO_INCREMENT,
    user_idx    INT          NOT NULL,
    content     VARCHAR(255) NOT NULL,
    done_yn     VARCHAR(1)   NOT NULL DEFAULT 'N',
    delete_yn   VARCHAR(1)   NOT NULL DEFAULT 'N',
    create_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP    NULL ON UPDATE CURRENT_TIMESTAMP,
    delete_date TIMESTAMP    NULL,
    PRIMARY KEY (idx),
    FOREIGN KEY (user_idx) REFERENCES `user` (idx)
);