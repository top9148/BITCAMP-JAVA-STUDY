/* 이 SQL은 bitcamp-java-project-v38.sql에 추가해야 한다.*/

/* 게시글 첨부 파일명을 저장할 테이블을 정의한다.*/
create table ex_file (
  no int not null,
  filename varchar(255) not null,
  bno int not null
);

/* primary key 컬럼 지정 */
alter table ex_file
  add constraint primary key (no);

/* ex_file의 pk 컬럼은 자동증가 컬럼으로 만든다. */
alter table ex_file
  modify column no int not null auto_increment;

/* ex_file의 bno 컬럼을 ex_board의 no 값을 참조하는 외부키로 만든다.*/
alter table ex_file
  add constraint foreign key (bno) references ex_board(no);


/* ex_board 와 ex_file 테이블의 데이터를 조인하여 가져오기 */

/* => 게시물 데이터만 가져오기 */ 
select no, title, conts, regdt, vwcnt, mno
from ex_board
where no=32;

/* => 게시물 작성자의 데이터만 가져오기 */
select no, name, email
from ex_memb
where no=12;
  
/* => 게시물 첨부파일 데이터만 가져오기 */
select no, filename
from ex_file
where bno=32;
  
/* => 게시물 데이터와 작성자 데이터 조인하기 */
select 
    b.no, 
    b.title, 
    b.conts, 
    b.regdt, 
    b.vwcnt, 
    m.no, 
    m.name, 
    m.email
from ex_board as b join ex_memb as m on b.mno=m.no
where b.no=32;  
  
/* => 게시물 데이터와 작성자 데이터와 파일 데이터 조인하기 */
select 
    b.no, 
    b.title, 
    b.conts, 
    b.regdt, 
    b.vwcnt, 
    m.no, 
    m.name, 
    m.email,
    f.no,
    f.filename
from 
    ex_board as b 
    join ex_memb as m on b.mno=m.no
    left join ex_file as f on b.no=f.bno
where b.no=32;  
  
/* ex_file 테이블에 Cascade 기능을 적용하기 */
/* => 먼저 foreign key에 대한 constraint 이름을 알아낸다.*/
show create table ex_file;

/* => 기존의 등록된 외부키 constraint를 제거한다. */
alter table ex_file
  drop foreign key ex_file_ibfk_1;

/* => cascade 기능이 추가된 외부키 constaint를 등록한다.*/
alter table ex_file
  add constraint foreign key (bno) references ex_board(no) on delete cascade;
  
  
  
  
  
  
  
  
  
