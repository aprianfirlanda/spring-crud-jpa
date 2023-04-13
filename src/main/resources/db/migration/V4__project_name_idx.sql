-- speed up search by name with index
CREATE INDEX idx_project_name ON projects (name);