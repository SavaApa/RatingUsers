INSERT INTO users (user_id, user_name, rating)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'user1', 0),
       (UNHEX(REPLACE(UUID(), '-', '')), 'user2', 0),
       (UNHEX(REPLACE(UUID(), '-', '')), 'user3', 0),
       (UNHEX(REPLACE(UUID(), '-', '')), 'user4', 0),
       (UNHEX(REPLACE(UUID(), '-', '')), 'user5', 0);

INSERT INTO reviews (review_id, from_user_id, to_user_id, rating, comment, type_category)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), (SELECT user_id FROM users WHERE user_name = 'user1'), (SELECT user_id FROM users WHERE user_name = 'user2'), 5, 'Excellent work!', 'INTERNSHIP'),
       (UNHEX(REPLACE(UUID(), '-', '')), (SELECT user_id FROM users WHERE user_name = 'user3'), (SELECT user_id FROM users WHERE user_name = 'user2'), 4, 'Good job!', 'STUDY'),
       (UNHEX(REPLACE(UUID(), '-', '')), (SELECT user_id FROM users WHERE user_name = 'user1'), (SELECT user_id FROM users WHERE user_name = 'user4'), 3, 'Average performance.', 'PERSONAL'),
       (UNHEX(REPLACE(UUID(), '-', '')), (SELECT user_id FROM users WHERE user_name = 'user2'), (SELECT user_id FROM users WHERE user_name = 'user5'), 5, 'Outstanding!', 'INTERNSHIP'),
       (UNHEX(REPLACE(UUID(), '-', '')), (SELECT user_id FROM users WHERE user_name = 'user3'), (SELECT user_id FROM users WHERE user_name = 'user4'), 4, 'Well done.', 'STUDY');
