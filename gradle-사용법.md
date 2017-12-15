# Gradle 사용법

## 자바 프로젝트 생성
Gradle 빌드 도구를 이용하여 자바 프로젝트를 만들어보자!

### 1) 프로젝트 폴더 생성
자바 프로젝트 폴더를 만들기 위해 빈 폴더를 생성한다.
```
c:\workspace> md test
```

### 2) Maven 프로젝트 구조로 만든다.
Maven 프로젝트를 위한 기본 파일들과 디렉토리를 자동으로 생성한다.
```
c:\workspace> cd test
c:\workspace\test> gradle init --type java-application
```
- .gradle/ : gradle 관련 설정 파일이 들어 있는 폴더
- gradle/ : gradle wrapper 관련 파일
- src/main/java : 자바 기본 소스 폴더
- src/test/java : 자바 테스트 소스 폴더
- 기타 gradle 설명 파일들

### 3) 프로젝트를 빌드한다.
프로젝트의 소스를 컴파일하고 배포 파일을 생성한다. 
```
c:\workspace\test> gradle build
```
- build : 컴파일된 .class 파일과 배포 파일(.jar) 등이 생성된다.


### 4) 프로젝트 실행
build.gradle 파일에서 mainClassName에 지정된 클래스를 실행한다.
```
윈도우에서만 가능
c:\workspace\test> gradle run
```

리눅스에 설치된 gradle은 run task가 없다. 다음과 같이 build.gradle 파일에 task를 정의해야 한다.
```
//build.gradle 파일에 선언된 mainClassName 속성을 제거한다.
//mainClassName = 'Hello'

//build.gradle 파일에 다음 코드 추가
task run(type:JavaExec) {
   main = 'Hello'
   classpath = sourceSets.main.runtimeClasspath
}

```

## Gradle 기본 명령어

### clean
프로젝트 폴더에서 build 폴더를 제거한다.
```
c:\workspace\test> gradle clean
```

### compileJava
자바 소스(src/main/java)를 컴파일하는 명령어이다. 소스 폴더의 파일을 컴파일하여 build/classes/java/main 폴더에 둔다.
```
c:\workspace\test> gradle compileJava
```

### processResources
src/main/resources 폴더의 모든 파일을 build/resources/main/ 폴더에 복사한다.
```
c:\workspace\test> gradle processResources
```

### classes
포함작업
- compileJava
- processResources
```
c:\workspace\test> gradle classes
```


### compileTestJava
포함작업
- classes

자바 테스트 소스(src/test/java)를 컴파일하는 명령어이다. 소스 폴더의 파일을 컴파일하여 build/classes/java/test 폴더에 둔다.
```
c:\workspace\test> gradle compileTestJava
```

### processTestResources
src/test/resources 폴더의 모든 파일을 build/resources/test/ 폴더에 복사한다.
```
c:\workspace\test> gradle processTestResources
```

### jar
포함작업
- classes

.jar 배포 파일을 생성하여 build/libs 폴더에 둔다.
```
c:\workspace\test> gradle jar
```

### build
모든 작업을 수행한다. 따라서 마지막으로 테스트 및 배포 파일을 생성할 때 실행한다.
```
c:\workspace\test> gradle build
```

### tasks
Gradle 명령으로 수행할 수 있는 작업 정보를 알아낸다.
```
일부 작업 목록 출력
c:\workspace\test> gradle tasks  

전체 작업 목록 출력
c:\workspace\test> gradle tasks --all
```

## Gradle 플러그인
build.gradle 파일에 플러그인을 등록해야만 그 플러그인의 task를 사용할 수 있다.

### 플러그인 등록 
```
//build.gradle
apply plugin: '플러그인명'
```

### Gradle 플러그인에서 제공하는 작업 목록 확인
```
c:\workspace\test> gradle tasks --all
```

## wrapper
시나리오: 어떤 개발자가 프로젝트를 만든 후 다른 개발자에게 전달하려 한다. 그런데 다른 개발자의 PC에 gradle이 깔려있지 않다. 그렇다고 그 개발자에게 gradle 설치라는 번거로움을 주기 싫다. 단지 실행하면 자동으로 gradle을 설치하게 하고 싶다. 또는 자신이 사용한 gradle 버전을 다운로드 받게 하고 싶다.

이런 경우를 위해 사용하는 것이 wrapper 이다. gradle에서는 가능한 wrapper 방식을 사용할 것을 권장하고 있다.

### wrapper 관련 파일 생성
```
c:\workspace\test> gradle wrapper --gradle-version [버전]

예)
c:\workspace\test> gradle wrapper --gradle-version 4.2
```

### wrapper 파일 사용
gradlew를 실행하면 명시된 버전의 gradle을 자동으로 다운로드 한다. 그런 후 gradle 명령을 수행한다.
```
c:\workspace\test> gradlew [작업명]
```
 
## Gradle 설정

### **compileJava** Task 설정
자바 소스를 컴파일할 때 참고할 정보를 설정한다.
```
compileJava {
    options.encoding = 'UTF-8'
}
```

## Eclipse 프로젝트 만들기
1) 프로젝트 기본 폴더 및 Gradle 설정 파일 생성
- "gradle init --type java-application"
 
2) 이클립스 관련 설정 파일 만들기
- build.gradle 파일에 설정 정보를 추가한다.
- 직접 코드를 작성하지 말고, 기존 프로젝트에서 사용하던 설정을 복사해서 넣어라.
- "gradlew cleanEclipse"
- "gradlew eclipse"

3) 프로젝트를 이클립스로 가져오기
- File > import... 실행
    