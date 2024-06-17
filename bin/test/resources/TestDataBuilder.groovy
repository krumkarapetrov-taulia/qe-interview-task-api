package resources

class TestDataBuilder {

  /**
   * In this class you will have to write methods that will returns the objects that you want to use in your requests
   */


  static String userToDo(int userId, String title, boolean completed) {
    return "  {\n" +
      "    \"userId\": " + userId + ",\n" +
      "    \"title\": \"" + title + "\",\n" +
      "    \"completed\": " + completed + "\n" +
      "  }"
  }

  //Complete the user like the ToDos above

  static String user(String name, String userName, String email) {
    return " {\n" +
      "    \"name\": " + name + ",\n" +
      "    \"username\": " + userName + ",\n" +
      "    \"email\": " + email + ",\n" +
      "    \"address\": {\n" +
      "      \"street\": \"Kulas Light\",\n" +
      "      \"suite\": \"Apt. 556\",\n" +
      "      \"city\": \"Gwenborough\",\n" +
      "      \"zipcode\": \"92998-3874\",\n" +
      "      \"geo\": {\n" +
      "        \"lat\": \"-37.3159\",\n" +
      "        \"lng\": \"81.1496\"\n" +
      "      }\n" +
      "    },\n" +
      "    \"phone\": \"1-770-736-8031 x56442\",\n" +
      "    \"website\": \"hildegard.org\",\n" +
      "    \"company\": {\n" +
      "      \"name\": \"Romaguera-Crona\",\n" +
      "      \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
      "      \"bs\": \"harness real-time e-markets\"\n" +
      "    }\n" +
      "  }"
  }

}
