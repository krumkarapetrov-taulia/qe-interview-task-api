package resources

import io.restassured.response.Response

class Users extends HTTPClient{

  final users = '/users'

  TestDataBuilder testDataBuilder = new TestDataBuilder()

  Response createUser() {
    post(users, testDataBuilder.user())
  }



}
