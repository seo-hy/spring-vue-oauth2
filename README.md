# Oauth2
### Flow
* 로그인
    * 기본로그인
    * 소셜로그인 (구글로그인, 네이버로그인, 카카오로그인)
* 권한
    * USER
    * ADMIN : 사용자 전체 목록 조회 및 삭제 가능


## Server
### Oauth2
- [x] Spring Security, OAuth2 기본 설정 및 접근권한 설정 (권한 : USER, ADMIN)
- [x] 로그인 토큰 발급 및 리프레시 토큰 추가
- [x] 구글 로그인 추가
- [ ] 네이버 로그인 추가
- [x] 카카오 로그인 추가

### Swagger
- [x] Authorization header 추가
- [ ] 불필요 parameter(Principal, ) 제외
- [ ] oauth swagger 추가

### others
- [ ] form validation 추가

## Client
- [ ] 네비게이션 가드 설정
- [ ] vuex 토큰 관리 
