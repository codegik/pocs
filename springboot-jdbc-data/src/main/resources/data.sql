INSERT INTO person (id, name) VALUES (1, 'Alice');
INSERT INTO person (id, name) VALUES (2, 'Bob');
INSERT INTO person (id, name) VALUES (3, 'Charlie');

INSERT INTO address (id, street, is_soft_deleted) VALUES (1, '123 Main St', FALSE);
INSERT INTO address (id, street, is_soft_deleted) VALUES (2, '456 Oak Ave', FALSE);
INSERT INTO address (id, street, is_soft_deleted) VALUES (3, '789 Pine Ln', FALSE);
INSERT INTO address (id, street, is_soft_deleted) VALUES (4, '321 Deleted St', TRUE);
