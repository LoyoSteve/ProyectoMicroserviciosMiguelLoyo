#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL

    CREATE USER admin PASSWORD 'admin';

    CREATE DATABASE red_social_usuarios OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE red_social_usuarios TO admin;

    CREATE DATABASE red_social_amigos OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE red_social_amigos TO admin;

    CREATE DATABASE red_social_publicaciones OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE red_social_publicaciones TO admin;

    CREATE DATABASE red_social_comentarios OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE red_social_comentarios TO admin;

    CREATE DATABASE red_social_estados OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE red_social_estados TO admin;
EOSQL