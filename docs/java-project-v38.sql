/* 성적 정보 테이블 */

drop table ex_score;
drop table ex_board;
drop table ex_memb;
drop table ex_room;


create table ex_score (
    no int not null,
    name varchar(30) not null,
    kor int not null,
    eng int not null,
    math int not null
);

alter table ex_score
    add constraint primary key (no);

alter table ex_score
    modify column no int not null auto_increment;
    
alter table ex_score
    add fulltext (name);
    

create table ex_memb (
    no int not null,
    name varchar(30) not null,
    email varchar(50) not null,
    pwd varchar(100) not null,
    regdt datetime not null
);

alter table ex_memb
    add constraint primary key (no);

alter table ex_memb
    modify column no int not null auto_increment;
    
alter table ex_memb
    add fulltext index (name);
    
alter table ex_memb
    add constraint unique (email);
    
create table ex_board (
    no int not null,
    title varchar(200) not null,
    conts text,
    regdt datetime not null,
    vwcnt int default 0 
);

alter table ex_board
  add constraint primary key (no);

alter table ex_board
  modify column no int not null auto_increment;    
    
    
create table ex_room (
    no int not null,
    loc varchar(20) not null,
    name varchar(20) not null,
    capacity int not null
);    
    
alter table ex_room
    add constraint primary key (no);

alter table ex_room
    modify column no int not null auto_increment;
    
alter table ex_room
    add unique (loc, name);
    
    
    
    
    
    
    
    
    
    
    
    
    
    