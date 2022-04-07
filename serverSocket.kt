/**
 *
 * Name: Baley Wilson
 * Class/Assignment: CS354 Language Website
 * Description: This program demonstrates a simple creation of a server socket in Kotlin that
 * accepts new client connections and spins off a new thread to handle the client. The client can close the server
 * connection by entering "leave".
 * 
 */


import java.io.OutputStream
import java.util.*
import kotlin.concurrent.thread
import java.net.ServerSocket
import java.net.Socket
import java.nio.charset.Charset

/*--------------------Main Method---------------------------- */
fun main(args: Array<String>) {
    // Create a server socket to accept new clients
    val server = ServerSocket(5005)
    println("Server running on port: ${server.localPort}")

    //Continue to accept client connections, no limit on thread number
    while (true) {
        //Accept a new client connection
        val clientConnection = server.accept()
        println("Client connection established: ${client.inetAddress.hostAddress}")

        // Spin up a new thread to handle the client 
        thread { ProcessClientConnection(client).run() }
    }
}

/* Class used to process new client connections */
class ProcessClientConnection(client: Socket) {

    private val output: OutputStream = client.getOutputStream()
    private var isOn: Boolean = false
    private val client: Socket = client
    private val input: Scanner = Scanner(client.getInputStream())

    //Implment the threads run method to process client when server accepts new client connections
    fun run() {
        isOn = true

        //Let client know that server accepted the client connection
        output.write("Successfully connection the the server....\n")

        //Maintain connection to server until client enters exit command
        while (isOn) {
            //read user input for "leave" command
            val userInput = input.nextLine()
                if (userInput == "leave"){
                    isOn = false
                    client.close()
                    println("Client disconnected....")
                    continue
                }
            try {
                //Send a message to the client
                output.write("You are connected to the server.\n")
            }catch(exception: Exception) {
                    //Something went wrong close the connection, print error message
                    client.close()
                    println(exception.message)
            }finally {
                    //After everything close the client connection
                    client.close()
                    println("Bye")
            }
        }
    }
}
