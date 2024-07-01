package resources

import io.restassured.response.Response

class ToDos extends HTTPClient {

  final toDos = '/todos'

  TestDataBuilder testDataBuilder = new TestDataBuilder()

  Response createToDo(int userId, String title, boolean completed) {
    post(toDos, testDataBuilder.userToDo(userId, title, completed))
  }

  Response getToDo(int toDoId) {
    get(toDos, toDoId)
  }
}
