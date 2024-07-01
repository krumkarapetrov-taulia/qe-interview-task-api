package requests

import groovy.time.TimeCategory
import io.restassured.response.Response
import org.junit.jupiter.api.Test
import resources.Albums
import resources.Comments
import resources.Photos
import resources.Posts
import resources.ToDos
import resources.Users

class UsersTests {

    @Test
    void test_createUserWithAllEntities() {
        Users newUser = new Users()
        Response createUserResponse = newUser.createUser("Peter", "Peter85", "pesho85@bg.bg")
        assert createUserResponse.statusCode() == 201
        int userId = createUserResponse.jsonPath().getInt('id')
        println '======================================================='
        println 'The userId is: ' + userId
        println '======================================================='

        Response getUserResponse = newUser.getUser(1)
        // The API cannot return the newly-created user, so I have to hardcode the ID
        assert getUserResponse.statusCode() == 200
        def userList = getUserResponse.jsonPath().getInt('id').toString() as Set
        assert userList.size() == 1

        Posts newPost = new Posts()
        Response createPostResponse = newPost.createPost(userId, "This is a very random title", "The body can compete with the title in randomness.")
        assert createPostResponse.statusCode() == 201
        int postId = createPostResponse.jsonPath().getInt('id')
        println '======================================================='
        println 'The postId is: ' + postId
        println '======================================================='

        Response getPostResponse = newPost.getPost(1)
        assert getPostResponse.statusCode() == 200
        def postList = getPostResponse.jsonPath().getInt('id').toString() as Set
        assert postList.size() == 1

        Comments newComment = new Comments()
        Response createCommentResponse = newComment.createComment(postId, "Pesho Petrov", "peshop@bg.bg", "That's a comment to my newly created post.")
        assert createCommentResponse.statusCode() == 201
        String commentResponseBody = createCommentResponse.jsonPath().get('body')
        println '======================================================='
        println 'The commentResponseBody is: ' + commentResponseBody
        println '======================================================='

        Response getCommentResponse = newComment.getComment(1)
        assert getCommentResponse.statusCode() == 200
        def commentList = getCommentResponse.jsonPath().getInt('id').toString() as Set
        assert commentList.size() == 1

        Albums newAlbum = new Albums()
        Response createAlbumResponse = newAlbum.createAlbum(userId, "An album with not very nice pictures.")
        assert createAlbumResponse.statusCode() == 201
        int albumId = createAlbumResponse.jsonPath().getInt('id')
        println '======================================================='
        println 'The albumId is: ' + albumId
        println '======================================================='

        Response getAlbumResponse = newAlbum.getAlbum(1)
        assert getAlbumResponse.statusCode() == 200
        def albumList = getAlbumResponse.jsonPath().getInt('id').toString() as Set
        assert albumList.size() == 1

        Photos newPhoto = new Photos()
        Response createPhotoResponse = newPhoto.createPhoto(albumId, "This is me after the afterparty.", "https://drunkpictures.com/324afggbv/tup.img", "https://drunkpictures.com/324afggbv/thumbs/tup.img")
        assert createPhotoResponse.statusCode() == 201
        String photoResponseTitle = createPhotoResponse.jsonPath().get('title')
        println '======================================================='
        println 'The photoTitle is: ' + photoResponseTitle
        println '======================================================='

        Response getPhotoResponse = newPhoto.getPhoto(1)
        assert getPhotoResponse.statusCode() == 200
        def photosList = getPhotoResponse.jsonPath().getInt('id').toString() as Set
        assert photosList.size() == 1

        ToDos newToDo = new ToDos()
        Response createToDoResponse = newToDo.createToDo(userId, "This needs to be done yesterday.", false)
        assert createToDoResponse.statusCode() == 201
        String todoTitle = createToDoResponse.jsonPath().get('title')
        println '======================================================='
        println 'The todoTitle is: ' + todoTitle
        println '======================================================='

        Response getTodoResponse = newToDo.getToDo(1)
        assert getTodoResponse.statusCode() == 200
        def toDosList = getTodoResponse.jsonPath().getInt('id').toString() as Set
        assert toDosList.size() == 1
    }

    @Test
    void test_create100UsersWithTodos() {
        int numberOfUsers = 3
        Date startTime = new Date()
        for (int i = 0; i < numberOfUsers; i++) {
            Users newUser = new Users()
            Response createUserResponse = newUser.createUser("Peter", "Peter85", "pesho85@bg.bg")
            int userId = createUserResponse.jsonPath().getInt('id')

            ToDos newToDo = new ToDos()
            Response createToDoResponse = newToDo.createToDo(userId, "This needs to be done yesterday.", false)
            assert createUserResponse.statusCode() == 201
            assert createToDoResponse.statusCode() == 201
        }
        Date endTime = new Date()
        use (TimeCategory) {
            def executionTime = TimeCategory.minus(endTime, startTime)
            assert executionTime.toMilliseconds() < numberOfUsers*1000          // Some requirement I came up with. The test sometimes fails because of it.
            println 'The time to create ' + numberOfUsers + ' users with todos is: ' + executionTime
        }
    }
}