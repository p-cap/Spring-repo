DROP TABLE IF EXISTS network;
CREATE TABLE network(id serial PRIMARY KEY,
                    IP VARCHAR(255),
                    URL VARCHAR(5000),
                    UserAgent VARCHAR(400),
                    Domain VARCHAR(255)
                    );