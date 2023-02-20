DROP TABLE if EXISTS hits;
CREATE TABLE if NOT EXISTS public.hits (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    app VARCHAR NOT NULL,
    uri VARCHAR NOT NULL,
    ip VARCHAR NOT NULL,
    timestamp TIMESTAMP without time zone NOT NULL
    );