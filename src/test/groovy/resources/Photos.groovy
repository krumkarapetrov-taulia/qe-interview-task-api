package resources

import io.restassured.response.Response

class Photos extends HTTPClient {

  final photos = '/photos'

  TestDataBuilder testDataBuilder = new TestDataBuilder()

  Response createPhoto(int albumId, String title, String url, String thumbnailUrl) {
    post(photos, testDataBuilder.userPhoto(albumId, title, url, thumbnailUrl))
  }

  Response getPhoto(int photoId) {
    get(photos, photoId)
  }
}
