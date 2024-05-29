CREATE TABLE IF NOT EXISTS employe (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    occupation VARCHAR(255) NOT NULL,
    salaire VARCHAR(255) NOT NULL,
    datedebut DATE NOT NULL,
    datefin DATE NOT NULL,
    numeroidentifiant VARCHAR(255) NOT NULL,
    datenaissance DATE NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telephone VARCHAR(20) NOT NULL,
    description TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS conge (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    datedebut DATE NOT NULL,
    datefin DATE NOT NULL,
    employe_id BIGINT NOT NULL,
    CONSTRAINT fk_employe_conge FOREIGN KEY (employe_id) REFERENCES employe(id)
);

CREATE TABLE IF NOT EXISTS absence (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    employe_id BIGINT NOT NULL,
    CONSTRAINT fk_employe_absence FOREIGN KEY (employe_id) REFERENCES employe(id)
);

CREATE TABLE IF NOT EXISTS candidat (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    numeroidentite VARCHAR(255) NOT NULL,
    datenaissance DATE NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telephone VARCHAR(20) NOT NULL,
    note VARCHAR(255) NOT NULL,
    domainetechnique VARCHAR(255) NOT NULL,
    dateentretien DATE NOT NULL,
    description TEXT NOT NULL
);

-- Insérer des employés
INSERT INTO employe (nom, occupation, salaire, datedebut, datefin, numeroidentifiant, datenaissance, adresse, email, telephone, description)
VALUES ( 'John Doe', 'Developpeur', '50000', '2021-01-01', '2021-12-31', '123456', '1985-05-15', '123 Rue Principale', 'johndoe@example.com', '1234567890', 'Description de John Doe');

INSERT INTO employe ( nom, occupation, salaire, datedebut, datefin, numeroidentifiant, datenaissance, adresse, email, telephone, description)
VALUES ( 'Jane Smith', 'Designer', '45000', '2021-02-01', '2021-12-31', '654321', '1990-07-25', '456 Avenue Centrale', 'janesmith@example.com', '0987654321', 'Description de Jane Smith');

-- Insérer des congés pour les employés
INSERT INTO absence ( date, employe_id)
VALUES ( '2021-07-01', 1);

INSERT INTO absence ( date, employe_id)
VALUES ( '2021-12-25', 1);

INSERT INTO absence ( date, employe_id)
VALUES ( '2021-08-15', 2);

INSERT INTO absence ( date, employe_id)
VALUES ( '2021-11-10', 2);

-- Insérer des absences pour les employés
INSERT INTO conge (datedebut, datefin, employe_id)
VALUES ( '2021-05-01', '2021-05-05', 1);

INSERT INTO conge (datedebut, datefin, employe_id)
VALUES ( '2021-09-15', '2021-09-20', 1);

INSERT INTO conge (datedebut, datefin, employe_id)
VALUES ( '2021-06-01', '2021-06-03', 2);

INSERT INTO conge (datedebut, datefin, employe_id)
VALUES ( '2021-10-01', '2021-10-10', 2);

-- Insérer des candidats
INSERT INTO candidat ( nom, numeroidentite, datenaissance, adresse, email, telephone, note, domainetechnique, dateentretien, description)
VALUES ( 'Alice Martin', '987654', '1995-01-10', '789 Rue Nouvelle', 'alicemartin@example.com', '3216549870', '6', 'Informatique', '2023-01-15', 'Description de Alice Martin');

INSERT INTO candidat ( nom, numeroidentite, datenaissance, adresse, email, telephone, note, domainetechnique, dateentretien, description)
VALUES ('Bob Brown', '123789', '1988-11-22', '101 Avenue Verte', 'bobbrown@example.com', '7896543210', '9', 'Design', '2023-02-20', 'Description de Bob Brown');
