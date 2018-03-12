create table ex_book (
  no int not null,
  titl varchar(255) not null,
  dcrt text,
  pric int not null,
  pres varchar(50) not null,
  phot varchar(255),
  pubdt datetime
);

alter table ex_book
  add constraint primary key (no);

alter table ex_book
  modify column no int not null auto_increment;
  
alter table ex_book
  add fulltext index (titl);
  





