-- Table: public.Node

-- DROP TABLE IF EXISTS public."Node";

CREATE TABLE IF NOT EXISTS public."Node"
(
    from_node_id integer NOT NULL,
    to_node_id integer NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Node"
    OWNER to postgres;