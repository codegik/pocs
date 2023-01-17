import com.atm.machine.ATM
import com.atm.ui.UIPresenter
import org.scalajs.dom
import org.scalajs.dom.{HTMLDivElement, HTMLHeadingElement, HTMLInputElement, Node, document}

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}

@main def app: Unit =

  document.addEventListener("DOMContentLoaded", { (e: dom.Event) =>
    val presenter = UIPresenter(ATM())
    presenter.present()
  })