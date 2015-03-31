package de.iteratec.gebworkshop.exercise.spec

import de.iteratec.gebworkshop.exercise.pages.FirstPage
import geb.spock.GebReportingSpec

class FirstSpec extends GebReportingSpec {


    def "visiting the demo app start page works"() {
        when:
        to FirstPage

        then:
        at FirstPage
    }

}
