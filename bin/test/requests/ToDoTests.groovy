package requests

import io.restassured.response.Response

import org.junit.jupiter.api.Test
import resources.ToDo
import resources.HTTPClient

class ToDoTests extends ToDo{

  @Test
  void test_createUserToDo() {
    baseURI
    println(baseURI)
  
    def requestBodyUser = TestDataBuilder.user("Bozho", "bozho", "bozho@email.com")
    println(requestBodyUser)
    def requestBodyUserToDo = TestDataBuilder.userToDo(25, "Bozhkata title", true)
    println(requestBodyUserToDo)
    
    Response response = createToDo(1, "Test Title", false)
    response.statusCode() == 200
    response.prettyPrint()
  }
}
