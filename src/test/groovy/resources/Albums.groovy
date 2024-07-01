package resources

import io.restassured.response.Response

class Albums extends HTTPClient {

  final albums = '/albums'

  TestDataBuilder testDataBuilder = new TestDataBuilder()

  Response createAlbum(int userId, String title) {
    post(albums, testDataBuilder.userAlbum(userId, title))
  }

  Response getAlbum(int albumId) {
    get(albums, albumId)
  }
}
