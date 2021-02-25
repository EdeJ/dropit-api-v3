INSERT INTO role(name) VALUES ('ROLE_USER');
INSERT INTO role(name) VALUES ('ROLE_MODERATOR');
INSERT INTO role(name) VALUES ('ROLE_ADMIN');

-- USERNAME: emieldejong@xs4all.nl
-- PASSWORD: password
-- ROLES: user
INSERT INTO app_user (username, first_name, last_name, email, password) VALUES ('emieldejong@xs4all.nl', 'Emiel', 'de Jong', 'emieldejong@xs4all.nl', '$2a$10$2JY2g4Jbmz65ch664BHONOW19LxF3tH94zwiL9ctL.vI5U5bAEvf6');
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);

-- USERNAME: test@test.nl
-- PASSWORD: password
-- ROLES: ADMIN & USER
INSERT INTO app_user (username, email, password) VALUES ('test@test.nl', 'test@xs4all.nl', '$2a$10$2JY2g4Jbmz65ch664BHONOW19LxF3tH94zwiL9ctL.vI5U5bAEvf6');
INSERT INTO user_role (user_id, role_id) VALUES (2, 3);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);

-- USERNAME: user@dropit.com
-- PASSWORD: password
-- ROLES: user
INSERT INTO app_user (username, first_name, last_name, country, email, password, instagram) VALUES ('user@dropit.com', 'Anakin', 'Skywalker', 'Netherlands', 'user@dropit.com', '$2a$10$2JY2g4Jbmz65ch664BHONOW19LxF3tH94zwiL9ctL.vI5U5bAEvf6', 'https://www.instagram.com/starwars/');
INSERT INTO user_role (user_id, role_id) VALUES (3, 1);

-- USERNAME: admin@dropit.com
-- PASSWORD: password
-- ROLES: admin
INSERT INTO app_user (username, first_name, last_name, email, country, password, facebook) VALUES ('admin@dropit.com', 'Charlie', 'Parker', 'US', 'admin@dropit.com', '$2a$10$2JY2g4Jbmz65ch664BHONOW19LxF3tH94zwiL9ctL.vI5U5bAEvf6', 'https://www.facebook.com/charlieparkermusic');
INSERT INTO user_role (user_id, role_id) VALUES (4, 3);

-- USERNAME: elvispresley@gmail.com
-- PASSWORD: password
-- ROLES: user
INSERT INTO app_user (username, first_name, last_name, email, password, facebook) VALUES ('elvispresley@gmail.com', 'Elvis', 'Presley', 'elvispresley@gmail.com', '$2a$10$2JY2g4Jbmz65ch664BHONOW19LxF3tH94zwiL9ctL.vI5U5bAEvf6', 'https://www.facebook.com/elvis');
INSERT INTO user_role (user_id, role_id) VALUES (5, 1);

INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Daft Punk', '3a2516c8-64d3-41d0-8157-e8436175e52f.mp3', 'Doin'' It Right', 1);
INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Steely Dan', '066bb4db-ef44-4548-9e01-2541e2426229.mp3', 'Slang Of Ages', 1);

INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Daft Punk', '4796f2ba-d56f-49e3-88dd-f7796585d877.mp3', 'Within', 3);
INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Daft Punk', 'f9500aa3-399a-4224-b635-5fa7cdbc6cc6.mp3', 'Instant Crush', 3);
INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Daft Punk', '32874b1c-ab53-46ef-9bd5-96ad71371bae.mp3', 'Motherboard', 3);
INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Steely Dan', '8497b053-8267-4b24-89e4-9d2cbec77376.mp3', 'Janie Runaway', 3);

INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Frank Sinatra', '04ac81fc-52d1-41d7-874d-9401987d17a9.mp3', 'I Get A Kick Out Of You', 5);
INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Frank Sinatra', '3591b9a5-e290-47ad-89be-956f8a143cdc.mp3', 'They Can''t Take That Away From Me', 5);
INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Unknown', '1419c83c-d1ca-4841-92ca-63fa75d22a5f.mp3', 'Jazz Muziek', 5);
INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Frank Sinatra', '7a862015-fd84-4e83-b6c3-b1e08f6b2b3d.mp3', 'Come Fly With Me', 5);
INSERT INTO demo (artist, file_name, song_title, user_id) VALUES ('Sarah Vaughan', '79bdd218-d66d-4845-a980-3300d29ad0c8.mp3', 'Lullaby of Birdland', 5);


INSERT INTO comment (message, viewed, demo_id) VALUES ('An exceedingly ambitious instrumental: flutes run around the scattered rhythms, acoustic finger-picking sprouts out of drum rolls, strings are jammed into the action and the arrangement eventually evaporates into become a cloud of something far more sinister. Serenity is eventually reached, but not before multiple other worlds are unearthed. Great demo!

The Dropit Team', false, 5);
INSERT INTO comment (message, viewed, demo_id) VALUES ('We love this sound, style, and production techniques of the 1970s and early 80s. A mix of disco, soft rock, and prog-pop, along with some Broadway-style pop bombast and even a few pinches of squelching stadium-dance aesthetic. It’s all rendered with an amazing level of detail, with no expense spared.

This demo was clearly recorded in the best studios, and played by the best musicians. This demo could take the listener on a trip. We definitely love this demo!

The Droptit Team', false, 3);

INSERT INTO comment (message, viewed, demo_id) VALUES ('“Janie Runaway” is a crisp, dry production, a lean groove anchored by a fat, bubbling bass line and smart horn arrangement.

The Dropit Team', false, 6);

INSERT INTO comment (message, viewed, demo_id) VALUES ('The rhythm track fits perfectly and the lyrics display the typical biting humor you’d expect on a Becker solo track.

Add to that a tight and funky groove forged by Becker’s bass and drummer Keith Carlock. Additionally, Walt Weiskopf, Steely Dan’s touring tenor man since 2003, delivers a lustful sax solo to help things along. just a fantastic track!

The dropit Team', false, 2);

INSERT INTO comment (message, viewed, demo_id) VALUES ('“One of the finest things ever recorded. This one is definitely a strong candidate for, "if I was on a desert island and could only have one album to listen to".

Amazing performances all around - such elegance, subtlety, purity of expression.

The Dropit Team', false, 11);

INSERT INTO comment (message, viewed, demo_id) VALUES ('We believe this demo is not danceable.
Give it another try!

The Dropit Team', false, 9);


