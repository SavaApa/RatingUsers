CREATE TABLE IF NOT EXISTS users (
                                     user_id BINARY(16) PRIMARY KEY,
                                     user_name VARCHAR(50) NOT NULL UNIQUE,
                                     rating DOUBLE DEFAULT 0
);

CREATE TABLE IF NOT EXISTS reviews (
                                       review_id BINARY(16) PRIMARY KEY,
                                       from_user_id BINARY(16),
                                       to_user_id BINARY(16),
                                       rating INT,
                                       comment TEXT,
                                       type_category VARCHAR(50),
                                       FOREIGN KEY (from_user_id) REFERENCES users(user_id),
                                       FOREIGN KEY (to_user_id) REFERENCES users(user_id)
);
CREATE TABLE IF NOT EXISTS top_users (
                           top_user_id BINARY(16) PRIMARY KEY,
                           user_id BINARY(16),
                           user_name VARCHAR(50),
                           rating DOUBLE,
                           FOREIGN KEY (user_id) REFERENCES users(user_id)
);

