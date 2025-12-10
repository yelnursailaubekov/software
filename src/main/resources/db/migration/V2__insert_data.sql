insert into brands ( name ) values ( 'Iphone'),
                                    ('Samsung');


insert into features ( name ) values ( 'cold'),
                                    ('black');



insert into t_item ( name, description, price, brand_id ) values ( 'item', 'desc', 1234, 1),
                                    ( 'item2', 'desc', 1234, 2);

insert into t_item_features ( item_id, features_id ) values (1, 1),
                                                            (2, 2);