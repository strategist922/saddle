package com.iamtrask.saddle

import java.net.{SocketException, Socket}
import java.io.{IOException, InputStreamReader, BufferedReader, PrintWriter}
import scala.actors.Actor
import scala.actors.Actor._

/**
 * Description of file content.
 *
 * @author atrask
 *         7/20/13
 */
class ClientHandler(socket: Socket, clientId: Int) extends Actor {
  def act {
    try {
      val out = new PrintWriter(socket.getOutputStream(), true)
      val in = new BufferedReader(new InputStreamReader(socket.getInputStream()))

      print("Client connected from " + socket.getInetAddress() + ":" + socket.getPort)
      println(" assigning id " + clientId)

      var inputLine = in.readLine()
      while (inputLine != null) {
        println(clientId + ") " + inputLine)
        out.print("hey\n")
        out.flush()
        inputLine = in.readLine()
      }

      socket.close()

      println("Client " + clientId + " quit")
    }
    catch {
      case e: SocketException =>
        System.err.println(e)

      case e: IOException =>
        System.err.println(e.printStackTrace())

      case e =>
        System.err.println("Unknown error " + e)
    }
  }
}
