package de.iteratec.gebworkshop.solutions.spec

import de.iteratec.gebworkshop.solutions.pages.MainPage
import de.iteratec.gebworkshop.solutions.pages.Page2
import geb.Page
import geb.spock.GebReportingSpec
import spock.lang.Ignore

class ExerciseBSpec extends GebReportingSpec {

    /*
     Exercise 1: Write a test case that checks if adding an item to the
     backlog works (works = it appears in the backlog list at the bottom of the page).
     Hint: To do so you have to write a test case AND the page class.
    */

    def "Adding an item to the backlog works"() {
        given: "I am on the main page"
        to MainPage

        when: "I add a new item with name 'my item' and estimation 20"
        setName "my item"
        selectEstimate 20
        clickAddButton()

        then: "I expect the new item to appear in the item list"
        backlogItemListIsOfSize 1
        backlogItemListContains "my item"
    }

    // Same test case but with some more coding assistance.
    def "Adding an item to the backlog works 2"() {
        given:
        Page page = to MainPage

        when:
        page.setName "my item"
        page.selectEstimate 20
        page.clickAddButton()

        then:
        page.backlogItemListIsOfSize 1
        page.backlogItemListContains "my item"
    }

    // Same test case again but with some more () and ; for a better understanding for Java developers.
    def "Adding an item to the backlog works 3"() {
        given:
        Page page = to(MainPage);

        when:
        page.setName("my item");
        page.selectEstimate(20);
        page.clickAddButton()

        then:
        page.backlogItemListIsOfSize(1);
        page.backlogItemListContains("my item");
    }

    /*
     Exercise 2: Make your test fail to see how nice the assertions errors are the underlying
     spock framework provides.
    */

    @Ignore
    def "Adding an item to the backlog fails if test case is wrong"() {
        given:
        Page page = to(MainPage);

        when:
        page.setName("my item");
        page.selectEstimate(20);
        page.clickAddButton()

        then:
        page.backlogItemListIsOfSize(1);
        page.backlogItemListContains("wrong item");
    }

    /*
     Exercise 3: Write a test case that checks if removing a backlog item from the
     backlog works.
    */

    def "Removing an item from the backlog works"() {
        given: "I am at the main page and add a new item"
        to MainPage
        setName "my item"
        selectEstimate 20
        clickAddButton()

        when: "I remove the item by pressing 'remove' in the item list"
        removeBacklogItem "my item"

        then: "I expect the item list to be empty"
        !backlogItemListIsVisible()
    }

    /*
     Exercise 4: Make your test cases as human readable as possible. You can add String after
     the given: when: then: marks to describe what you are doing.
     */

    def "Removing an item from the backlog works (human readable)"() {
        given: "I go to the main page and add an item"
        to MainPage
        setName "my item"
        selectEstimate 20
        clickAddButton()

        when: "I click the remove button in the backlog list to remove the added item"
        removeBacklogItem "my item"

        then: "I expect the backlog list to be empty"
        !backlogItemListIsVisible()
    }

    /*
     Exercise 5: Write a test case that checks if the filter field on the backlog
     page works (works = entering text in this field filters the backlog list).
     */

    def "filtering the backlog list works"() {
        given:
        to MainPage
        setName "my item"
        selectEstimate 20
        clickAddButton()
        setName "my second item"
        selectEstimate 13
        clickAddButton()
        setName "blubb"
        selectEstimate 5
        clickAddButton()

        when:
        setFilter "item"

        then:
        backlogItemListIsOfSize 2
    }


    /*
    Exercise 6: You can extend your test cases to include several when: then: blocks. This can be
    used to implement scenarios. Write a test case for a simple scenario: Add a backlog item, change to
    the about page, then come back to the main page. (You will see that the added backlog item is gone
    because there is no persistence in this demo app. This is not what the user expects so your test
    should fail).
   */

    @Ignore
    def "Scenario 1"() {
        given: "I am at the main page"
        to MainPage

        when: "I add a new item"
        setName "my item"
        selectEstimate 20
        clickAddButton()

        then: "I expect the item to appear in the item list"
        backlogItemListIsOfSize 1
        backlogItemListContains "my item"

        when: "I then to page 2"
        clickMenu "Page 2"

        then: "I expect to be at page 2"
        at Page2

        when: "I go back to the main page"
        clickMenu "Main"

        then: "I expect the added item to still be there"
        at MainPage
        backlogItemListIsOfSize 1
    }


}
