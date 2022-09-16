CREATE TABLE person
(
  person_id    SERIAL,
  first_name   VARCHAR NOT NULL,
  last_name    VARCHAR NOT NULL,
  username     VARCHAR NOT NULL,
  password     VARCHAR,
  phone_number VARCHAR NOT NULL,
  email        VARCHAR NOT NULL,
  PRIMARY KEY (person_id)
);

CREATE TABLE role
(
  role_id   SERIAL,
  role_type VARCHAR NOT NULL,
  PRIMARY KEY (role_id)
);

CREATE TABLE person_role
(
  person_role_id SERIAL,
  person_id      INTEGER  NOT NULL,
  role_id        INTEGER  NOT NULL,
  user_since     TIMESTAMP NOT NULL,
  user_until     TIMESTAMP,
  PRIMARY KEY (person_role_id)
);

CREATE TABLE product
(
  product_id  SERIAL,
  description VARCHAR NOT NULL,
  price       DECIMAL NOT NULL,
  sale_price  DECIMAL NOT NULL,
  PRIMARY KEY (product_id)
);


CREATE TABLE purchase_order
(
  order_id       SERIAL,
  person_role_id INTEGER  NOT NULL,
  sale_date      TIMESTAMP NOT NULL,
  description    VARCHAR ,
  PRIMARY KEY (order_id)
);

CREATE TABLE order_detail
(
  order_detail_id SERIAL,
  order_id        INTEGER NOT NULL,
  product_id      INTEGER NOT NULL,
  quantity        INTEGER NOT NULL,
  description     VARCHAR,
  PRIMARY KEY (order_detail_id)
);


ALTER TABLE person_role
  ADD CONSTRAINT FK_PERSON_TO_USER_ROLE
    FOREIGN KEY (person_id)
    REFERENCES person (person_id);

ALTER TABLE person_role
  ADD CONSTRAINT FK_ROLE_TO_USER_ROLE
    FOREIGN KEY (role_id)
    REFERENCES role (role_id);

ALTER TABLE purchase_order
  ADD CONSTRAINT FK_USER_ROLE_TO_ORDER
    FOREIGN KEY (person_role_id)
    REFERENCES person_role (person_role_id);

ALTER TABLE order_detail
  ADD CONSTRAINT FK_ORDER_TO_ORDER_DETAIL
    FOREIGN KEY (order_id)
    REFERENCES purchase_order (order_id);

ALTER TABLE order_Detail
  ADD CONSTRAINT FK_PRODUCT_TO_ORDER_DETAIL
    FOREIGN KEY (product_id)
    REFERENCES product (product_id);

CREATE INDEX person_role_idx
  ON person_role (person_role_id ASC, person_id ASC, role_id ASC, user_since ASC);