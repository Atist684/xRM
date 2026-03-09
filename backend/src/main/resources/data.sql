WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Alpha Kft', '10000001-1-42', 'Budapest', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'TOP' FROM new_customer
UNION ALL
SELECT id, 'Export' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Beta Kft', '10000002-1-42', 'Szeged', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Foreign' FROM new_customer
UNION ALL
SELECT id, 'Export' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Gamma Kft', '10000003-1-42', 'Debrecen', 'Inactive', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Active' FROM new_customer
UNION ALL
SELECT id, 'TOP' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Delta Kft', '10000004-1-42', 'Győr', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Export' FROM new_customer
UNION ALL
SELECT id, 'Foreign' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Omega Kft', '10000005-1-42', 'Pécs', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'TOP' FROM new_customer
UNION ALL
SELECT id, 'Active' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Nova Kft', '10000006-1-42', 'Budapest', 'Inactive', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Foreign' FROM new_customer
UNION ALL
SELECT id, 'Active' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Solar Kft', '10000007-1-42', 'Miskolc', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Export' FROM new_customer
UNION ALL
SELECT id, 'TOP' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Vector Kft', '10000008-1-42', 'Székesfehérvár', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Active' FROM new_customer
UNION ALL
SELECT id, 'Foreign' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Atlas Kft', '10000009-1-42', 'Kecskemét', 'Inactive', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'TOP' FROM new_customer
UNION ALL
SELECT id, 'Export' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Orion Kft', '10000010-1-42', 'Nyíregyháza', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Foreign' FROM new_customer
UNION ALL
SELECT id, 'Export' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Vertex Kft', '10000011-1-42', 'Budapest', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Active' FROM new_customer
UNION ALL
SELECT id, 'TOP' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Sigma Kft', '10000012-1-42', 'Győr', 'Inactive', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Export' FROM new_customer
UNION ALL
SELECT id, 'Foreign' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Prime Kft', '10000013-1-42', 'Debrecen', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'TOP' FROM new_customer
UNION ALL
SELECT id, 'Active' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Titan Kft', '10000014-1-42', 'Szeged', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Foreign' FROM new_customer
UNION ALL
SELECT id, 'TOP' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Fusion Kft', '10000015-1-42', 'Pécs', 'Inactive', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Export' FROM new_customer
UNION ALL
SELECT id, 'Active' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Quantum Kft', '10000016-1-42', 'Budapest', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'TOP' FROM new_customer
UNION ALL
SELECT id, 'Foreign' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('DeltaTrade Kft', '10000017-1-42', 'Miskolc', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Active' FROM new_customer
UNION ALL
SELECT id, 'Export' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Hyper Kft', '10000018-1-42', 'Győr', 'Inactive', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Foreign' FROM new_customer
UNION ALL
SELECT id, 'Active' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Matrix Kft', '10000019-1-42', 'Kecskemét', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'Export' FROM new_customer
UNION ALL
SELECT id, 'TOP' FROM new_customer;

WITH new_customer AS (
INSERT INTO customer (name, tax_number, address, status, deleted)
VALUES ('Nexus Kft', '10000020-1-42', 'Budapest', 'Active', false)
RETURNING id
)
INSERT INTO customer_classification (customer_id, classification)
SELECT id, 'TOP' FROM new_customer
UNION ALL
SELECT id, 'Foreign' FROM new_customer;




INSERT INTO app_user (first_name, last_name, deleted)
VALUES
('John', 'Doe', false),
('Jane', 'Smith', false),
('Robert', 'Johnson', false),
('Emily', 'Davis', false);

INSERT INTO task_type (type)
VALUES
('Call'),
('Meeting'),
('Email'),
('Support'),
('Offer');

INSERT INTO task (subject, task_type_id, description, time, responsible_user_id, customer_id, deleted) VALUES
('Call customer about contract', 1, 'Discuss contract renewal and pricing', 60, 1, 1, false),
('Prepare sales offer', 5, 'Create offer document for new product', 120, 2, 2, false),
('On-site meeting', 2, 'Visit customer office for project kickoff', 180, 3, 7, false),
('Support follow-up', 4, 'Check if previously reported issue is resolved', 30, 4, 4, false)
;
