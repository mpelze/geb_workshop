package de.iteratec.gebworkshop.solutions.spec

import de.iteratec.gebworkshop.solutions.pages.About
import de.iteratec.gebworkshop.solutions.pages.MainPage
import de.iteratec.gebworkshop.solutions.pages.Page2
import geb.spock.GebReportingSpec

class ExerciseASpec extends GebReportingSpec {

    /*
      Exercise 1: Write a test case that checks if clicking "Page 2" on the main page really
      leads you to page 2.
      Hint: To do so, you need 2 page classes (one for the main page, one for page 2). You can check if
      you are at a specific page by using the "at" checker (e.g. then: at Page2).
     */

    def "Changing to page 2 works"() {
        given: "I am at the main page"
        to MainPage

        when: "I click on 'Page 2'"
        clickMenu "Page 2"

        then: "I am on page 2"
        at Page2
    }


    /*
    Exercise 2: Write a test case that checks if the text on the about page starts with "Lorem ipsum".
    Hint: The text is located in a <p> element that has no id. There is only one <p> element in the page
     so that is not really a problem but think about options to really find the correct <p>.
   */

    def "The text on the about page is correct"() {
        when: "I surf to the about page"
        to About

        then: "I expect the main text to start with: Lorem ipsum"
        text.startsWith "Lorem ipsum"
    }

}
