SELECT * FROM `di-amantes`.purchase;

INSERT INTO `di-amantes`.purchase 
(id_client, date, comments, status)
VALUES(1, NOW(), "Those are great clothes.", "Complete");

INSERT INTO `di-amantes`.purchase 
(id_client, date, comments, status)
VALUES(1, NOW(), "It helps me a lot.", "Complete");

INSERT INTO `di-amantes`.purchase 
(id_client, date, comments, status)
VALUES(3, NOW(), "Thanks for those clothes.", "Complete");

INSERT INTO `di-amantes`.purchase 
(id_client, date, status)
VALUES(5, NOW(), "In progress");

INSERT INTO `di-amantes`.purchase 
(id_client, date, comments, status)
VALUES(2, NOW(), "Cash", "What a great purchase.", "Complete");
