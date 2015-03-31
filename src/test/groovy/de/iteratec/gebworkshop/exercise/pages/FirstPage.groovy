package de.iteratec.gebworkshop.exercise.pages

import geb.Page

class FirstPage extends Page{

    static url = "index.html"

    static at = {
        title == "Demo Application | Main"
    }

}
