# School Library Basic Simulation on Spring-boot
# Omer CEVIK

Some Important Notes:
-----------------------

1. Program is developed in Intellij IDEA IDE on Ubuntu 20.04.1 LTS operating system.
2. Java 12 is used.
3. PostgreSQL is used for database.
4. Tomcat Server 9 is used for server in localhost:8080/.
5. Login security is provided.
6. Program starts with inserting some books and one user to database.
    User's username/email = "user", password = "user"
7. Using Swagger, it is possible to create requests.
8. After program run in browser "localhost:8080/swagger-ui.html" is provided to create requests.
9. For security, before making any request you have to "login" to account. Otherwise it is forbidden.
10. When you logged in successfully, it will return jwt token which starts "Bearer ".
    Taking and copying the token with "Bearer " to authorize the account and pasting to "Authorize".
    Then all basic requests are ready to use.
11. You can logout using "Authorize" button.
12. You can insert books, create profiles, show books, delete profile and book.
13. After execution it drops the tables to refresh tables ("schema-postgres.sql").
