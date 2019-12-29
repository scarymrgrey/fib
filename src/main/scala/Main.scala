
import java.util.{Calendar, Date}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object Main extends App {
  def fib(n: Int): Int =
    n match {
      case 0 => 0
      case 1 => 1
      case _ =>
                val a = Future {
                  fib(n - 1)
                }
                val b = Future {
                  fib(n - 2)
                }
                val r = for {
                  a1 <- a
                  b1 <- b
                } yield a1 + b1

                Await.result(r, Duration.Inf)
        //fib(n - 1) + fib(n - 2)
    }

  val t1 = Calendar.getInstance().getTime.toInstant.getEpochSecond
  println("Start...")
  println(fib(40))
  println(Calendar.getInstance().toInstant.getEpochSecond - t1)
}
