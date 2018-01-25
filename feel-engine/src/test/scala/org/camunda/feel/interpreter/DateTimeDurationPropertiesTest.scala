package org.camunda.feel.interpreter

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.camunda.feel._

/**
 * @author Philipp Ossler
 */
class DateTimeDurationPropertiesTest extends FlatSpec with Matchers with FeelIntegrationTest {

  "A date" should "has a year property" in {

    eval(""" date("2017-03-10").year """) should be(ValNumber(2017))
  }
  
  it should "has a month property" in {

    eval(""" date("2017-03-10").month """) should be(ValNumber(3))
  }

  it should "has a day property" in {

    eval(""" date("2017-03-10").day """) should be(ValNumber(10))
  }
  
  ///// -----
  
  "A time" should "has a hour property" in {

    eval(""" time("11:45:30+02:00").hour """) should be(ValNumber(11))
  }
  
  it should "has a minute property" in {

    eval(""" time("11:45:30+02:00").minute """) should be(ValNumber(45))
  }
  
  it should "has a second property" in {

    eval(""" time("11:45:30+02:00").second """) should be(ValNumber(30))
  }
  
  it should "has a time_offset property" in {

    eval(""" time("11:45:30+02:00").time_offset """) should be(ValDayTimeDuration("PT2H"))
  }
  
  it should "has a timezone property" in {

    eval(""" time("11:45:30+02:00").timezone """) should be(ValNull)
  }
  
  ///// -----
  
  "A local time" should "has a hour property" in {

    eval(""" time("11:45:30").hour """) should be(ValNumber(11))
  }
  
  it should "has a minute property" in {

    eval(""" time("11:45:30").minute """) should be(ValNumber(45))
  }
  
  it should "has a second property" in {

    eval(""" time("11:45:30").second """) should be(ValNumber(30))
  }
  
  it should "has a time_offset property = null" in {

    eval(""" time("11:45:30").time_offset """) should be(ValNull)
  }
  
  it should "has a timezone property = null" in {

    eval(""" time("11:45:30").timezone """) should be(ValNull)
  }
  
  ///// -----
  
  "A date-time" should "has a year property" in {

    eval(""" date and time("2017-03-10T11:45:30+02:00").year """) should be(ValNumber(2017))
  }
  
  it should "has a month property" in {

    eval(""" date and time("2017-03-10T11:45:30+02:00").month """) should be(ValNumber(3))
  }

  it should "has a day property" in {

    eval(""" date and time("2017-03-10T11:45:30+02:00").day """) should be(ValNumber(10))
  }
  
  it should "has a hour property" in {

    eval(""" date and time("2017-03-10T11:45:30+02:00").hour """) should be(ValNumber(11))
  }
  
  it should "has a minute property" in {

    eval(""" date and time("2017-03-10T11:45:30+02:00").minute """) should be(ValNumber(45))
  }
  
  it should "has a second property" in {

    eval(""" date and time("2017-03-10T11:45:30+02:00").second """) should be(ValNumber(30))
  }
  
  it should "has a time_offset property" in {

    eval(""" date and time("2017-03-10T11:45:30+02:00").time_offset """) should be(ValDayTimeDuration("PT2H"))
  }
  
  it should "has a timezone property" in {

    eval(""" date and time("2017-03-10T11:45:30@Europe/Paris").timezone """) should be(ValString("Europe/Paris"))
  }
  
  ///// -----
  
  "A local date-time" should "has a year property" in {

    eval(""" date and time("2017-03-10T11:45:30").year """) should be(ValNumber(2017))
  }
  
  it should "has a month property" in {

    eval(""" date and time("2017-03-10T11:45:30").month """) should be(ValNumber(3))
  }

  it should "has a day property" in {

    eval(""" date and time("2017-03-10T11:45:30").day """) should be(ValNumber(10))
  }
  
  it should "has a hour property" in {

    eval(""" date and time("2017-03-10T11:45:30").hour """) should be(ValNumber(11))
  }
  
  it should "has a minute property" in {

    eval(""" date and time("2017-03-10T11:45:30").minute """) should be(ValNumber(45))
  }
  
  it should "has a second property" in {

    eval(""" date and time("2017-03-10T11:45:30").second """) should be(ValNumber(30))
  }
  
  it should "has a time_offset property = null" in {

    eval(""" date and time("2017-03-10T11:45:30").time_offset """) should be(ValNull)
  }
  
  it should "has a timezone property = null" in {

    eval(""" date and time("2017-03-10T11:45:30").timezone """) should be(ValNull)
  }
  
  ///// -----
  
  "A year-month-duration" should "has a years property" in {

    eval(""" duration("P2Y3M").years """) should be(ValNumber(2))
  }
  
  it should "has a months property" in {

    eval(""" duration("P2Y3M").months """) should be(ValNumber(3))
  }
  
  ///// -----
  
  "A day-time-duration" should "has a days property" in {

    eval(""" duration("P1DT2H10M30S").days """) should be(ValNumber(1))
  }
  
  it should "has a hours property" in {

    eval(""" duration("P1DT2H10M30S").hours """) should be(ValNumber(2))
  }
  
  it should "has a minutes property" in {

    eval(""" duration("P1DT2H10M30S").minutes """) should be(ValNumber(10))
  }

  it should "has a seconds property" in {

    eval(""" duration("P1DT2H10M30S").seconds """) should be(ValNumber(30))
  }
  
}
