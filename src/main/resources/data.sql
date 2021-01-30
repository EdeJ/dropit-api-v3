/*
Spring runt dit SQL-bestand automatisch. Spring zoekt namelijk naar een bestand dat data.sql heet (in deze folder) en
voert de SQL commando's voor je uit. Dit is een van de manier om de database te vullen. Om dit te laten werken, is het
volgende aan application.properties toegevoegd:

spring.datasource.initialization-mode=always

Zoals gezegd, dit is een van de manieren. De huidige opzet avn deze applicatie heeft een vast aantal user-rollen. Deze
kunnen niet door eindgebruikers, moderators of admins toegevoegd worden. Alleen de programmeur kan user-rollen
toevoegen. Daarom is er ook geen Service & repo voor de user-rollen geprogrammeerd. De enige manier om dan iets in de
database te krijgen is via SQL statements in dit bestand.

 */
INSERT INTO role(name) VALUES ('ROLE_USER');
INSERT INTO role(name) VALUES ('ROLE_MODERATOR');
INSERT INTO role(name) VALUES ('ROLE_ADMIN');

-- password: geheim
-- roles: USER
INSERT INTO app_user (username, email, password) VALUES ('emieldejong@xs4all.nl', 'emieldejong@xs4all.nl', '$2a$10$w1a.lrsfLJ1su/dsySdVROoLwb5FnO3xHmWXcvW005274IF5XD.me');
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);

-- password: password
-- roles: ADMIN
INSERT INTO app_user (username, email, password) VALUES ('talcanetti@xs4all.nl', 'talcanetti@xs4all.nl', '$2a$10$2W8DY8K42QCub6QnVeF0rOQe7uT9LiwZK87aAEgW9rZ8lQOZPxcmq');
INSERT INTO user_role (user_id, role_id) VALUES (2, 3);

-- password: password
-- roles: ADMIN & USER
INSERT INTO app_user (username, email, password) VALUES ('test@test.nl', 'test@xs4all.nl', '$2a$10$2W8DY8K42QCub6QnVeF0rOQe7uT9LiwZK87aAEgW9rZ8lQOZPxcmq');
INSERT INTO user_role (user_id, role_id) VALUES (3, 3);
INSERT INTO user_role (user_id, role_id) VALUES (3, 1);


INSERT INTO comment (message) VALUES ('Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere dolorum odio error a doloremque ad quasi illo vitae quod quo al');

INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Wouter Kronenberg', 'audio-test-file.mp3', 'Marshmallow Mountains', 1)





