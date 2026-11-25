# hbs-eureka-server

Реестр сервисов Hotel Booking System.

Проект сгенерирован через [Spring Initializr](https://start.spring.io): Java 21,
Spring Boot 4.1.2, Spring Cloud 2025.1.4, Gradle Kotlin DSL. Group: `ru.mephi`,
пакет: `ru.mephi.hbs.discovery`.

Зависимость: Eureka Server. Тестовые зависимости и шаблонный `contextLoads`
удалены: приложение только включает стандартный сервер Eureka.
Сервер включён через `@EnableEurekaServer` и настроен для одиночного запуска.

```powershell
.\gradlew.bat build
.\gradlew.bat bootRun
```

Интерфейс Eureka: <http://localhost:8761/>. Запускайте реестр первым.

## Docker

Исполняемый JAR всегда называется `build/libs/app.jar`; обычный библиотечный
JAR не собирается. Сначала соберите JAR, затем образ:

```powershell
.\gradlew.bat bootJar
docker build --tag hbs-eureka-server:local .
```

Dockerfile использует JRE 21 и запускает приложение от UID/GID `10001:10001`.
В образ копируется уже собранный JAR.

## GitHub Actions

Workflow [`.github/workflows/ci.yml`](.github/workflows/ci.yml) запускается
при push в `master` и `feature/**`, для PR в `master`
и вручную через `workflow_dispatch`. Содержимое workflow одинаково
во всех четырёх репозиториях.

Рабочий поток: `feature/<name>` → PR → `master`.
Проверка `Branch policy` отклоняет PR из других исходных веток.
Правила защиты для GitHub и порядок первоначальной настройки описаны
в [GitHub Flow](docs/github_flow/index.md).

1. `build` выполняет `test bootJar`: собирает JAR; задача тестирования получает `NO-SOURCE`.
2. `docker` получает тот же JAR через artifact и собирает образ с тегом SHA коммита.

Готовый JAR сохраняется в artifacts на 7 дней. Образ проверяется сборкой,
без публикации в registry. Деплоя и Kubernetes-манифестов нет.
