INSERT INTO manufacturer(id, created_at, modified_at, about, vat_nr, name)
VALUES (1, current_timestamp, current_timestamp, 'Rucne vyrabene nastroje', 'CZ123', 'Kovarstvi'),
       (2, current_timestamp, current_timestamp, 'Vse pro preziti v lese', 'CZ456', 'Svet outdooru'),
       (3, current_timestamp, current_timestamp, 'Kvalitni plastove vyrobky', 'CZ789', 'Plastove vyrobky');

INSERT INTO product_group(id, created_at, modified_at, description, name)
VALUES (1, current_timestamp, current_timestamp, 'Noze, sekery, zbrane', 'Noze a sekery'),
       (2, current_timestamp, current_timestamp, 'Nastroje k preziti v lese', 'Nastroje a naradi'),
       (3, current_timestamp, current_timestamp, 'Vse pro vareni v lese', 'Nadobi');
