# Community - Secure Member System
> **Spring Framework & MyBatis 기반의 멤버 관리 시큐어 터미널 프로젝트**

이 프로젝트는 **T1 Esports**의 브랜딩 가이드라인(Red, Black, Gold)을 디자인 컨셉으로 채택하여, Spring MVC 환경에서 MyBatis를 활용한 효율적인 회원 관리 및 권한 제어 시스템을 구현했습니다.

---

## Tech Stack
- **Framework:** Spring Framework (Legacy)
- **Language:** Java
- **Database:** Oracle DB (with MyBatis ORM)
- **Frontend:** JSP, Bootstrap 5, Custom CSS (T1 Dark Theme)
- **Library:** Lombok, Slf4j, Spring Security (Auth Logic)

---

## 주요 기능 (Key Features)

### 1. 사용자 관리 (Member Management)
- **회원가입:** 필요한 정보를 입력받고 DB에 저장하는 회원 가입 기능.
- **회원리스트:** 가입된 사용자의 리스트를 출력하는 기능(삭제된 enable ='0' 인 회원)은 보이지 않도록 구현.
- **정보 수정:** 개인 정보 업데이트 및 회원 탈퇴(Session Invalidate), 권한 설정 처리.

### 2. 권한 제어 (Authorization)
- **다중 권한 시스템:** `authList`를 통해 사용자별로 여러 개의 권한(User, Member, Admin)을 부여하고 관리.

### 3. UI/UX 디자인
- **T1 브랜딩 테마:** `#E2012D`(Red), `#0F0F0F`(Black), `#C69C6D`(Gold) 컬러칩을 활용한 다크 모드 인터페이스.

---

## 📂 Project Structure
```text
src/main/java
 └── com.community
      ├── controller   # 사용자 요청 처리 (UsersController, MemberController)
      ├── domain       # 데이터 객체 (Users, AuthVO)
      ├── mapper       # MyBatis 인터페이스 (XML 매핑)
      └── service      # 비즈니스 로직 처리
src/main/webapp
 └── WEB-INF/views     # T1 테마 기반 JSP 페이지 아카이브
