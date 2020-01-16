INSERT INTO enaplodbv2.authorities(id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_STUDENT'),
(3, 'ROLE_TEACHER'),
(4, 'ROLE_HEADTEACHER');

/* password: admin */
INSERT INTO enaplodbv2.users(id, username, password, fullname) VALUES
(1, 'admin', '$2y$10$ddvAIVBrkHYhge0t/RY1VuxbxzNeBbSBSI7GM4ExWuela2ZEH/fI6', 'admin');