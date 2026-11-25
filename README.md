# 🚀 Hbs-eureka-server

> Сервис регистрации и обнаружения приложений Hotel Booking System

---

## 📌 Описание

Сервис запускает Eureka Server и хранит реестр зарегистрированных приложений.
Настроен одиночный экземпляр реестра, без регистрации самого себя как клиента.

---

## 📘 Документация по процессам

- ### [GitHub Flow](docs/github_flow/index.md)

---

## 🛠️ Стек технологий

- ☕ Java 21 (язык разработки)
- 🌱 Spring Boot 4.1.2 (основа приложения)
- 🔎 Spring Cloud 2025.1.4 и Eureka Server (реестр сервисов)
- 🐘 Gradle 9.5.1 с Kotlin DSL (сборка)
- 🐳 Docker и GitHub Actions (сборка образа и CI)

---

## 🚀 Локальный запуск

1. Убедиться, что установлена JDK 21 и доступен порт `8761`

   Сервис не требует PostgreSQL или других приложений для запуска.

2. Создать папку `config` в корне проекта и файл `config/application.yaml` с содержимым ниже
   ```yaml
   server:
     port: 8761
   ```

   Локальный файл переопределяет значения из `src/main/resources/application.yaml`
   через `spring.config.import: optional:file:./config/application.yaml`.
   Папка `config` исключена из Git.

   Если значения по умолчанию подходят, локальный файл можно не создавать.

3. Из корня проекта выполнить команду
   ```shell
   .\gradlew.bat bootRun
   ```

   Порт приложения по умолчанию: `8761`. Его можно изменить в локальном файле настроек.

---

## 📦 Сборка JAR и Docker-образа

```shell
.\gradlew.bat bootJar
docker build --tag hbs-eureka-server:local .
```

Исполняемый JAR находится в `build/libs/app.jar`. Dockerfile использует JRE 21
и запускает приложение от пользователя `10001:10001`.

---

## 🔗 Полезные ссылки

| Ссылка | Примечание |
|--------|------------|
| [Репозиторий](https://github.com/Dikov-Hotel-Booking-System/hbs-eureka-server) | Исходный код сервиса |
| [GitHub Actions](https://github.com/Dikov-Hotel-Booking-System/hbs-eureka-server/actions) | Запуски CI |
| [Eureka](http://localhost:8761/) | Открывать после локального запуска сервиса |

---

## 🧪 Тестирование сервиса

Тестовых зависимостей и тестовых классов в сервисе нет.
В общем CI задача `test` завершается с `NO-SOURCE`.

---
