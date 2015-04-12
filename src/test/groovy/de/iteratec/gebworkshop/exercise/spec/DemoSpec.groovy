package de.iteratec.gebworkshop.exercise.spec

import de.iteratec.gebworkshop.exercise.pages.DemoPage
import geb.spock.GebReportingSpec

class DemoSpec extends GebReportingSpec {


    def "visiting the demo app start page works"() {
        when:
        to DemoPage

        then:
        at DemoPage
    }

}
