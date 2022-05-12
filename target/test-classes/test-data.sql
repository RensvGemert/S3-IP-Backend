DROP TABLE IF EXISTS testTable;

CREATE TABLE testTable (productId INT PRIMARY KEY , productTitle VARCHAR(255) , productDescription VARCHAR(255));

INSERT INTO testTable (`productId`, `productTitle`, `productDescription`) VALUES (1, 'Testbike1', 'Testdescription');