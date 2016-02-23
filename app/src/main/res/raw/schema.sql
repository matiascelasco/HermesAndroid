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

CREATE TABLE Pictogram (
    _id INTEGER PRIMARY KEY NOT NULL,
    category_id INTEGER,
    name VARCHAR(20) NOT NULL,
    image_id INTEGER NOT NULL,
    sound_id INTEGER NOT NULL
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

--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('no', null, 2130837604, 2131099673);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('si', null, 2130837615, 2131099684);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('banio', 2, 2130837577, 2131099651);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('sed_ninia',2, 2130837613, 2131099682);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('sed_ninio',2, 2130837614, 2131099683);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('cansada',2, 2130837583, 2131099655);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('cansado',2, 2130837584, 2131099656);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('dolorida',3, 2130837594, 2131099663);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('dolorido',3, 2130837595, 2131099664);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('triste_ninia',3, 2130837619, 2131099688);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('triste_ninio',3, 2130837620, 2131099689);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('sorprendida',3, 2130837616, 2131099685);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('sorprendido',3, 2130837617, 2131099686);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('asustada',3, 2130837574, 2131099649);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('asustado',3, 2130837575, 2131099650);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('contenta',3, 2130837589, 2131099660);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('contento',3, 2130837590, 2131099661);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('enojada',3, 2130837596, 2131099665);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('enojado',3, 2130837597, 2131099666);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('caballo',1, 2130837580, 2131099654);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('casco',1, 2130837585, 2131099657);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('cepillo',1, 2130837587, 2131099658);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('zanahoria',1, 2130837621, 2131099690);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('limpieza',1, 2130837600, 2131099669);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('escarba_vasos',1, 2130837598, 2131099667);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('montura',1, 2130837603, 2131099672);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('matra',1, 2130837602, 2131099671);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('pasto',1, 2130837606, 2131099675);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('riendas',1, 2130837612, 2131099680);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('rasqueta_dura',1, 2130837611, 2131099679);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('rasqueta_blanda',1, 2130837610, 2131099678);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('caballo',0, 2130837580, 2131099654);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('caballo',0, 2130837580, 2131099654);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('chapas',0, 2130837588, 2131099659);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('burbujas',0, 2130837579, 2131099653);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('broches',0, 2130837578, 2131099652);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('aro',0, 2130837573, 2131099648);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('letras',0, 2130837599, 2131099668);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('maracas',0, 2130837601, 2131099670);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('palos',0, 2130837605, 2131099674);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('cubos',0, 2130837591, 2131099662);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('pato',0, 2130837607, 2131099676);
--INSERT INTO Pictogram(name, category_id, image_id, sound_id)VALUES('pelota',0, 2130837608, 2131099677);