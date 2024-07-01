package resources

import io.restassured.response.Response

class Comments extends HTTPClient {

  final comments = '/comments'

  TestDataBuilder testDataBuilder = new TestDataBuilder()

  Response createComment(int postId, String name, String email, String body) {
    post(comments, testDataBuilder.userComment(postId, name, email, body))
  }

  Response getComment(int commentId) {
    get(comments, commentId)
  }
}
