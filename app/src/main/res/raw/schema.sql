CREATE TABLE GeneralSettings (
    _id INTEGER PRIMARY KEY NOT NULL,
    ip_address VARCHAR(12) NOT NULL,
    port INTEGER NOT NULL
);

INSERT INTO GeneralSettings(ip_address, port) VALUES('192.168.100.1', '8080');

CREATE TABLE Kid (
    _id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(20) NOT NULL,
    gender VARCHAR(1) NOT NULL,
    pictogramSize INTEGER NOT NULL
);

CREATE TABLE Pictograms (
    _id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL,
    path VARCHAR(20) NOT NULL,
    id_category INTEGER NOT NULL
);