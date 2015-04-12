package de.iteratec.gebworkshop.exercise.pages

import geb.Page

class DemoPage extends Page{

    static url = "index.html"

    static at = {
        title == "Demo Application | Main"
    }

}
