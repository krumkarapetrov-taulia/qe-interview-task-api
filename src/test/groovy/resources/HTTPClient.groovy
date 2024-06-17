package resources

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.response.Response


class HTTPClient {

  final static baseURI = 'https://jsonplaceholder.typicode.com'

  static {
    RestAssured.baseURI = baseURI
  }

  static Response get(String resourceURL, String body) {
    return RestAssured
    .given()
    .body(body)
    .log()
    .all()
    .contentType(ContentType.JSON)
    .when()
    .get(resourceURL)
  }

  //Implement any requests that you might need (POST, GET, GET by id etc.)

  static Response post(String resourceURL, String body) {
    return RestAssured
    .given()
    .body(body)
    .log()
    .all()
    .contentType(ContentType.JSON)
    .when()
    .post(resourceURL)
  }

  static Response put(String resourceURL, String body) {
    return RestAssured
    .given()
    .body(body)
    .log()
    .all()
    .contentType(ContentType.JSON)
    .when()
    .put(resourceURL)
  }

  static Response patch(String resourceURL, String body) {
    return RestAssured
    .given()
    .body(body)
    .log()
    .all()
    .contentType(ContentType.JSON)
    .when()
    .patch(resourceURL)
  }

  static Response delete(String resourceURL) {
    return RestAssured
    .given()
    .when()
    .delete(resourceURL)
  }


}
