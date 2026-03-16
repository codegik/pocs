package com.codegik.texteditor

import com.codegik.texteditor.TextEditor
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TextEditorSpec extends AnyFlatSpec with Matchers {

  "TextEditor" should "handle the basic operations correctly" in {
    val textEditor = TextEditor()

    textEditor.addText("leetcode")
    textEditor.getText shouldBe "leetcode"

    textEditor.deleteText(4) shouldBe 4
    textEditor.getText shouldBe "leet"

    textEditor.addText("practice")
    textEditor.getText shouldBe "leetpractice"

    textEditor.cursorRight(3) shouldBe "etpractice"
    textEditor.getText shouldBe "leetpractice"

    textEditor.cursorLeft(8) shouldBe "leet"
    textEditor.getText shouldBe "leetpractice"

    textEditor.deleteText(10) shouldBe 4
    textEditor.getText shouldBe "practice"

    textEditor.cursorLeft(2) shouldBe ""
    textEditor.getText shouldBe "practice"

    textEditor.cursorRight(6) shouldBe "practi"
    textEditor.getText shouldBe "practice"
  }

  it should "handle empty text editor" in {
    val textEditor = TextEditor()

    val result1 = textEditor.cursorLeft(5)
    result1 shouldBe ""

    val result2 = textEditor.cursorRight(5)
    result2 shouldBe ""

    val deleted = textEditor.deleteText(5)
    deleted shouldBe 0
  }

  it should "handle adding and deleting text" in {
    val textEditor = TextEditor()

    textEditor.addText("hello")
    val result1 = textEditor.cursorLeft(0)
    result1 shouldBe "hello"

    val deleted = textEditor.deleteText(2)
    deleted shouldBe 2

    val result2 = textEditor.cursorLeft(0)
    result2 shouldBe "hel"
  }

  it should "handle cursor movements" in {
    val textEditor = TextEditor()

    textEditor.addText("abcdefghij")
    val result1 = textEditor.cursorLeft(5)
    result1 shouldBe "abcde"

    val result2 = textEditor.cursorRight(3)
    result2 shouldBe "abcdefgh"

    val result3 = textEditor.cursorLeft(10)
    result3 shouldBe ""
  }

  it should "handle more than 10 characters" in {
    val textEditor = TextEditor()

    textEditor.addText("abcdefghijklmnop")
    val result = textEditor.cursorLeft(0)
    result shouldBe "ghijklmnop"
  }
}
