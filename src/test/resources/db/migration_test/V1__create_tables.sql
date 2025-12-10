create table brands (
    id bigserial primary key,
    name varchar
);

create table features (
    id bigserial primary key,
    name varchar
);

create table t_item (
    id bigserial primary key,
    name varchar,
    description varchar,
    price int,
    brand_id bigint references brands(id) on delete cascade
);

create table t_item_features (
    item_id bigint not null references t_item(id) on delete cascade,
    features_id bigint not null references features(id) on delete cascade
);
