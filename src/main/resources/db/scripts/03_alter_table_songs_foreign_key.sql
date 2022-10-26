ALTER TABLE songs
ADD FOREIGN KEY (artist_id) REFERENCES artists(id);