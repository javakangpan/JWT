1. JSON Web Token是什么
JSON Web Token (JWT)是一个开放标准(RFC 7519)，它定义了一种紧凑的、
自包含的方式，用于作为JSON对象在各方之间安全地传输信息。该信息可以被验证和信任，因为它是数字签名的。
2.为什么使用JWT？
随着技术的发展，分布式web应用的普及，通过session管理用户登录状态成本越来越高，
因此慢慢发展成为token的方式做登录身份校验，然后通过token去取redis中的缓存的用户信息，
随着之后jwt的出现，校验方式更加简单便捷化，无需通过redis缓存，而是直接根据token取出保存的用户信息，
以及对token可用性校验，单点登录更为简单。

3.如何使用JWT？
在身份鉴定的实现中，传统的方法是在服务端存储一个 session，给客户端返回一个 cookie，而使用JWT之后，当用户使用它的认证信息登录系统之后，
会返回给用户一个JWT， 用户只需要本地保存该 token（通常使用localStorage，也可以使用cookie）即可。

当用户希望访问一个受保护的路由或者资源的时候，通常应该在 Authorization 头部使用 Bearer 模式添加JWT。
因为用户的状态在服务端内容中是不存储的，所以这是一种无状态的认证机制。服务端的保护路由将会检查请求头 Authorization 中的JWT信息，
如果合法，则允许用户的行为。由于JWT是 自包含的，因此，减少了需要查询数据库的需要。
JWT的这些特征使得我们可以完全依赖无状态的特性提供数据API服务。因为JWT并不使用Cookie的，
所以你可以在任何域名提供你的API服务而不需要担心跨域资源共享问题（CORS


4.JWT的结构
JWT是由三段信息构成的，将这三段信息文本用.连接一起就构成了JWT字符串。
就像这样:
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.
TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ

JWT包含了三部分：
Header 头部(标题包含了令牌的元数据，并且包含签名和/或加密算法的类型)
Payload 负载
Signature 签名/签证

token 存储到cookie localstorage

post--> http://localhost:8080/login

{
  "user": {
    "username": "kangpan",
    "password": "123456",
    "id": "1"
  },
  "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.
  eyJhdWQiOiIxIn0.qfd0G-elhE1aGr15LrnYlIZ_3UToaOM5HeMcXrmDGBM"
}

get--> http://localhost:8080/getMessage

head 添加 token:eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.
eyJhdWQiOiIxIn0.qfd0G-elhE1aGr15LrnYlIZ_3UToaOM5HeMcXrmDGBM


官方:https://jwt.io/



