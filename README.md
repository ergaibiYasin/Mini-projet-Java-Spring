Dreamcase RESTful API
=====================

This is a RESTful API for managing cases for Dreamcase. The API is built using Spring Boot, with a H2 in-memory database for testing purposes.

Getting Started
---------------

To run the API locally, follow these steps:

1.  Clone the repository.
2.  Open the project in your preferred IDE.
3.  Build the project using Maven.
4.  Run the `DreamcaseApplication` class to start the server.
5.  Access the API at `http://localhost:8080/api/cases`.

Endpoints
---------

### `GET /api/cases/{id}`

Returns the case with the specified ID.

### `POST /api/cases`

Creates a new case.

### `PUT /api/cases/{id}`

Updates the case with the specified ID.

### `DELETE /api/cases/{id}`

Deletes the case with the specified ID.

Technologies Used
-----------------

-   Spring Boot
-   Spring Data JPA
-   H2 in-memory database
-   Maven

Data structure
--------------

| Field name | Type | Description |
| --- | --- | --- |
| caseId | BIGINT (PK) | Id of the case |
| creationDate | DATETIME | Creation date of the case |
| lastUpdateDate | DATETIME | Last modification date of the case |
| title | VARCHAR(255) | Title of the case |
| description | VARCHAR(2056) | Description of the case |