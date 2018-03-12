## ver 73
- 트랜잭션을 적용하여 게시글 등록과 첨부파일 등록을 한 묶음의 작업으로 다뤄라!
- 학습목표
  - 트랜잭션의 동작 원리를 이해한다.
  - 애노테이션으로 트랜잭션을 다룰 수 있다.
  - XML 설정 파일을 이용하여 트랜잭션을 다룰 수 있다.

## 기존의 문제점
- 게시글을 등록할 때 첨부파일 데이터를 insert 하는 중에 오류가 발생하더라도 기존에 insert한 게시글을 그대로 유지된다.

## 바라는 바
- 게시글 데이터 입력과 첨부파일 데이터 입력을 한 작업으로 묶어 다루고 싶다.
- 그래서 첨부파일 데이터 입력 중에 오류가 발생하면, 그 전에 게시글 입력 작업을 취소하고 싶다.

## 해결책
- 트랜잭션을 이용하여 게시글 데이터 입려과 첨부파일 데이터 입력 작업을 한 개의 작업으로 묶는다.   

## 공통 작업 목록 

### 스프링 설정 파일에 트랜잭션 관리자를 추가한다.
- dispatch-servlet.xml 파일에 등록한다.
``` 
<bean id="transactionManager"     
      class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
  <property name="dataSource" ref="dataSource"/>
</bean>
```

## XML 설정으로 트랜잭션 다루기

### 서비스 객체의 메서드가 호출될 때 트랜잭션 작업을 도와줄 advice 객체 등록
- 서비스 메서드가 호출되기 전(before)/후(afterReturning)/예외(afterThrowing) 일 때 작업을 수행할 advice를 등록한다.
- 스프링에서 제공하는 객체를 사용한다.
- dispatch-servlet.xml 파일에 등록한다.
  - 설정하기 전에 tx 네임스페이스를 추가하라!
```
<tx:advice id="txAdvice">
    <tx:attributes>
        <tx:method name="list*" read-only="true"/>
        <tx:method name="*"/>
    </tx:attributes>
</tx:advice>
``` 


### 트랜잭션 관련 Advice를 꼽을 위치(pointcut)를 선언한다.
- dispatch-servlet.xml 파일에 등록한다.
  - 설정하기 전에 aop 네임스페이스를 추가하라!
```
<aop:config>
   <aop:pointcut id="serviceOperation" 
        expression="execution(* java100.app.service..*ServiceImpl.*(..))"/>
   <aop:advisor advice-ref="txAdvice" pointcut-ref="serviceOperation"/>
</aop:config>
```

### 의존 라이브러리 가져오기
- aspectjweaver 라이브러리를 추가한다.


## 애노테이션으로 트랜잭션 다루기

### 스프링 설정 파일에 @Transactional을 처리할 객체를 등록한다.
```
<tx:annotation-driven transaction-manager="transactionManager"/>
```

### 트랜잭션을 적용하고 싶은 클래스나 메서드에 @Transactional 애노테이션을 붙인다.

## 트랜잭션 전파(propagation) 정책 

| 정책\호출자 트랜잭션 | tx1 |  -  |
|----------------------|-----|-----|
| REQUIRED             | tx1 | new |
| REQURIES_NEW         | new | new |
| SUPPORTS             | tx1 |  -  |
| NOT_SUPPORTED        |  -  |  -  |
| MANDATORY            | tx1 | 예외|
| NEVER                | 예외|  -  |










