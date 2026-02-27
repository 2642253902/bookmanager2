# 📚 IMAU 图书管理系统

> 一个基于 Spring Boot 3 + Sa-Token 的图书管理系统后端项目，提供用户登录认证、权限控制和图书管理等功能。

## 项目介绍

本项目是一个完整的图书管理系统后端服务，基于 Spring Boot 3 开发，集成了 Sa-Token 权限认证框架，实现了用户登录、角色权限管理、图书信息管理等核心功能。项目采用前后端分离架构，提供 RESTful API 接口供前端调用。

**参考视频教程：** [B站视频教程](https://www.bilibili.com/video/BV12N41117Sb/?spm_id_from=333.1387.upload.video_card.click)

## ✨ 技术栈

### 核心框架
- **Spring Boot** `3.5.3` - 基础框架
- **Java** `17` - 开发语言
- **Maven** - 项目构建管理

### 数据库相关
- **MySQL** `5.7+` - 关系型数据库
- **MyBatis-Plus** `3.5.12` - 增强版 ORM 框架
- **Spring JDBC** - 数据库连接

### 权限认证
- **Sa-Token** `1.44.0` - 轻量级权限认证框架
  - Session 会话管理
  - 权限认证
  - 角色验证

### 其他依赖
- **Lombok** `1.18.30` - 简化实体类编写
- **Hutool** `5.8.16` - Java 工具类库
- **Fastjson2** `2.0.56` - JSON 处理
- **Spring AOP** `3.5.0` - 面向切面编程

## 📁 项目结构

```
imau-bookmanager/
├── src/
│   ├── main/
│   │   ├── java/com/pan/
│   │   │   ├── ImauBookmanagerApplication.java    # 项目启动类
│   │   │   ├── annotation/                         # 自定义注解
│   │   │   │   └── NeeAuth.java                   # 权限认证注解
│   │   │   ├── config/                            # 配置类
│   │   │   │   └── NeeAuthConfig.java             # AOP 权限拦截配置
│   │   │   ├── controller/                        # 控制层
│   │   │   │   ├── BookController.java            # 图书管理接口
│   │   │   │   └── UserController.java            # 用户管理接口
│   │   │   ├── dao/                               # 数据访问层
│   │   │   │   ├── BookDao.java                   # 图书 DAO
│   │   │   │   ├── RecordDao.java                 # 记录 DAO
│   │   │   │   ├── RoleDao.java                   # 角色 DAO
│   │   │   │   └── UserDao.java                   # 用户 DAO
│   │   │   ├── pojo/                              # 实体类
│   │   │   │   ├── BookPojo.java                  # 图书实体
│   │   │   │   ├── RecordPojo.java                # 记录实体
│   │   │   │   ├── RolePojo.java                  # 角色实体
│   │   │   │   └── UserPojo.java                  # 用户实体
│   │   │   ├── service/                           # 业务逻辑层
│   │   │   │   ├── BookServiceImpl.java           # 图书业务实现
│   │   │   │   ├── RecordServiceImpl.java         # 记录业务实现
│   │   │   │   ├── RoleServiceImpl.java           # 角色业务实现
│   │   │   │   ├── StpInterfaceImpl.java          # Sa-Token 接口实现
│   │   │   │   └── UserServiceImpl.java           # 用户业务实现
│   │   │   └── uitils/                            # 工具类
│   │   │       └── Result.java                    # 统一返回结果工具类
│   │   └── resources/
│   │       ├── application.yml                    # 应用配置文件
│   │       └── templates/
│   │           └── index.html                     # 首页模板
│   └── test/                                      # 测试类
├── pom.xml                                        # Maven 配置文件
└── imau_learn.sql                                 # 数据库脚本（待补充）
```

## 🚀 核心功能

### 1. 用户认证与授权
- ✅ 用户登录/登出
- ✅ 基于 Sa-Token 的会话管理
- ✅ 自定义注解 `@NeeAuth` 实现权限控制
- ✅ AOP 切面实现权限拦截
- ✅ 角色权限验证（如：admin 角色）

### 2. 图书管理
- ✅ 图书添加
- ✅ 图书删除
- ✅ 图书信息包含：书名、ISBN、价格、作者

### 3. 权限控制机制
- **自定义注解**：通过 `@NeeAuth` 注解声明接口权限要求
- **AOP 拦截**：`NeeAuthConfig` 切面自动拦截并验证权限
- **支持功能**：
  - 登录状态检查
  - 角色权限验证
  - 统一权限拦截返回

## 🔧 快速开始

### 环境要求

- **JDK** `17+`
- **Maven** `3.6+`
- **MySQL** `5.7+`
- **IDE** IntelliJ IDEA / Eclipse（推荐 IDEA）

### 安装步骤

1. **克隆项目**
```bash
git clone <项目地址>
cd bookmanager2-main/imau-bookmanager
```

2. **创建数据库**
```sql
CREATE DATABASE imau_learn DEFAULT CHARACTER SET utf8mb4;
```

3. **配置数据库连接**

编辑 `src/main/resources/application.yml`：

```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/imau_learn
    username: root          # 修改为你的数据库用户名
    password: root          # 修改为你的数据库密码
    driver-class-name: com.mysql.cj.jdbc.Driver
```

4. **导入数据库表结构**

根据项目的 POJO 实体类创建对应的数据库表，或运行 SQL 脚本（如果提供）。

5. **编译运行**

```bash
# 使用 Maven 编译
mvn clean install

# 运行项目
mvn spring-boot:run
```

或在 IDE 中直接运行 `ImauBookmanagerApplication.java`

### 访问项目

- **后端服务地址**：http://localhost:8081
- **测试接口**：http://localhost:8081/Login

## 📡 API 接口文档

### 用户模块

#### 1. 用户登录
- **接口地址**：`POST /Login`
- **请求参数**：
  - `username`：用户名（String）
  - `password`：密码（String）
- **返回示例**：
```json
{
  "code": 200,
  "msg": "登录成功",
  "data": null
}
```

#### 2. 测试接口（需要 admin 权限）
- **接口地址**：`GET /Heollo`
- **权限要求**：需要登录 + admin 角色
- **返回**：`"hello"`

### 图书模块

#### 1. 添加图书
- **接口地址**：`POST /bookAdd`
- **请求参数**：
  - `bookName`：图书名称（String）
  - `bookIsbn`：ISBN 号（String）
  - `bookPrice`：价格（BigDecimal）
  - `bookWriter`：作者（String）
- **返回示例**：
```json
{
  "code": 200,
  "msg": "添加成功"
}
```

#### 2. 删除图书
- **接口地址**：`DELETE /bookDel/{id}`
- **路径参数**：
  - `bookId`：图书ID（String）
- **返回示例**：
```json
{
  "code": 200,
  "msg": "删除成功"
}
```

## ⚙️ 配置说明

### Sa-Token 配置

```yaml
sa-token:
  token-name: satoken              # Token 名称（同时也是 cookie 名称）
  timeout: 2592000                 # Token 有效期 30 天（单位：秒）
  active-timeout: -1               # Token 最低活跃频率（-1 表示不限制）
  is-concurrent: true              # 是否允许同一账号多地同时登录
  is-share: false                  # 多人登录同一账号时，是否共用一个 token
  token-style: uuid                # Token 风格
  is-log: true                     # 是否输出操作日志
```

### 数据库配置

```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/imau_learn
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
```

### 服务器配置

```yaml
server:
  port: 8081                       # 服务端口
```

## 🔐 权限注解使用示例

```java
@RestController
public class YourController {
    
    // 不需要任何权限
    @RequestMapping("/public")
    public String publicApi() {
        return "public";
    }
    
    // 只需要登录
    @NeeAuth(neeAuth = false)
    @RequestMapping("/login-only")
    public String loginOnly() {
        return "login only";
    }
    
    // 需要登录 + admin 角色
    @NeeAuth(neeAuth = true, needRole = {"admin"})
    @RequestMapping("/admin-only")
    public String adminOnly() {
        return "admin only";
    }
}
```

## 📊 数据库表结构

### book 表（图书信息）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| book_id | INT | 图书ID（主键，自增） |
| book_name | VARCHAR | 图书名称 |
| book_isbn | VARCHAR | ISBN 号 |
| book_price | DECIMAL | 价格 |
| book_writer | VARCHAR | 作者 |

### user 表（用户信息）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| uid | INT | 用户ID（主键） |
| username | VARCHAR | 用户名 |
| password | VARCHAR | 密码 |

### role 表（角色信息）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| role_id | INT | 角色ID（主键） |
| role_name | VARCHAR | 角色名称 |
| role_user_id | INT | 用户ID（外键） |

### record 表（借阅记录）
_根据实际需求设计_

## 🛠️ 常见问题

### 1. 启动时数据库连接失败
- 检查 MySQL 服务是否启动
- 确认数据库连接配置是否正确
- 检查数据库是否已创建

### 2. 权限验证不生效
- 确认切面配置类被 Spring 扫描到
- 检查 `@NeeAuth` 注解是否正确使用
- 查看控制台日志确认切面是否执行

### 3. 跨域问题
- 控制器已添加 `@CrossOrigin` 注解
- 如需自定义跨域配置，可在 config 包中添加 CORS 配置类

## 📝 开发计划

- [ ] 完善数据库 SQL 脚本
- [ ] 添加用户注册功能
- [ ] 实现图书查询和分页
- [ ] 添加借阅记录管理
- [ ] 完善 API 文档
- [ ] 添加单元测试
- [ ] 集成 Swagger/Knife4j API 文档
- [ ] 添加日志记录功能
- [ ] 实现数据导出功能
