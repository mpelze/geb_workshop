package de.iteratec.gebworkshop.solutions.pages

import geb.Page

class Page2 extends Page {

    static url = "page2.html"

    static at = {
        title == "Demo Application | Page 2"
    }

    def clickMenu(String menuEntry) {
        $("a", id: menuEntry).click()
    }
}
