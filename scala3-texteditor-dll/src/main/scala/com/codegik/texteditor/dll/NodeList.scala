package com.codegik.texteditor.dll

private class Node[A](
  val elem: A,
  var next: Option[Node[A]] = None,
  var prev: Option[Node[A]] = None
)

trait NodeList[A] {
  def insert(elem: A): Unit
  def remove(n: Int): Int
  def moveLeft(n: Int): Unit
  def moveRight(n: Int): Unit
  def getLeftElements(maxCount: Int): List[A]
  def getAllElements: List[A]
  def head: Node[A]
}
