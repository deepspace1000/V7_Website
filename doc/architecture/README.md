# V7 Website Architecture Documentation
Architecture documentation based on [arc42](https://www.innoq.com/en/blog/brief-introduction-to-arc42/)

## Introduction / Goals

The V7_Website is a website and an application with an internal space for the leader team to organise.

### Quality Goals

The main quality goals of this project include:

- Secure login for internal space
- The public part of the website must be informative, and appealing to visitors
- The application must be easy to use

## Constraints

Coding: There is only one Developer at the moment so to guarantee code quality this project will have to rely on tools for code quality check

## Context and Scope

### System Context


## Solution Strategy

The V7 web team develops this application and uses an open source technology stack, which will consist of a conventional three tier architecture 
with frontend (a single-page application), backend and relational database.

### ER Diagram

This maybe extended in the future with new features

``` mermaid
erDiagram
    user {
        UUID id
        string firstname
        string lastname
        string phone
        string e-mail
        string password
        string role
    }
    user }|--|{ user_ressort: contains
    user_ressort {
        UUID user_id
        UUID ressort_id
    }
    ressort }|--|{ user_ressort: contains
    ressort {
        UUID id
        string name 
        string description
    }
  
```

## Building Block View

## Runtime View

### Login and Authorization

```mermaid
sequenceDiagram
    participant fe as Frontend
    participant be as Backend
    participant db as Database
    
    activate fe
    fe ->>be: Send Login Credential <br> E-Mail and password
    activate be
    be ->> db: Fetch user for E-Mail
    activate db
    db -->> be: Returns User for E-Mail <br> Returns userNoFound
    deactivate db
    be ->> be: Validate Password
    alt Authenticaion successful 
        be -->> fe: JWT Access token
    else UserCredentials do not match
        be -->> fe: HTTP 403
    end
    deactivate be
    deactivate fe
```




## Deployment View

## Crosscutting Concepts

## Architectural Decisions

See [ADR Folder](../adr)

## Quality Requirements

See [Quality Goals](#quality-goals) for some major goals
driving the architecture. This section may describe quality scenarios
in the future.

## Risk & Technical Debt



## Glossary

| Term | Description                    |
|------|--------------------------------|
| V7   | V7 is a youth project in Bauma |

