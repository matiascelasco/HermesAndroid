CREATE TABLE Settings (
    _id INTEGER PRIMARY KEY NOT NULL,
    ip_address VARCHAR(12) NOT NULL,
    port VARCHAR(4) NOT NULL,
    show_network_errors INTEGER NOT NULL
);

CREATE TABLE Kid (
    _id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(20) NOT NULL,
    gender VARCHAR(1) NOT NULL,
    pictogramSize INTEGER NOT NULL
);

CREATE TABLE Pictogram (
    _id INTEGER PRIMARY KEY NOT NULL,
    category_id INTEGER,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE KidCategory (
    kid_id INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    FOREIGN KEY(kid_id) REFERENCES Kid(_id),
    UNIQUE(kid_id, category_id) ON CONFLICT REPLACE
);

CREATE TABLE KidPictogram (
    _id INTEGER PRIMARY KEY NOT NULL,
    kid_id INTEGER NOT NULL,
    pictogram_id INTEGER NOT NULL,
    FOREIGN KEY(kid_id) REFERENCES Kid(_id),
    FOREIGN KEY(pictogram_id) REFERENCES Pictogram(_id),
    UNIQUE(kid_id, pictogram_id) ON CONFLICT REPLACE
);

