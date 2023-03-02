import java.util.Comparator
import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.language.postfixOps

object main {

  @main def day1() = {
    var input = "1000\n2000\n3000\n\n4000\n\n5000\n6000\n\n7000\n8000\n9000\n\n10000"

    val fileName = "C:\\Users\\Deshawn\\Projekte\\Scalaprojects\\AdventOfcode\\src\\main\\scala\\input.txt"
    input = Source.fromFile(fileName).mkString

    var j = 0
    var cal = ""
    var calElve = 0
    var mostCal = 0

    input = input.replaceAll("\r", "\n")
    var allCals: ListBuffer[Int] = ListBuffer()
    var topThreeCals: ListBuffer[Int] = ListBuffer()

      for i <- input
      do
        //calculate if
        if i.equals('\n') && input.charAt(j + 2).equals('\n') then
          if !cal.equals("") then
          calElve = calElve + Integer.parseInt(cal)

          if calElve > mostCal then
            allCals.append(calElve)
            mostCal = calElve


          calElve = 0
          println(s"Most Cal: $mostCal" )
          cal = ""
        //cal of one elve
        else if i.equals('\n') && !input.charAt(j - 1).equals('\n') then

          calElve = calElve + Integer.parseInt(cal)
          cal = ""


        else if !i.equals('\n') then
          cal = cal.appended(i)

        j = j + 1

      //part2
      //allCals = allCals.sortWith((a: Int, b: Int) => a == b)
      allCals.sorted
      println(allCals)
      topThreeCals.addAll(allCals.reverse.take(3))
      println(topThreeCals.reduce((a: Int, b: Int) => a + b))
      println(topThreeCals.sum)

    val list = List(4, 3, 2, 1)
    val sortedList = list.sorted
    println(sortedList)

  }


}
