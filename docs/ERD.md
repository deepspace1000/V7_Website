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