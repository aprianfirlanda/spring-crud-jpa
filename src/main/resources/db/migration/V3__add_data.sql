INSERT INTO projects (name, start_date, manager_id)
VALUES ('Maniculus', NOW(), 1);
INSERT INTO tasks (name, start_date, project_id, assignee_id)
VALUES ('Structural Plan', NOW(), 1, 2);
INSERT INTO tasks (name, project_id, assignee_id)
VALUES ('Feature Design', 1, 3);