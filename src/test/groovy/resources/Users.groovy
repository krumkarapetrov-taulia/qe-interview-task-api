package resources

import io.restassured.response.Response

class Users extends HTTPClient{

  final users = '/users'

  TestDataBuilder testDataBuilder = new TestDataBuilder()

  Response createUser(String name, String userName, String email) {
    post(users, testDataBuilder.user(name, userName, email))
  }

  Response getUser(int userId) {
    get(users, userId)
  }


}
