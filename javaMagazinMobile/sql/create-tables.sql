-- Table: address

-- DROP TABLE address;

CREATE TABLE produkt
(
  id serial NOT NULL,
  bezeichnung character varying(20),
  beschreibung character varying(255),
  preis numeric(5,2),
  mwstsatz smallint,
  CONSTRAINT produkt_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
