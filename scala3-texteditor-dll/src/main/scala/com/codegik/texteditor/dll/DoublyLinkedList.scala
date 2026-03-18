package com.codegik.texteditor.dll

import scala.collection.mutable.ListBuffer

class DoublyLinkedList[A](value: A) extends NodeList[A] {
  val head: Node[A] = Node(value)

  def insert(elem: A): Unit = {
    val newNode = Node(elem)

    head.prev.foreach { previousNode =>
      previousNode.next = Some(newNode)
    }

    newNode.prev = head.prev
    newNode.next = Some(head)
    head.prev = Some(newNode)
  }

  def remove(k: Int): Int = {
    var count = 0
    while (count < k && head.prev.isDefined) {
      head.prev.foreach { nodeToDelete =>
        val previousNode = nodeToDelete.prev

        previousNode.foreach { node =>
          node.next = Some(head)
        }

        head.prev = previousNode
      }

      count += 1
    }

    count
  }

  def moveLeft(k: Int): Unit = {
    if (k == 0 || head.prev.isEmpty) return

    var segmentStart = head.prev
    var count = 1

    while (count < k && segmentStart.flatMap(_.prev).isDefined) {
      segmentStart = segmentStart.flatMap(_.prev)
      count += 1
    }

    if (segmentStart.isEmpty) return

    segmentStart.foreach { start =>
      head.prev.foreach { end =>
        val newHeadPrev = start.prev
        val oldHeadNext = head.next

        newHeadPrev.foreach(_.next = Some(head))
        head.prev = newHeadPrev

        head.next = Some(start)
        start.prev = Some(head)
        end.next = oldHeadNext
        oldHeadNext.foreach(_.prev = Some(end))
      }
    }
  }

  def moveRight(k: Int): Unit = {
    if (k == 0 || head.next.isEmpty) return

    var segmentEnd = head.next
    var count = 1

    while (count < k && segmentEnd.flatMap(_.next).isDefined) {
      segmentEnd = segmentEnd.flatMap(_.next)
      count += 1
    }

    if (segmentEnd.isEmpty) return

    segmentEnd.foreach { end =>
      head.next.foreach { start =>
        val oldHeadPrev = head.prev
        val newHeadNext = end.next

        head.next = newHeadNext
        newHeadNext.foreach(_.prev = Some(head))

        oldHeadPrev.foreach(_.next = Some(start))
        start.prev = oldHeadPrev
        end.next = Some(head)
        head.prev = Some(end)
      }
    }
  }

  def getLeftElements(maxCount: Int): List[A] = {
    var prev = head.prev
    var count = 0
    var result = List[A]()

    while (count < maxCount && prev.isDefined) {
      prev.foreach { node =>
        result = node.elem :: result
        prev = node.prev
      }
      count += 1
    }

    result
  }

  def getAllElements: List[A] = {
    // Collect elements to the left of cursor
    val leftElements = ListBuffer[A]()
    var leftCurrent = head.prev
    
    while (leftCurrent.isDefined) {
      leftCurrent.foreach { node =>
        leftElements.prepend(node.elem)
        leftCurrent = node.prev
      }
    }
    
    // Collect elements to the right of cursor
    val rightElements = ListBuffer[A]()
    var rightCurrent = head.next
    
    while (rightCurrent.isDefined) {
      rightCurrent.foreach { node =>
        rightElements.append(node.elem)
        rightCurrent = node.next
      }
    }
    
    // Combine left and right elements
    (leftElements ++ rightElements).toList
  }

}
