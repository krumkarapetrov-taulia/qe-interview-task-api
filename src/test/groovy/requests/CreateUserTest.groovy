package com.example

import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.jupiter.api.Test

import static io.restassured.RestAssured.given
import static org.hamcrest.Matchers.equalTo
import resources.HTTPClient

class CreateUserTest {

    // @Test
    void createUser() {     

        def requestBody = [
            name   : "John Doe",
            username: "johndoe",
            email  : "johndoe@example.com",
            address: [
                street : "Kulas Light",
                suite  : "Apt. 556",
                city   : "Gwenborough",
                zipcode: "92998-3874",
                geo    : [
                    lat: "-37.3159",
                    lng: "81.1496"
                ]
            ],
            phone  : "1-770-736-8031 x56442",
            website: "hildegard.org",
            company: [
                name        : "Romaguera-Crona",
                catchPhrase : "Multi-layered client-server neural-net",
                bs          : "harness real-time e-markets"
            ]
        ]

        given().
            contentType(ContentType.JSON).
            body(requestBody).
        when().
            post("/users").
        then().
            statusCode(201).
            body("name", equalTo("John Doe")).
            body("username", equalTo("johndoe")).
            body("email", equalTo("johndoe@example.com"))
    }
}
