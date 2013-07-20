package com.iamtrask.saddle

/**
 * Description of file content.
 *
 * @author atrask
 *         7/20/13
 */


import java.io._
import java.net.{InetAddress,ServerSocket,Socket,SocketException}


object SocketServer
{

    val port = 6669

    try
    {
      val listener = new ServerSocket(port)
      var numClients = 1

      println("Listening on port " + port)

      while (true)
      {
        new ClientHandler(listener.accept(), numClients).start()
        numClients += 1
      }

      listener.close()
    }
    catch
      {
        case e: IOException =>
          System.err.println("Could not listen on port: " + port + ".")
          System.exit(-1)
      }



}


