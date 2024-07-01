package resources

import io.restassured.response.Response

class Posts extends HTTPClient {

  final posts = '/posts'

  TestDataBuilder testDataBuilder = new TestDataBuilder()

  Response createPost(int userId, String title, String body) {
    post(posts, testDataBuilder.userPost(userId, title, body))
  }

  Response getPost(int postId) {
    get(posts, postId)
  }
}
