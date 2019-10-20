MyBatis Plus实现的OAuth2服务端
--------------

1. 集成代码生成器部分
2. 集成Spring Security OAuth2 Server端
3. 简易实现客户端和用户Api


### 获取token
通过以下请求可以获取access token
```
curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Authorization: Basic Y2xpZW50YXBwOjEyMw==' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -H 'Host: localhost:8080' \
  -H 'cache-control: no-cache' \
  -d 'grant_type=password&username=john&password=123'
```
响应

```json
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzE2MTgxMTYsInVzZXJfbmFtZSI6ImpvaG4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiNTJhMDE3NTktY2Y0Ni00MjE5LTk4YTUtZmJkYzRhZTRkYmY2IiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZCJdfQ.Hqtei6GiUKDu9_h3St4juNJciTBQNBs-PjekLAoBHgc",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJqb2huIiwic2NvcGUiOlsicmVhZCJdLCJhdGkiOiI1MmEwMTc1OS1jZjQ2LTQyMTktOThhNS1mYmRjNGFlNGRiZjYiLCJleHAiOjE1NzQxNjY5MTYsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiJlNzc1ZGIxYi1jYzhiLTRlOGUtYWJhMS0yOTQ2ODIwYTgzYmMiLCJjbGllbnRfaWQiOiJjbGllbnRhcHAifQ.35H_csaDnZcDuW0bPE7tdSRVsGkaruasDNm4mNh29vI",
    "expires_in": 43198,
    "scope": "read",
    "jti": "52a01759-cf46-4219-98a5-fbdc4ae4dbf6"
}
```


### 刷新token
```
curl -X POST \
  'http://localhost:8080/oauth/token?grant_type=refresh_token&scope=read&refresh_token=a9726341-c5d5-496d-9a78-d9f8e6c8c6e7' \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Authorization: Basic Y2xpZW50YXBwOjEyMw==' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 0' \
  -H 'Host: localhost:8080' \
  -H 'cache-control: no-cache'
```


```json
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzE2MTg5OTksInVzZXJfbmFtZSI6ImpvaG4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiNzI4YWVlZDktNzgzOC00NzlhLThkOGQtMmM3OGU5NjE0YWFkIiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZCJdfQ.H_Jf0WokkxStm9UQvqxZ-9tNjx4otDEG8WUQ3zJPuPE",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJqb2huIiwic2NvcGUiOlsicmVhZCJdLCJhdGkiOiI3MjhhZWVkOS03ODM4LTQ3OWEtOGQ4ZC0yYzc4ZTk2MTRhYWQiLCJleHAiOjE1NzQxNjY5MTYsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiJlNzc1ZGIxYi1jYzhiLTRlOGUtYWJhMS0yOTQ2ODIwYTgzYmMiLCJjbGllbnRfaWQiOiJjbGllbnRhcHAifQ.d1h2hTLISMI6AoZnnTKS946YYDNW1QzrlFhjjgfS-8I",
    "expires_in": 43199,
    "scope": "read",
    "jti": "728aeed9-7838-479a-8d8d-2c78e9614aad"
}
```

### 请求受保护的资源
```
curl -X GET \
  http://localhost:8080/auth/me \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzE2MTgxMTYsInVzZXJfbmFtZSI6ImpvaG4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiNTJhMDE3NTktY2Y0Ni00MjE5LTk4YTUtZmJkYzRhZTRkYmY2IiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZCJdfQ.Hqtei6GiUKDu9_h3St4juNJciTBQNBs-PjekLAoBHgc' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Host: localhost:8080' \
  -H 'cache-control: no-cache'
```
响应
```json
{
    "authorities": [
        {
            "authority": "ROLE_USER"
        }
    ],
    "details": {
        "remoteAddress": "0:0:0:0:0:0:0:1",
        "sessionId": null,
        "tokenValue": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzE2MTgxMTYsInVzZXJfbmFtZSI6ImpvaG4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiNTJhMDE3NTktY2Y0Ni00MjE5LTk4YTUtZmJkYzRhZTRkYmY2IiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZCJdfQ.Hqtei6GiUKDu9_h3St4juNJciTBQNBs-PjekLAoBHgc",
        "tokenType": "Bearer",
        "decodedDetails": null
    },
    "authenticated": true,
    "userAuthentication": {
        "authorities": [
            {
                "authority": "ROLE_USER"
            }
        ],
        "details": null,
        "authenticated": true,
        "principal": "john",
        "credentials": "N/A",
        "name": "john"
    },
    "oauth2Request": {
        "clientId": "clientapp",
        "scope": [
            "read"
        ],
        "requestParameters": {
            "client_id": "clientapp"
        },
        "resourceIds": [],
        "authorities": [],
        "approved": true,
        "refresh": false,
        "redirectUri": null,
        "responseTypes": [],
        "extensions": {},
        "grantType": null,
        "refreshTokenRequest": null
    },
    "clientOnly": false,
    "principal": "john",
    "credentials": "",
    "name": "john"
}
```


### TODO
[x] 注册client
[x] 注册用户
[x] 资源授权
