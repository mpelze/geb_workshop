package de.iteratec.gebworkshop.solutions.pages

import geb.Page
import org.openqa.selenium.Keys

class MainPage extends Page{

    static url = "index.html"

    static at = {
        title == "Demo Application | Main"
    }

    static content = {
        inputName { $("input", id: "name") }
        inputEstimate { $("select", id: "estimate") }
        inputFilter { $("input", id: "filter") }
        buttonAdd { $("button", text: "add") }
        backlogItemList { $("table", class: "table-striped").find("tr") }
    }


    def setName(String name) {
        // Remove already existing text in the input field.
        inputName << Keys.chord(Keys.CONTROL, "a")
        inputName << Keys.chord(Keys.DELETE)

        // Set the new value.
        inputName << name
    }

    def setFilter(String filter) {
        inputFilter << filter
    }

    def selectEstimate(int value) {
        inputEstimate << "" + value
    }

    def clickAddButton() {
        buttonAdd.click()
    }

    boolean backlogItemListIsOfSize(int size) {
        return backlogItemList.size() == size
    }

    boolean backlogItemListIsVisible() {
        return $("table", class: "table-striped").find("tbody").children().size() > 0
    }

    boolean backlogItemListContains(String itemName) {
        // The * in the following line is the groovy spread operator. Find returns
        // a collection and the * calls .text() on each object of this collection
        // and puts all results of .text() into one collection.
        return backlogItemList.find("td")*.text().contains(itemName)
    }

    def removeBacklogItem(String itemName) {
        backlogItemList*.has("td", text: itemName).get(0).find("button").click()
    }

    def clickMenu(String menuEntry) {
       $("a", id: menuEntry).click()
    }

}
