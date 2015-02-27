package models

/** A cat.
  *
  * @param id Cat identifier (Imgur id)
  * @param link Link to the image (Imgur link)
  */
case class Cat(id: String, link: String)

object Cats {
  var list: List[Cat] = {
    List(
      Cat("54aze1", "test.com"),
      Cat("789aze", "test.com"),
      Cat("324klo", "test.com")
    )
  }
}
