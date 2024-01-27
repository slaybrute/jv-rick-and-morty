# Rick and Morty API

## Overview

This repository contains a RESTful API for accessing information about characters from the popular animated series Rick & Morty. The API provides three main endpoints: one for generating random character details, another for searching characters by name, and the third for initializing data during application startup.

## Business Requirements

### 1. Random Character Generation

- **Endpoint:** `GET /api/characters/random`
- **Example Response:**

```json
{
  "id": 1,
  "externalId": "1",
  "name": "Rick Sanchez",
  "status": "Alive",
  "gender": "Male"
}
```

### 2. Character Search

- **Endpoint:** `GET /api/characters/search?name={searchString}`
- **Response:**
  - Returns a list of characters with names containing the provided search string.

This endpoint allows users to search for characters based on a provided name substring. The response provides a list of characters matching the search criteria, including their respective details.

### 3. Character by ID

- **Endpoint:** `GET /api/characters/{id}`
- **Response:**
    - Returns details of the character with the specified ID.

This endpoint allows users to retrieve specific details of a character by providing their unique identifier. The response includes information such as the character's name, status, gender, etc.

### 4. Data Initialization

- During application startup, data is fetched from a third-party service and stored in the internal MySQL database.

### 5. Data not Initialization

- You could send any request for rick and morty api that does not involve saving the data to the database. Instead, it converts the fetched data into objects for immediate use.

## Tech Requirements

- **Database:**
  - Utilizes MySQL for the main application.
  - H2 database is configured for testing purposes (`src/test/resources/application.properties`).

- **API Documentation:**
  - Swagger is integrated to document API requests and responses.

## Usage

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/slaybrute/rick-morty-api.git
