package com.codegik.texteditor

import com.codegik.texteditor.dll.DoublyLinkedList

class TextEditor {
  private val dll = DoublyLinkedList[Char]('|')

  def addText(text: String): Unit = {
    for (c <- text) {
      dll.insert(c)
    }
  }

  def deleteText(k: Int): Int = {
    dll.remove(k)
  }

  def cursorLeft(k: Int): String = {
    dll.moveLeft(k)
    val elements = dll.getLeftElements(10)
    elements.mkString
  }

  def cursorRight(k: Int): String = {
    dll.moveRight(k)
    val elements = dll.getLeftElements(10)
    elements.mkString
  }

  def getText: String = {
    dll.getAllElements.mkString
  }

}
