CREATE TABLE projects
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    end_date   TIMESTAMP WITH TIME ZONE,
    start_date TIMESTAMP WITH TIME ZONE,
    name       VARCHAR(255)                            NOT NULL,
    manager_id BIGINT,
    CONSTRAINT pk_projects PRIMARY KEY (id)
);

CREATE TABLE users
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name     VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE projects
    ADD CONSTRAINT fk_project_on_manager FOREIGN KEY (manager_id) REFERENCES users (id) ON UPDATE NO ACTION ON DELETE NO ACTION;