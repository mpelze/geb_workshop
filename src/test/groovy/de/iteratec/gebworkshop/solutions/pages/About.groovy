package de.iteratec.gebworkshop.solutions.pages

import geb.Page

class About extends Page {

    static url = "about.html"

    static at = {
        title == "Demo Application | About"
    }

    static content = {
        text { $("div", id: "maindiv").find("p").text() }
    }
}
