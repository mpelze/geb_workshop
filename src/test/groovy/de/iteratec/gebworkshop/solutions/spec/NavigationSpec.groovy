package de.iteratec.gebworkshop.solutions.spec

import de.iteratec.gebworkshop.solutions.pages.MainPage
import de.iteratec.gebworkshop.solutions.pages.Page2
import geb.spock.GebReportingSpec
import spock.lang.Ignore

class NavigationSpec extends GebReportingSpec {

    /*
      Exercise 1: Write a test case that checks if clicking "Page 2" on the main page really
      leads you to page 2.
      Hint: To do so, you need 2 page classes (one for the main page, one for page 2). You can check if
      you are at a specific page by using the "at" checker (e.g. then: at Page2).
     */

    def "Changing to page 2 works"() {
        given:
        to MainPage

        when:
        clickMenu "Page 2"

        then:
        at Page2
    }


    /*
      Exercise 2: You can extend your test cases to include several when: then: blocks. This can be
      used to implement scenarios. Write a test case for a simple scenario: Add a backlog item, change to
      the about page, then come back to the main page. (You will see that the added backlog item is gone
      because there is no persistence in this demo app. This is not what the user expects so your test
      should fail).
     */

    @Ignore
    def "Scenario 1"() {
        given:
        to MainPage

        when:
        setName "my item"
        selectEstimate 20
        clickAddButton()

        then:
        backlogItemListIsOfSize 1
        backlogItemListContains "my item"

        when:
        clickMenu "Page 2"

        then:
        at Page2

        when:
        clickMenu "Main"

        then:
        at MainPage
        backlogItemListIsOfSize 1
    }

}
