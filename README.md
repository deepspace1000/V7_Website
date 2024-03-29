# V7_Website

[![Check & Release](https://github.com/deepspace1000/V7_Webseite/actions/workflows/check-and-release.yml/badge.svg)](https://github.com/deepspace1000/V7_Webseite/actions/workflows/check-and-release.yml)
![Uptime Robot ratio (30 days)](https://img.shields.io/uptimerobot/ratio/30/m796425090-f23a308a286302410fae8a8c)


Backend:
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=v7_website_backend&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=v7_website_backend)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=v7_website_backend&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=v7_website_backend)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=v7_website_backend&metric=bugs)](https://sonarcloud.io/summary/new_code?id=v7_website_backend)


Frontend:
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=v7_website_frontend&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=v7_website_frontend)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=v7_website_frontend&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=v7_website_frontend)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=v7_website_frontend&metric=bugs)](https://sonarcloud.io/summary/new_code?id=v7_website_frontend)

This Application is for the [Jugendarbeit Bauma](https://v7-bauma.ch) project called V7.

- [Documentation](./doc/architecture/README.md)
- [Jira](https://v7bauma.atlassian.net/jira/software/projects/V7WE/boards/1/backlog)

## Deployment

| Branch | Domain              | Server     | Repo                                                   |
|--------|---------------------|------------|--------------------------------------------------------|
| Master | https://v7-bauma.ch | deepspace8 | https://github.com/deepspace1000/V7_Website-Deployment |

## Development

### Prerequisites
* [Docker](https://docs.docker.com/desktop/install/mac-install/)
* [SDKMAN!](https://sdkman.io/install)
* [nvm](https://github.com/nvm-sh/nvm)

### Setup

```shell
nvm use
sdk env install
corepack enable
corepack prepare yarn@stable --activate
```

#### Backend

Start the dev environment:

```shell
(cd backend && docker compose up -d)
```

Start [V7-Backend](./backend/src/main/kotlin/ch/v7/backend/BackendApplication.kt)
with the [**dev** profile](./.run/V7-Backend%20dev.run.xml).

#### Frontend

```shell
cd frontend
yarn
```

In IntelliJ, install the prettier plugin and select the installed prettier dependency to format js, jsx, ts and tsx files.

Start the dev environment:

```shell
# if necessary
cd frontend 
yarn dev
```

Format:

```shell
yarn format
```

Lint:

```shell
yarn lint
```

### Jooq

The backend uses jooq to generate kotlin database classes.
To make changes to the database schema add an entry to [changes](./backend/src/main/resources/db/changelog/changes) and restart the backend to apply the changes to the databse.
To generate the jooq classes run `(cd backend && ./gradlew generateJooq)`.

### Open API

The backend exposes an [OpenAPI definition](http://localhost:8080/openapi/v3/api-docs) and the according [Swagger UI](http://localhost:3000/api/swagger-ui/index.html) for its API.

Generate API client for the frontend:
```shell
# if necessary
cd frontend
yarn generate-api-client
```



