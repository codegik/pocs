package com.codegik.pingpong

import java.awt.{Color, Dimension, Font, Graphics, Graphics2D}
import java.awt.event.{ActionEvent, ActionListener, KeyAdapter, KeyEvent}
import javax.swing.{JFrame, JPanel, Timer, WindowConstants}

object PingPong {
  def run(): Unit = {
    val frame = new JFrame("Ping Pong")
    val game = new GamePanel
    frame.add(game)
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    frame.pack()
    frame.setVisible(true)
  }
}

class GamePanel extends JPanel with ActionListener {
  setPreferredSize(new Dimension(800, 600))
  setBackground(Color.BLACK)
  setFocusable(true)

  private val paddleWidth = 15
  private val paddleHeight = 100
  private var leftPaddleY = 250
  private var rightPaddleY = 250
  private var ballX = 400
  private var ballY = 300
  private val ballSize = 20
  private var ballSpeedX = 5
  private var ballSpeedY = 5
  private var leftScore = 0
  private var rightScore = 0

  addKeyListener(new KeyAdapter {
    override def keyPressed(event: KeyEvent): Unit = {
      event.getKeyCode match {
        case KeyEvent.VK_UP => rightPaddleY -= 20
        case KeyEvent.VK_DOWN => rightPaddleY += 20
        case KeyEvent.VK_W => leftPaddleY -= 20
        case KeyEvent.VK_S => leftPaddleY += 20
        case _ =>
      }
    }
  })

  private val timer = new Timer(16, this)
  timer.start()

  override def actionPerformed(event: ActionEvent): Unit = {
    update()
    repaint()
  }

  def update(): Unit = {
    ballX += ballSpeedX
    ballY += ballSpeedY

    if (ballY <= 0 || ballY >= getHeight - ballSize) {
      ballSpeedY = -ballSpeedY
    }
    if (ballX <= paddleWidth && ballY > leftPaddleY && ballY < leftPaddleY + paddleHeight) {
      ballSpeedX = -ballSpeedX
    }
    if (ballX >= getWidth - paddleWidth - ballSize && ballY > rightPaddleY && ballY < rightPaddleY + paddleHeight) {
      ballSpeedX = -ballSpeedX
    }

    if (ballX <= 0) {
      rightScore += 1
      resetBall()
    }
    if (ballX >= getWidth - ballSize) {
      leftScore += 1
      resetBall()
    }

    leftPaddleY = leftPaddleY.max(0).min(getHeight - paddleHeight)
    rightPaddleY = rightPaddleY.max(0).min(getHeight - paddleHeight)
  }

  private def resetBall(): Unit = {
    ballX = getWidth / 2
    ballY = getHeight / 2
    ballSpeedX = if (math.random() < 0.5) 5 else -5
    ballSpeedY = if (math.random() < 0.5) 5 else -5
  }

  override def paintComponent(graphics: Graphics): Unit = {
    super.paintComponent(graphics)
    val g2d = graphics.asInstanceOf[Graphics2D]

    g2d.setColor(Color.WHITE)
    g2d.fillRect(0, leftPaddleY, paddleWidth, paddleHeight)
    g2d.fillRect(getWidth - paddleWidth, rightPaddleY, paddleWidth, paddleHeight)
    g2d.fillOval(ballX, ballY, ballSize, ballSize)
    g2d.setFont(new Font("Arial", Font.BOLD, 30))
    g2d.drawString(s"$leftScore - $rightScore", getWidth / 2 - 40, 50)
  }
}