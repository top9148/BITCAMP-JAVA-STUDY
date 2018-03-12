/* 예제에서 사용할 테이블 생성 */
create table jdbc_test (
    no int not null,
    title varchar(200) not null,
    conts text,
    regdt datetime not null,
    vwcnt int default 0 
);

alter table jdbc_test
  add constraint primary key (no);

alter table jdbc_test
  modify column no int not null auto_increment;

  