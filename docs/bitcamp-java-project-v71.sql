/* 이 SQL은 bitcamp-java-project-v38.sql에 추가해야 한다.*/

/* ex_board 에 게시글 작성자 컬럼을 추가한다.*/
alter table ex_board
  add column mno int not null;

/* 작성자 컬럼을 ex_memb 테이블의 no 컬럼을 참조하는 외부키로 선언한다.*/
alter table ex_board
  add constraint foreign key (mno) references ex_memb(no); 

/* ex_board와 ex_memb 테이블 조인하여 데이터 select하기*/
/* 1) 게시판 테이블 데이터 가져오기 */
select no, title, regdt, vwcnt, mno
from ex_board;

/* 2) 회원 테이블 데이터 가져오기 */
select no, name
from ex_memb;

/* 3) 게시판과 회원 테이블의 데이터를 모두 합쳐서 가져오기 */
select b.no, b.title, b.regdt, b.vwcnt, b.mno, m.no, m.name
from ex_board b, ex_memb m;

/* 4) 게시판의 mno와 회원 테이블의 no가 같은 데이터만 연결하여 가져오기 */
select b.no, b.title, b.regdt, b.vwcnt, m.no, m.name
from ex_board b join ex_memb m on b.mno=m.no;








