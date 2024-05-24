INSERT INTO users (user_id, user_name, rating)
VALUES (X'e8240961836b43cc948c4fb4d2cbcb18', 'user1', 0),
       (X'7fcbff569b9445edb7bd4af5b1d63fbe', 'user2', 0),
       (X'193e4a8138c84f18bdf7590205283979', 'user3', 0),
       (X'bb49bdc24d9b4016ba0ab0016d1dd575', 'user4', 0),
       (X'16cd283813e749a087edbcd53f27fb79', 'user5', 0);

INSERT INTO reviews (review_id, from_user_id, to_user_id, rating, comment, type_category)
VALUES (X'd80d88a62d5e4da39407010287fc7c0a', X'e8240961836b43cc948c4fb4d2cbcb18', X'7fcbff569b9445edb7bd4af5b1d63fbe', 5, 'Excellent work!', 'INTERNSHIP'),
       (X'afed4fbeb75c497cad63b76b7b837ae2', X'7fcbff569b9445edb7bd4af5b1d63fbe', X'193e4a8138c84f18bdf7590205283979', 4, 'Good job!', 'STUDY'),
       (X'1bf8cdbce5ba4bedae534b4ce62b9a52', X'193e4a8138c84f18bdf7590205283979', X'bb49bdc24d9b4016ba0ab0016d1dd575', 3, 'Average performance.', 'PERSONAL'),
       (X'3a9d3f692dde4cf6bce29594b273cf41', X'bb49bdc24d9b4016ba0ab0016d1dd575', X'16cd283813e749a087edbcd53f27fb79', 5, 'Outstanding!', 'INTERNSHIP'),
       (X'7e4ab44b2ef346efac38c00fa7ad36cd', X'e8240961836b43cc948c4fb4d2cbcb18', X'16cd283813e749a087edbcd53f27fb79', 4, 'Well done.', 'STUDY');
