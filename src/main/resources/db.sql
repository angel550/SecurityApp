INSERT INTO permissions (name)
VALUES
    ("CREATE"),
    ("READ"),
    ("UPDATE"),
    ("DELETE"),
    ("REFACTOR");

INSERT INTO roles (role_name)
VALUES ("ADMIN"),
       ("USER"),
       ("INVITED"),
       ("DEVELOPER");

INSERT INTO role_permissions (role_id, permission_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 2),
       (3, 2),
       (4, 1),
       (4, 2),
       (4, 3),
       (4, 4),
       (4, 5);

INSERT INTO users (username, password, is_enabled, account_No_Expired, account_No_Locked, credential_No_Expired)
VALUES ("Jack", "$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6", true, true, true, true),
       ("Micky", "$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6", true, true, true, true),
       ("Sonic", "$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6", true, true, true, true),
       ("Danny", "$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6", true, true, true, true);

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);