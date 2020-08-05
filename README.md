# mtespec-clocking-api

# Documentação da API
Esta API foi construída para atividade de diagnótico de conhecimentos em spring boot.

## Response Codes 
### Response Codes
```
200: Success
400: Bad request
404: Not found
```
### Example Error Message
```json
http code 500
{
    "code": 500,
    "message": "internal server error"
}
```

**Request:**
```json
POST /login HTTP/1.1
Accept: application/json
Content-Type: application/json
Content-Length: xy
/api/users/
{
	"name": "nome",
	"cpf": "1234567899",
	"email": "email@outlook.com"
}
```
**Successful Response:**
```json
HTTP/1.1 200 OK
Server: My RESTful API
Content-Type: application/json
Content-Length: xy

{
	"name": "nome",
	"cpf": "1234567899",
	"email": "email@outlook.com"
}
```
**Failed Response:**
```json
HTTP/1.1 401 Unauthorized
Server: My RESTful API
Content-Type: application/json
Content-Length: xy

{
    "code": 500,
    "message": "internal server error"
}
``` 