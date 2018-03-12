# mybatis 사용법 익히기
- mybatis는 DBMS와 연동하여 데이터를 등록,조회,수정,삭제하는 작업을 도와준다.
- 이런 라이브러리를 "persistence API" 또는 "persistence framework"이라 부른다.
- JDBC 프로그래밍을 작성할 때 중복되는 코드를 별도의 라이브러리로 만든 것이다.
- 개발자가 직접 JDBC API를 사용하는 대신에 mybatis를 사용하여 데이터의 등록,조회,수정,삭제를 처리한다.
- 물론 mybatis는 내부적으로 JDBC API를 사용하여 처리한다.
- 따라서 mybatis를 사용하려면 여전히 JDBC Driver가 있어야 한다.

## 주요 목표
- 반복적인 JDBC 코딩을 대신 처리해주어 간결한 코드 작성을 도와준다!
- 자바 소스 코드에서 SQL문을 분리하여 코드의 유지보수를 쉽게 하도록 도와준다!

## step1
- mybatis 적용 전
- 직접 JDBC API를 사용하여 데이터 처리

## step2
- mybatis 라이브러리 준비 
- mybatis-config.xml 설정파일 준비
- SQL Mapper 파일 준비
- SqlSession 객체 준비 

## step3
- mybatis를 사용하여 select를 실행한다.

## step4
- 타입에 별명을 부여하여 SQL Mapper 파일(SQL문이 들어있는 XML 파일)을 간단하게 만들자.
- Mybatis에서 제공하는 별명 사용하기.  
- DBMS 연결 정보를 분리하여 .properties 파일에 둔다.

## step5
- parameterType과 resultType에 사용자가 만든 클래스를 사용하기
- 사용자가 만든 클래스에 별명을 부여한 후 SQL Mapper에서 사용하라!

## step6
- 컬럼과 프로퍼티의 이름을 매핑하기

## step7
- 중복으로 사용되는 SQL 문이 있다면 별도의 태그로 분리해 정의한다.
- 그리고 그 태그를 SQL문에 포함시킨다.

## step8
- Mybatis 조건문 및 반복문 사용하여 dynamic sql을 만들기 
- ${변수명}과 #{변수명}의 차이 확인

## step9
- 데이터 처리 코드를 DAO 클래스로 분리한다.

## step10
- Spring IoC 컨테이너 적용
  - 스프링 IoC 컨테이너 라이브러리 가져오기
  - mvnrepository.com에서 spring-context 검색
  - build.gradle 파일에 라이브러리 정보 등록
  - "gradle eclipse" 실행하여 라이브러리 다운받고, 이클립스 설정 파일 갱신한다.
  - 이클립스 프로젝트를 "refresh"한다.
- SqlSessionFactoryBean 클래스를 스프링의 FactoryBean 규칙에 맞춰 작성한다.
- 스프링 IoC 컨테이너의 설정 파일을 준비한다.
  - BoardDao와 SqlSessionFactory를 스프링 IoC 컨테이너에서 관리한다.

## step11
- 우리가 만든 SqlSessionFactoryBean 대신에 mybatis가 제공해주는 
  SqlSessionFactoryBean을 사용하기
  - mybatis-spring 라이브러리를 가져온다.
- 스프링 IoC 컨테이너의 설정 파일에서 SqlSessionFactoryBean 클래스를 
  이 라이브러리에 있는 클래스로 교체하라!
- 스프링에서 DataSource를 준비한다.
  - apache commons dbcp2 라이브러리를 가져온다.
  - spring-jdbc 라이브러리를 가져온다.
  - 스프링 IoC 컨테이너 설정 파일에서 DataSource 객체를 준비한다.
  
## step12
- DAO 객체를 자동생성하라!
- DAO 객체를 자동 생성해주는 MapperScannerConfigurer 객체를 스프링 설정 파일에 등록한다.  
- BoardDao를 인터페이스로 만든다.
- SQL 맵퍼 파일의 네임스페이스는 패키지명과 + 인터페이스명 과 같게 하라! 










